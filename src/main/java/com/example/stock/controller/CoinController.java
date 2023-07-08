package com.example.stock.controller;

import com.example.stock.entities.Coin;
import com.example.stock.services.CoinServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/coin")
public class CoinController {
    @Autowired
    private CoinServices coinApiServices;
    @GetMapping("/all")
    public List<Coin> GetAllCoin(){
        return coinApiServices.getAllCoins();
    }

    @GetMapping("/{symbol}")
    public List<Coin> getByName(@PathVariable String symbol){
        return coinApiServices.GetByCoinSymbol(symbol);
    }

}
