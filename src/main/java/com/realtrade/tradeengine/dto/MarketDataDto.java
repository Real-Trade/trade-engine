package com.realtrade.tradeengine.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketDataDto {
    @JsonProperty(value = "LAST_TRADED_PRICE")
    private double lastTradedPrice;
    @JsonProperty(value = "BID_PRICE")
    private double bidPrice;
    @JsonProperty(value = "SELL_LIMIT")
    private int sellLimit;
    @JsonProperty(value = "BUY_LIMIT")
    private int buyLimit;
    @JsonProperty(value = "MAX_PRICE_SHIFT")
    private double maxPriceShift;
    @JsonProperty(value = "TICKER")
    private String ticker;
    @JsonProperty(value = "ASK_PRICE")
    private double askPrice;

    public MarketDataDto() {}

    public MarketDataDto(double last_traded_price, double bid_price, int sell_limit, int buy_limit, double max_price_shift, String ticker, double ask_price) {
        lastTradedPrice = last_traded_price;
        bidPrice = bid_price;
        sellLimit = sell_limit;
        buyLimit = buy_limit;
        maxPriceShift = max_price_shift;
        ticker = ticker;
        askPrice = ask_price;
    }

    public double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getSellLimit() {
        return sellLimit;
    }

    public void setSellLimit(int sellLimit) {
        this.sellLimit = sellLimit;
    }

    public int getBuyLimit() {
        return buyLimit;
    }

    public void setBuyLimit(int buyLimit) {
        this.buyLimit = buyLimit;
    }

    public double getMaxPriceShift() {
        return maxPriceShift;
    }

    public void setMaxPriceShift(double maxPriceShift) {
        this.maxPriceShift = maxPriceShift;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    @Override
    public String toString() {
        return "MarketDataDto{" +
                "lastTradedPrice=" + lastTradedPrice +
                ", bidPrice=" + bidPrice +
                ", sellLimit=" + sellLimit +
                ", buyLimit=" + buyLimit +
                ", maxPriceShift=" + maxPriceShift +
                ", ticker='" + ticker + '\'' +
                ", askPrice=" + askPrice +
                '}';
    }
}
