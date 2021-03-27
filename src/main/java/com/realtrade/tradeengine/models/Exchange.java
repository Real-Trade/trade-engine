package com.realtrade.tradeengine.models;

import com.realtrade.tradeengine.dto.MarketDataDto;
import com.realtrade.tradeengine.dto.ExchangeOrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Exchange {
    private String name;
    private String url;
    private List<String> tickerList;
    private MallonExchange exchange;
    private Map<String, List<ExchangeOrderDto>> orderBooks;
    private List<MarketDataDto> currentMarketState;

    public Exchange() {}

    public Exchange(String name, MallonExchange exchange, String url,
                    List<String> tickerList) {
        this.name = name;
        this.exchange = exchange;
        this.url = url;
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

    public Map<String, List<ExchangeOrderDto>> getOrderBooks() {
        return orderBooks;
    }

    public void setOrderBooks(Map<String, List<ExchangeOrderDto>> orderBooks) {
        this.orderBooks = orderBooks;
    }
    
    public List<ExchangeOrderDto> getOrderBookByTicker(String ticker) {
        return orderBooks.get(ticker);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MarketDataDto> getCurrentMarketState() {
        return currentMarketState;
    }

    public void setCurrentMarketState(List<MarketDataDto> currentMarketState) {
        this.currentMarketState = currentMarketState;
    }
}

