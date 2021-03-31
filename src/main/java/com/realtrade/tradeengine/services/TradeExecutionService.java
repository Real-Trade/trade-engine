package com.realtrade.tradeengine.services;

import com.realtrade.tradeengine.controllers.ExchangeConnectivityClient;
import com.realtrade.tradeengine.controllers.MalExClientManager;
import com.realtrade.tradeengine.dto.ExchangeOrderDto;
import com.realtrade.tradeengine.dto.MarketDataDto;
import com.realtrade.tradeengine.models.*;
import com.realtrade.tradeengine.repositories.ClientDao;
import com.realtrade.tradeengine.repositories.PortfolioDao;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeExecutionService {
    private  static final Logger log = LoggerFactory.getLogger(TradeExecutionService.class);
    private MalExClientManager clientManager;
    private ExchangeConnectivityClient connectivityClient;
    List<ExchangeOrderDto> exchangeOne = new ArrayList();
    List<ExchangeOrderDto> exchangeTwo = new ArrayList();
    private Subscriber<ExchangeOrderDto> malexOneSubscriber;
    private Subscriber<ExchangeOrderDto> malexTwoSubscriber;
    private Order currentOrder;
    private PortfolioDao portfolioDao;
    private ClientDao clientDao;

    @Autowired
    public TradeExecutionService(MalExClientManager clientManager, ExchangeConnectivityClient connectivityClient, PortfolioDao portfolioDao, ClientDao clientDao) {
        this.clientManager = clientManager;
        this.connectivityClient = connectivityClient;
        malexOneSubscriber = initSubscriber(MallonExchange.MALEX1);
        malexTwoSubscriber = initSubscriber(MallonExchange.MALEX2);
        this.portfolioDao = portfolioDao;
        this.clientDao = clientDao;
    }

    private Subscriber<ExchangeOrderDto> initSubscriber(MallonExchange exchange) {
        return new Subscriber<ExchangeOrderDto>() {
            private Subscription subscription;
            private MallonExchange currentExchange;

            @Override
            public void onSubscribe(Subscription s) {
                subscription = s;
                currentExchange = exchange;
                subscription.request(1);
            }

            @Override
            public void onNext(ExchangeOrderDto exchangeOrderDto) {
                log.info("Fetching next exchange order...");
                if (currentExchange == MallonExchange.MALEX1) {
                    exchangeOne.add(exchangeOrderDto);
                } else {
                    exchangeTwo.add(exchangeOrderDto);
                }
                subscription.request(1);
            }

            @Override
            public void onError(Throwable t) {
                log.error("Error fetching orderbooks: " + t.toString());
            }

            @Override
            public void onComplete() {
//                if (currentExchange == MallonExchange.MALEX1) return;
                log.info("Orderbook 1 size: "+ exchangeOne.size());
                getBestExchange();
            }
        };
    }

    public void handleMarketUpdate(List<MarketDataDto> marketDataDtos) {
        //
    }

    public void fetchOrderBook() {
        Product product = currentOrder.getProduct();
        switch(currentOrder.getSide()) {
            case BUY:
                log.info("client buying order...");
                clientManager.getSellOrders(product, MallonExchange.MALEX1)
                        .sort(Comparator.comparingDouble(ExchangeOrderDto::getPrice))
                        .subscribe(malexOneSubscriber);
//                clientManager.getSellOrders(product, MallonExchange.MALEX2)
//                        .sort(Comparator.comparingDouble(ExchangeOrderDto::getPrice))
//                        .subscribe(malexTwoSubscriber);
                break;
            case SELL:
                log.info("client selling order...");
                clientManager.getBuyOrders(product, MallonExchange.MALEX1)
                        .sort(Comparator.comparingDouble(ExchangeOrderDto::getPrice))
                        .subscribe(malexOneSubscriber);
//                clientManager.getBuyOrders(product, MallonExchange.MALEX2)
//                        .sort(Comparator.comparingDouble(ExchangeOrderDto::getPrice).reversed())
//                        .subscribe(malexTwoSubscriber);
                break;
            default:
                log.debug("Unknown order");
        }
    }

    public void handleClientOrder(Order order) {
        this.currentOrder = order;
        log.info("Fetching order books");
        fetchOrderBook();
    }

    public void handleOrderSplitting() {
        List<ClientOrder> orders = new OrderSplittingService(exchangeOne, exchangeTwo, currentOrder).getOrderSplitting();
    }

    public void getBestExchange() {
        MallonExchange bestExchange = null;
        switch (currentOrder.getSide()) {
            case SELL:
                bestExchange = new BestValueExchange(exchangeOne, exchangeTwo, currentOrder).compareBuyPrices();
            case BUY:
                bestExchange = new BestValueExchange(exchangeOne, exchangeTwo, currentOrder).compareSellPrices();
        }

        ClientOrder clientOrder = currentOrder.getClientOrderRepresentation();
        clientOrder.setExchangeName(bestExchange.name());
        //forward to exchange connectivity
        log.info("Best exchange is: " + bestExchange.name());
        connectivityClient.pushToQueue(clientOrder);
    }

    public Order createOrderFromSoap(realtrade.tradeengine.soap_ws.Order soapOrder) {
        ClientOrder order = new ClientOrder();
        Client client = clientDao.findById(soapOrder.getClientId()).orElseThrow();
        Portfolio portfolio = portfolioDao.findById(soapOrder.getPortfolioId()).orElseThrow();
        order.setCreatedAt(OffsetDateTime.parse(soapOrder.getCreatedAt()));
        order.setClient(client);
        order.setExchangeOrderId(soapOrder.getExchangeOrderId());
        order.setStatus(soapOrder.getStatus());
        order.setCumulativeQuantity(soapOrder.getCumulativeQuantity());
        order.setExchangeName(soapOrder.getExchangeName());
        order.setPortfolio(portfolio);
        order.setQuantity(soapOrder.getQuantity());
        order.setSide(soapOrder.getSide());
        order.setPrice(soapOrder.getPrice());
        order.setProduct(soapOrder.getProduct());
        log.info(order.toString());
        return order.getLocalRepresentation();
    }

}
