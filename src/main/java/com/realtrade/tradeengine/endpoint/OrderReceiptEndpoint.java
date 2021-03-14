package com.realtrade.tradeengine.endpoint;

import com.realtrade.tradeengine.trade.Trade;
import com.realtrade.tradeengine.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/clients")
public class OrderReceiptEndpoint {

    private final TradeService tradeService;

    @Autowired
    public OrderReceiptEndpoint(TradeService tradeService) {
        this.tradeService = tradeService;
    }


    @GetMapping()
    public List<Trade> getTrades() {
        return tradeService.getTrades();
    }
}
