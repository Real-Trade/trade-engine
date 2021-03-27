package com.realtrade.tradeengine.services;

import com.realtrade.tradeengine.dto.ExchangeOrderDto;
import com.realtrade.tradeengine.models.MallonExchange;
import com.realtrade.tradeengine.models.Order;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderSplittingService {

    private List<ExchangeOrderDto> exchange1;
    private List<ExchangeOrderDto> exchange2;
    private Order currentClientOrder;

    public OrderSplittingService() {
    }

    public Map<MallonExchange, Integer> getOrderSplitting() {
        List<ExchangeOrderDto> totalExchangeOrders = exchange1.subList(0, exchange1.size());
        totalExchangeOrders.addAll(exchange2.subList(0, exchange2.size()));
        totalExchangeOrders.sort(Comparator.comparingDouble(ExchangeOrderDto::getPrice));

        Map<MallonExchange, Integer> matchingOrders = new HashMap<>();
        int cumulativeQuantity = 0;
        int currentOrderIndex = 0;

        while(cumulativeQuantity < currentClientOrder.getQuantity()) {
           ExchangeOrderDto currentBest = totalExchangeOrders.get(currentOrderIndex);
           int availableQuantity = currentBest.getQuantity() - currentBest.getCumulativeQuantity();
           cumulativeQuantity += availableQuantity;
           MallonExchange targetExchange = exchange1.contains(currentBest) ? MallonExchange.MALEX1 : MallonExchange.MALEX2;
            matchingOrders.computeIfPresent( targetExchange, (key, val) -> val + availableQuantity);
            matchingOrders.computeIfAbsent(targetExchange, k -> currentBest.getQuantity());
        }
        return matchingOrders;
    }

    public void createSubOrders() {

    }



}
