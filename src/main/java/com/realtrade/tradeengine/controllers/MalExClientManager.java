package com.realtrade.tradeengine.controllers;

import com.realtrade.tradeengine.dto.ExchangeOrderDto;
import com.realtrade.tradeengine.models.*;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
public class MalExClientManager {
    private  static final Logger log = LoggerFactory.getLogger(MalExClientManager.class);
    private WebClient exchange1Client;
    private WebClient exchange2Client;

    public MalExClientManager() {
        Exchange one = MalExOne.getMalexOne();
        Exchange two = MalExTwo.getMalExTwo();
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .followRedirect(true)
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));
        log.info(one.getUrl());
        exchange1Client = WebClient.builder().baseUrl(one.getUrl()).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).clientConnector(new ReactorClientHttpConnector(httpClient)).build();
        exchange2Client = WebClient.builder().baseUrl(two.getUrl()).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).clientConnector(new ReactorClientHttpConnector(httpClient)).build();

    }

    public Flux<ExchangeOrderDto> getFullOrderBook(MallonExchange targetExchange) {
        return getWebClient(targetExchange).get().uri("/orderbook")
                .exchangeToFlux(response -> response.bodyToFlux(ExchangeOrderDto.class));
    }

    public Flux<ExchangeOrderDto> getOrdersByProduct(Product product, MallonExchange targetExchange) {
        return getWebClient(targetExchange).get().uri("/orderbook/" +
                product.name()).exchangeToFlux(response -> response.bodyToFlux(ExchangeOrderDto.class));
    }

    public Flux<ExchangeOrderDto> getOpenOrders(Product product, MallonExchange targetExchange) {
        return getWebClient(targetExchange).get().uri("/orderbook/" +
                product.name() + "/open").exchangeToFlux(response -> response.bodyToFlux(ExchangeOrderDto.class));
    }

    public Flux<ExchangeOrderDto> getCancelledOrders(Product product, MallonExchange targetExchange) {
        return getWebClient(targetExchange).get().uri("/orderbook/" +
                product.name() + "/cancelled").exchangeToFlux(response -> response.bodyToFlux(ExchangeOrderDto.class));
    }

    public Flux<ExchangeOrderDto> getBuyOrders(Product product, MallonExchange targetExchange) {
        return getWebClient(targetExchange).get().uri("/orderbook/" +
                product.name() + "/buy").exchangeToFlux(response -> response.bodyToFlux(ExchangeOrderDto.class));
    }

    public Flux<ExchangeOrderDto> getSellOrders(Product product, MallonExchange targetExchange) {
        return getWebClient(targetExchange).get().uri("/orderbook/" +
                product.name() + "/sell").exchangeToFlux(response -> response.bodyToFlux(ExchangeOrderDto.class));
    }

    public Flux<ExchangeOrderDto> getClosedOrders(Product product, MallonExchange targetExchange) {
        return getWebClient(targetExchange).get().uri("/orderbook/" +
                product.name() + "/closed").exchangeToFlux(response -> response.bodyToFlux(ExchangeOrderDto.class));
    }

    private WebClient getWebClient(MallonExchange exchange) {
        switch (exchange) {
            case MALEX1:
                return exchange1Client;
            case MALEX2:
                return exchange2Client;
            default:
                log.error("Unknown exchange");
                return null;
        }
    }

}
