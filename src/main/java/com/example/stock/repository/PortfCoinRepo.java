package com.example.stock.repository;

import com.example.stock.entities.PortfolioCoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfCoinRepo extends JpaRepository<PortfolioCoin,Long> {
   PortfolioCoin getByName(String name);
}
