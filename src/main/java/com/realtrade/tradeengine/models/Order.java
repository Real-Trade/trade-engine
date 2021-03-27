package com.realtrade.tradeengine.models;

import java.time.LocalDate;

public class Order implements Cloneable{

    private int orderId;
    private Side side;
    private int quantity;
    private double price;
    private int clientId;
    private int portfolioId;
    private Status status;
    private Product product;
    private String exchangeName;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Order() {

    }

    public Order(int orderId,
                    Side side,
                    int quantity,
                    double price,
                    int clientId,
                    int portfolioId,
                    Status status,
                    Product product) {
        this.orderId = orderId;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.clientId = clientId;
        this.portfolioId = portfolioId;
        this.status = status;
        this.product = product;
    }

    public Order(Side side,
                    int quantity,
                    double price,
                    int clientId,
                    int portfolioId,
                    Status status,
                    Product product) {
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.clientId = clientId;
        this.portfolioId = portfolioId;
        this.status = status;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
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
}
