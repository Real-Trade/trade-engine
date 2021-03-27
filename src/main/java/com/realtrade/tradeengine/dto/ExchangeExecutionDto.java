package com.realtrade.tradeengine.dto;

public class ExchangeExecutionDto {
    private String timestamp;
    private double price;
    private int quantity;

    public ExchangeExecutionDto() {}

    public ExchangeExecutionDto(String timestamp, double price, int quantity) {
        this.timestamp = timestamp;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ExchangeExecutionDto{" +
                "timestamp='" + timestamp + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
