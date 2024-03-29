package com.example.stock.services.contract;

import com.example.stock.dto.AddCoinportfDto;
import com.example.stock.dto.CreatePortfdto;
import com.example.stock.dto.SellCoinDto;
import com.example.stock.dto.deleteCoindto;
import com.example.stock.entities.Portfolio;
import com.example.stock.entities.PortfolioCoin;

import java.util.List;

public interface IportfolioServiceContract {
    Portfolio CreatePortfolio(CreatePortfdto portfolio);
    List<Portfolio> getallPortf();
    Portfolio addCoinPortf(Long portfolioid,List<AddCoinportfDto> CoinId);
    Portfolio deletePortf(Long portfId);
    Portfolio deletePortfCoin(Long portfId,List<deleteCoindto> coinName );
    Portfolio calculatePortfolioPrice(Long portfId,List<AddCoinportfDto> Portfolio);
    void calculateAndSetPrice(Long portfId, PortfolioCoin coin);
    Portfolio sellCoinportf(SellCoinDto sellCoinDto);


}
