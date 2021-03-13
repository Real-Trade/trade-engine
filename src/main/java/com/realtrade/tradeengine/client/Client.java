package com.realtrade.tradeengine.client;

public class Client {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Long accountNumber;

    public Client() {
    }

    public Client(Long id,
                  String name,
                  String email,
                  String password,
                  Long accountNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountNumber = accountNumber;
    }

    public Client(String name,
                  String email,
                  String password,
                  Long accountNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountNumber = accountNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }


    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
