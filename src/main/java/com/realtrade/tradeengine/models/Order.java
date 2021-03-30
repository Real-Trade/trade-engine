package com.realtrade.tradeengine.models;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class Order implements Cloneable{

    private int orderId;
    private Side side;
    private int quantity;
    private double price;
    private Client client;
    private Portfolio portfolio;
    private int cumulativeQuantity;
    private String exchangeOrderId;
    private Status status;
    private Product product;
    private String exchangeName;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Order() {

    }

    public Order(int orderId,
                 Side side,
                 int quantity,
                 double price,
                 Client client,
                 Portfolio portfolio,
                 int cumulativeQuantity, Status status,
                 Product product) {
        this.orderId = orderId;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.client = client;
        this.portfolio = portfolio;
        this.cumulativeQuantity = cumulativeQuantity;
        this.status = status;
        this.product = product;
    }

    public Order(Side side,
                 int quantity,
                 double price,
                 Client client,
                 Portfolio portfolio,
                 int cumulativeQuantity, Status status,
                 Product product) {
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.client = client;
        this.portfolio = portfolio;
        this.cumulativeQuantity = cumulativeQuantity;
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

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public Client getClientId() {
        return client;
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
                ", client" + client.getClientId() +
                ", portfolio" + portfolio.getPortfolioId() +
                ", status=" + status +
                ", product=" + product +
                '}';
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ClientOrder getClientOrderRepresentation() {
        return new ClientOrder(this.orderId, this.price, this.quantity, this.side.name(), this.cumulativeQuantity, this.status.name(), this.product.name(), this.exchangeName, this.portfolio, this.client);
    }
}
