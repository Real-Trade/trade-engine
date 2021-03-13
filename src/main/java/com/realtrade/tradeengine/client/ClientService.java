package com.realtrade.tradeengine.client;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    public List<Client> getClients() {
        return List.of(
                new Client(1L, "Marie", "marie@gmail.com", "password", 12345678L),
                new Client(2L, "George", "george@gmail.com", "password", 87654321L));
    }
}
