package com.realtrade.tradeengine.repositories;

import com.realtrade.tradeengine.models.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioDao extends JpaRepository<Portfolio, Integer> {


}
