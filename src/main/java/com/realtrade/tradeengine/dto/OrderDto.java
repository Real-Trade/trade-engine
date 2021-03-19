package com.realtrade.tradeengine.models;

import javax.persistence.*;
import java.time.LocalDate;

//implements cloneable to facilitate suborder creation
@Entity
@Table(name = "clientOrder")
public class Order implements Cloneable{

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
    private Side side;
    private int quantity;
    private double price;
    private Long clientId;
    private Long portfolioId;
    private Status status;
    private Product product;
    private String exchangeName;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    public Order() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public Order(Long orderId,
                 Side side,
                 int quantity,
                 double price,
                 Long clientId,
                 Long portfolioId,
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
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public Order(Side side,
                 int quantity,
                 double price,
                 Long clientId,
                 Long portfolioId,
                 Status status,
                 Product product) {
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.clientId = clientId;
        this.portfolioId = portfolioId;
        this.status = status;
        this.product = product;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
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

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Long getClientId() {
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
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

    public LocalDate getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDate deletedAt) {
        this.deletedAt = deletedAt;
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
