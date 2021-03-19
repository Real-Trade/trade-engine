package com.realtrade.tradeengine.controllers;

import com.realtrade.tradeengine.dto.MarketDataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MarketDataController {
    private  static final Logger log = LoggerFactory.getLogger(MarketDataController.class);

    @PostMapping(path = "/malex1/md")
    public void exchange1MarketState(@RequestBody MarketDataDto currentMD) {

        log.info(currentMD.toString()   );
    }

    @PostMapping(path = "/malex2/md")
    public void exchange2MarketState(@RequestBody String orderDto) {
        log.info(orderDto);
    }

    private class MarketDataWrapper {
        private ArrayList<MarketDataDto> stockList;
    }

}
