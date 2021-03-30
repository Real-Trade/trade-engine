package com.realtrade.tradeengine.models;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
public class ClientSubOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subOrderId;
    private int quantity;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime executedAt;
    private String status;
    @JoinColumn(name = "order_id", nullable = false, updatable = false)
    @ManyToOne
    private ClientOrder parentOrder;

    public ClientSubOrder(int subOrderId, int quantity, String status) {
        this.subOrderId = subOrderId;
        this.quantity = quantity;
        this.status = status;
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    public ClientSubOrder() {
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    public int getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(int subOrderId) {
        this.subOrderId = subOrderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public OffsetDateTime getExecutedAt() {
        return executedAt;
    }

    public void setExecutedAt(OffsetDateTime executedAt) {
        this.executedAt = executedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClientOrder getParentOrder() {
        return parentOrder;
    }

    public void setParentOrder(ClientOrder parentOrder) {
        this.parentOrder = parentOrder;
    }
}
