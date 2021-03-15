package com.realtrade.tradeengine.endpoint;

import com.realtrade.tradeengine.service.TradeRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import realtreade.tradeengine.GetTradeRequest;
import realtreade.tradeengine.GetTradeResponse;

@Endpoint
public class TradeEndpoint {

    private static final String NAMESPACE_URI =
            "http://realtrade/tradeengine";

    private TradeRepositoryService tradeRepositoryService;

    @Autowired
    public TradeEndpoint(TradeRepositoryService tradeRepositoryService) {
        this.tradeRepositoryService = tradeRepositoryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTradeRequest")
    @ResponsePayload
    public GetTradeResponse getTrade(@RequestPayload GetTradeRequest request) {
        GetTradeResponse response = new GetTradeResponse();
        response.setTrade(tradeRepositoryService.findTrade(request.getTradeId()));
        return response;
    }
}