package com.realtrade.tradeengine.models;

import com.realtrade.tradeengine.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Exchange {
    private String name;
    private List<String> tickerList;
    private MallonExchange exchange;
    private List<OrderDto> orderDtoBook;

    public Exchange() {}

    public Exchange(String name, MallonExchange exchange, List<String> tickerList) {
        this.name = name;
        this.exchange = exchange;
        this.tickerList = tickerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> getTickerList() {
        return tickerList;
    }

    public void setTickerList(List<String> tickerList) {
        this.tickerList = tickerList;
    }

    public MallonExchange getExchange() {
        return exchange;
    }

    public List<OrderDto> getOrderBook() {
        return orderDtoBook;
    }

    public void setOrderBook(List<OrderDto> orderDtoBook) {
        this.orderDtoBook = orderDtoBook;
    }

}

