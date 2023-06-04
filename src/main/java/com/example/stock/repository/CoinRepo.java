package com.example.stock.repository;

import com.example.stock.entities.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CoinRepo extends JpaRepository<Coin, Double> {
    List<Coin> findBySymbol(String symbol);
}
