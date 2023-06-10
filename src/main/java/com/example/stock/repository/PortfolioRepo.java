package com.example.stock.repository;

import com.example.stock.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepo extends JpaRepository<Portfolio,Long> {
    Portfolio getById(Long id);
}
