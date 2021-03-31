package com.realtrade.tradeengine.controllers;

import com.realtrade.tradeengine.dto.ExchangeOrderDto;
import com.realtrade.tradeengine.dto.MarketDataDto;
import com.realtrade.tradeengine.models.Exchange;
import com.realtrade.tradeengine.models.MallonExchange;
import com.realtrade.tradeengine.models.Product;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin("*")
public class MarketDataController {
    private  static final Logger log = LoggerFactory.getLogger(MarketDataController.class);

    @Autowired
    public MarketDataController(Exchange One, Exchange Two) {

    }

    @PostMapping(path = "/malex1/md")
    public void exchange1MarketState(@RequestBody List<MarketDataDto> mdList) {
        //add exchange data
        log.info("MD size: " + mdList.size());
        //
    }

    @PostMapping(path = "/malex2/md")
    public void exchange2MarketState(@RequestBody List<MarketDataDto> mdList) {
        log.info("MD size: " + mdList.size());
    }


    @GetMapping(path ="/test-redis")
    public void testRedis(){

    }
}
