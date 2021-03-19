package com.realtrade.tradeengine.repositories;

import com.realtrade.tradeengine.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<OrderDto, Long> {
}
