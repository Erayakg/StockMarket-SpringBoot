package com.example.stock.services.contract;

import com.example.stock.entities.Coin;

import java.util.List;

public interface ICoinServiceContract {
    List<Coin> getAllCoins();
}
