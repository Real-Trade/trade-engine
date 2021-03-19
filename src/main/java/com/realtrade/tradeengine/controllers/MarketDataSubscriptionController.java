package com.realtrade.tradeengine.controllers;

import com.realtrade.tradeengine.dto.MDOrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketDataSubscriptionController {
    private  static final Logger log = LoggerFactory.getLogger(MarketDataSubscriptionController.class);

    @PostMapping(path = "/malex1/md")
    public void exchange1MarketState(@RequestBody String orderDto) {
        log.info(orderDto);
    }

    @PostMapping(path = "/malex2/md")
    public void exchange2MarketState(@RequestBody String orderDto) {
        log.info(orderDto);
    }

}
