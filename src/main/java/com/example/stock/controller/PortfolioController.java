package com.example.stock.controller;

import com.example.stock.dto.CreatePortfdto;
import com.example.stock.entities.Coin;
import com.example.stock.entities.Portfolio;
import com.example.stock.services.Portfolioservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    @Autowired
    Portfolioservice portfolioservice;
    @PostMapping("/create")
    public Portfolio createPortf(@RequestBody CreatePortfdto portfolio){
        return portfolioservice.CreatePortfolio(portfolio);
    }
    @GetMapping("/getAll")
    public List<Portfolio> GetAllPortfol(){
        return portfolioservice.getallPortf();
    }
    @PostMapping("/add/{id}")
    public Portfolio addCoinportf(@PathVariable Long id ,@RequestBody List<Double> coinList){
        return portfolioservice.UpdatePortf(id,coinList);
    }

}
