package com.realtrade.tradeengine.trade;

public class Trade {
    private Long id;
    private Long clientId;
    private int volume;
    private double price;

    public Trade() {

    }
    public Trade(Long id, Long clientId, int volume, double price) {
        this.id = id;
        this.clientId = clientId;
        this.volume = volume;
        this.price = price;
    }

    public Trade(Long clientId, int volume, double price) {
        this.clientId = clientId;
        this.volume = volume;
        this.price = price;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
