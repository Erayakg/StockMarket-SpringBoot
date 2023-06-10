package com.example.stock.services.impl;

import com.example.stock.dto.CreatePortfdto;
import com.example.stock.entities.Portfolio;

import java.util.List;

public interface IportfolioServiceImpl {
    Portfolio CreatePortfolio(CreatePortfdto portfolio);
    List<Portfolio> getallPortf();
    Portfolio UpdatePortf(Long portfolioid,List<Double> CoinId);

}
