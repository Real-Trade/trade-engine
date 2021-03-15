package com.realtrade.tradeengine.service;

import com.realtrade.tradeengine.model.Trade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    public List<Trade> getTrades() {
        return List.of(
                new Trade(1L, 1L, 400, 4.0),
                new Trade(2L, 1L, 150, 5.1)
        );
    }
}
