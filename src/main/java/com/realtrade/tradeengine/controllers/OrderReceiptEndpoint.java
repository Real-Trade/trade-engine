package com.realtrade.tradeengine.controllers;

import com.realtrade.tradeengine.repositories.OrderDao;
import com.realtrade.tradeengine.services.TradeExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import realtrade.tradeengine.soap_ws.CreateOrderRequest;
import realtrade.tradeengine.soap_ws.OrderResponse;

@Endpoint
public class OrderReceiptEndpoint {

    private static final String NAMESPACE_URI =
            "http://realtrade/tradeengine/soap-ws";
    private TradeExecutionService tradeExecutionService;

    @Autowired
    private OrderReceiptEndpoint(TradeExecutionService tradeExecutionService) {
        this.tradeExecutionService = tradeExecutionService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createOrderRequest")
    @ResponsePayload
    public OrderResponse createOrder(@RequestPayload CreateOrderRequest request) {
        OrderResponse response = new OrderResponse();
        tradeExecutionService.createOrderFromSoap(request.getOrder());
        response.setStatus(200);
        response.setMessage("Order received successfully");
        return response;
    }
}
