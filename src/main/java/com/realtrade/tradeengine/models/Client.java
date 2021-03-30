package com.realtrade.tradeengine.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int clientId;
    private String firstName;
    private  String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private int status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Portfolio> portfolio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ClientOrder> orders;

    public Client() {
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    public Client(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdateAt() {
        return updatedAt;
    }

    public void setUpdateAt(OffsetDateTime updateAt) {
        this.updatedAt = updateAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

//    public List<Portfolio> getPortfolio() {
//        return portfolio;
//    }
//
//    public void setPortfolio(List<Portfolio> portfolio) {
//        this.portfolio = portfolio;
//    }
//
//    public List<ClientOrder> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<ClientOrder> orders) {
//        this.orders = orders;
//    }
}