package com.realtrade.tradeengine.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realtrade.tradeengine.config.RedisPoolConfig;
import com.realtrade.tradeengine.models.ClientOrder;
import com.realtrade.tradeengine.models.Order;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import redis.clients.jedis.Jedis;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
public class ExchangeConnectivityClient {
    private static final Logger log = LoggerFactory.getLogger(ExchangeConnectivityClient.class);
    private WebClient exchangeClient;

    @Autowired
    public ExchangeConnectivityClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .followRedirect(true)
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));
        exchangeClient = WebClient.builder().baseUrl("https://rt-exchange-connectivity/herokuapp.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient)).build();
    }

    public boolean pushToQueue(ClientOrder order) {
        try(Jedis jedis = RedisPoolConfig.getJedisPool().getResource()) {
            jedis.rpush("trade-order-queue", order.toString());
            log.debug("Message Pushed");
        } catch (Exception e) {
            log.info("jedis push failed: "+ e.getMessage());
        }
        return true;
    }

}
