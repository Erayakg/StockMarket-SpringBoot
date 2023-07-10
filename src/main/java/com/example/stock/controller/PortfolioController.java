package com.example.stock.controller;

import com.example.stock.dto.AddCoinportfDto;
import com.example.stock.dto.CreatePortfdto;
import com.example.stock.dto.SellCoinDto;
import com.example.stock.dto.deleteCoindto;
import com.example.stock.entities.Portfolio;
import com.example.stock.services.Portfolioservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)

@RequestMapping("/portfolio")
public class PortfolioController {
    @Autowired
    Portfolioservice portfolioservice;
    @PostMapping("/sell")
    public Portfolio sellCoinByportfolio(@RequestBody SellCoinDto sellCoinDto){
        return portfolioservice.sellCoinportf(sellCoinDto);
    }
    @PostMapping("/create")
    public Portfolio createPortf(@RequestBody CreatePortfdto portfolio){
        return portfolioservice.CreatePortfolio(portfolio);
    }
    @GetMapping("/getAll")
    public List<Portfolio> GetAllPortfol(){
        return portfolioservice.getallPortf();
    }
    @PostMapping("/add/{id}")
    public Portfolio addCoinportf(@PathVariable Long id ,@RequestBody List<AddCoinportfDto> coinList){
        return portfolioservice.addCoinPortf(id,coinList);
    }
    @DeleteMapping("{portfId}/delete")
    public Portfolio DeletePortf(@PathVariable Long portfId){
        return portfolioservice.deletePortf(portfId);
    }
    @DeleteMapping("/delete/coin/{portfId}")
    public Portfolio DeletePortfCoin(@PathVariable Long portfId,@RequestBody List<deleteCoindto> coinName) {
        return portfolioservice.deletePortfCoin(portfId,coinName);
    }
}
