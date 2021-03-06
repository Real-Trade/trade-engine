package com.realtrade.tradeengine.repositories;

import com.realtrade.tradeengine.models.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<ClientOrder, Long> {
}
