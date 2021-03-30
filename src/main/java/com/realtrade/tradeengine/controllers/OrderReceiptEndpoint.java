package com.realtrade.tradeengine.controllers;

import com.realtrade.tradeengine.config.RedisPoolConfig;
import com.realtrade.tradeengine.models.Order;
import com.realtrade.tradeengine.services.TradeExecutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import realtrade.tradeengine.soap_ws.CreateOrderRequest;
import realtrade.tradeengine.soap_ws.OrderResponse;
import redis.clients.jedis.Jedis;

import java.util.List;


@Endpoint
public class OrderReceiptEndpoint {
    private static final Logger log = LoggerFactory.getLogger(OrderReceiptEndpoint.class);
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
        Order newOrder = new Order();
        try{
            newOrder = tradeExecutionService.createOrderFromSoap(request.getOrder());
            response.setStatus(200);
            response.setMessage("Order received successfully");
        } catch (Exception e) {
            log.error(e + "");
            response.setStatus(400);
            response.setMessage(e.getMessage());
        }
        tradeExecutionService.handleClientOrder(newOrder);
        return response;
    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createOrderRequest")
//    @ResponsePayload
//    public OrderResponse updateOrder(@RequestPayload CreateOrderRequest request) {
//        OrderResponse response = new OrderResponse();
//        tradeExecutionService.createOrderFromSoap(request.getOrder());
//        response.setStatus(200);
//        response.setMessage("Order received successfully");
//        return response;
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createOrderRequest")
//    @ResponsePayload
//    public OrderResponse cancelOrder(@RequestPayload CreateOrderRequest request) {
//        OrderResponse response = new OrderResponse();
//        tradeExecutionService.createOrderFromSoap(request.getOrder());
//        response.setStatus(200);
//        response.setMessage("Order received successfully");
//        return response;
//    }
}
