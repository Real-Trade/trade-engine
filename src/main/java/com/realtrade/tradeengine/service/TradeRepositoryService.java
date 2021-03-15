package com.realtrade.tradeengine.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import realtreade.tradeengine.Status;
import realtreade.tradeengine.Trade;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class TradeRepositoryService {
    private static final Map<String, Trade> trades = new HashMap<>();

    @PostConstruct
    public void initData() {
        for(int i = 0; i < 5; i ++) {
            Trade trade = new Trade();
            trade.setTradeId(i+"L");
            if(i % 2 == 0) {
                trade.setStatus(Status.CANCELLED);
            } else {
                trade.setStatus(Status.ONGOING);
            }
            trades.put(trade.getTradeId(), trade);
        }
    }

    public Trade findTrade(String id) {
        Assert.notNull(id, "Id must be provided!");
        return trades.get(id);
    }
}
