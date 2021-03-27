package com.realtrade.tradeengine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ExchangeOrderDto {
    @JsonProperty(value = "product")
    private String product;
    @JsonProperty(value = "quantity")
    private int quantity;
    @JsonProperty(value = "price")
    private double price;
    @JsonProperty(value = "side")
    private String side;
    @JsonProperty(value = "executions")
    private ArrayList<ExchangeExecutionDto> executions;
    @JsonProperty(value = "cumulatitiveQuantity")
    private int cumulativeQuantity;

    public ExchangeOrderDto() {}

    public ExchangeOrderDto(String product, int quantity, double price, String side, ArrayList<ExchangeExecutionDto> executions, int cumulativeQuantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
        this.executions = executions;
        this.cumulativeQuantity = cumulativeQuantity;
    }

    public ArrayList<ExchangeExecutionDto> getExecutions() {
        return executions;
    }

    public double getPrice() {
        return price;
    }

    public String getProduct() {
        return product;
    }

    public int getCumulativeQuantity() {
        return cumulativeQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "ExchangeOrderDto{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", side='" + side + '\'' +
                ", executions=" + (executions.size() > 0 ? executions.get(0).toString() : executions.toString()) +
                ", cumulativeQuantity=" + cumulativeQuantity +
                '}';
    }
}
