package com.realtrade.tradeengine.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.realtrade.tradeengine.models.Order;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "client_order")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "orderId")
    private int orderId;
    @JsonProperty(value = "side")
    private String side;
    @JsonProperty(value = "quantity")
    private int quantity;
    @JsonProperty(value = "price")
    private double price;
    @JsonProperty(value = "clientId")
    private int clientId;
    @JsonProperty(value = "portfolioId")
    private int portfolioId;
    @JsonProperty(value = "status")
    private String status;
    @JsonProperty(value = "product")
    private String product;
    @JsonProperty(value = "exchangeOrderId")
    private String exchangeOrderId;
    @JsonProperty(value = "createdAt")
    private LocalDate createdAt;
    @JsonProperty(value = "updatedAt")
    private LocalDate updatedAt;

    public OrderDto() {

    }

    public OrderDto(int orderId,
                    String side,
                    int quantity,
                    double price,
                    int clientId,
                    int portfolioId,
                    String status,
                    String product, String exchangeOrderId) {
        this.orderId = orderId;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.clientId = clientId;
        this.portfolioId = portfolioId;
        this.status = status;
        this.product = product;
        this.exchangeOrderId = exchangeOrderId;
    }

    public OrderDto(String side,
                    int quantity,
                    double price,
                    int clientId,
                    int portfolioId,
                    String status,
                    String product, String exchangeOrderId) {
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.clientId = clientId;
        this.portfolioId = portfolioId;
        this.status = status;
        this.product = product;
        this.exchangeOrderId = exchangeOrderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public int getClientId() {
        return clientId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", side=" + side +
                ", quantity=" + quantity +
                ", price=" + price +
                ", clientId=" + clientId +
                ", portfolioId=" + portfolioId +
                ", status=" + status +
                ", product=" + product +
                '}';
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getExchangeOrderId() {
        return exchangeOrderId;
    }

    public void setExchangeOrderId(String exchangeOrderId) {
        this.exchangeOrderId = exchangeOrderId;
    }

    public Order getLocalRepresentation() {
        Order order = new Order();
        return order;
    }
}
