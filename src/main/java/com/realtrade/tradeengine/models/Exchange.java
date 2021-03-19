package com.realtrade.tradeengine.models;

import java.util.List;

public class Exchange {
    private String name;
    private List<String> tickerList;
    private MallonExchange exchange;
    private List<Order> orderBook;

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

    public List<Order> getOrderBook() {
        return orderBook;
    }

    public void setOrderBook(List<Order> orderBook) {
        this.orderBook = orderBook;
    }

}

