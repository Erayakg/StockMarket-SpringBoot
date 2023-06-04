package com.example.stock.services;

import com.example.stock.entities.Coin;
import com.example.stock.repository.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinServices {
    @Autowired
    DataFetchService service;
    @Autowired
    CoinRepo coinRepo;
    public List<Coin> getAllCoins() {
        return service.getAllCoins();
    }
    public List<Coin> GetByCoinSymbol(String symbol) {

        List<Coin> coins = service.getAllCoins();

        List<Coin> filteredCoins = coins.stream()
                .filter(coin -> symbol.equals(coin.getSymbol()))
                .toList();

        if (filteredCoins.isEmpty()){
            System.out.println("Coin bulunamadı");
            return null;
        }
        System.out.println("Coin Bulundu:"+filteredCoins);
        return filteredCoins;
    }


}
