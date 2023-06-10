package com.example.stock.services;

import com.example.stock.dto.CreatePortfdto;
import com.example.stock.entities.Coin;
import com.example.stock.entities.Portfolio;
import com.example.stock.repository.PortfolioRepo;
import com.example.stock.services.impl.IportfolioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Portfolioservice implements IportfolioServiceImpl {
    @Autowired
    PortfolioRepo portfolioRepo;
    @Autowired
    DataFetchService dataFetchService;

    @Override
    public Portfolio CreatePortfolio(CreatePortfdto portfolio) {
        Portfolio portfolio1 = new Portfolio();
        portfolio1.setName(portfolio.getName());
        return portfolioRepo.save(portfolio1);
    }

    public List<Portfolio> getallPortf() {
        return portfolioRepo.findAll();
    }

    @Override
    public Portfolio UpdatePortf(Long Portfolioid, List<Double> CoinsId) {

        Portfolio portfolio = portfolioRepo.getById(Portfolioid);

        List<Coin> coinList = dataFetchService.getAllCoins();

        //coinList.forEach(System.out::println);

        List<Coin> filteredCoins = coinList.stream()
                .filter(coin -> CoinsId.contains(coin.getFirstId().doubleValue()))
                .collect(Collectors.toList());


        System.out.println("Coinİd");
        CoinsId.forEach(System.out::println);
        System.out.println("filtelenmisş coin");
        filteredCoins.forEach(System.out::println);



        portfolio.getCoinList().addAll(filteredCoins);
        return portfolioRepo.save(portfolio);
    }
}
