package com.realtrade.tradeengine.repositories;

import com.realtrade.tradeengine.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {

}
