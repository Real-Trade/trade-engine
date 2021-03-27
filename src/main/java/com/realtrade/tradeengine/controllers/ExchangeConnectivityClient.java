package com.realtrade.tradeengine.controllers;

import com.realtrade.tradeengine.models.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ExchangeConnectivityClient {
    private WebClient webClient;

    public ExchangeConnectivityClient() {

    }

    public void createOrderRequest(Order order) {

    }

    public void updateOrderRequest() {

    }

    public void cancelOrderRequest() {

    }

}
