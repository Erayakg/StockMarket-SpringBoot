package com.example.stock.services;

import com.example.stock.dto.AddCoinportfDto;
import com.example.stock.dto.CreatePortfdto;
import com.example.stock.dto.deleteCoindto;
import com.example.stock.entities.Coin;
import com.example.stock.entities.Portfolio;
import com.example.stock.entities.PortfolioCoin;
import com.example.stock.entities.User;
import com.example.stock.repository.PortfCoinRepo;
import com.example.stock.repository.PortfolioRepo;
import com.example.stock.repository.UserRepo;
import com.example.stock.services.impl.IportfolioServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class Portfolioservice implements IportfolioServiceImpl {
    @Autowired
    PortfolioRepo portfolioRepo;
    @Autowired
    DataFetchService dataFetchService;
    @Autowired
    PortfCoinRepo coinRepo;
    @Autowired
    private UserRepo userRepo;
    @Override
    public Portfolio CreatePortfolio(CreatePortfdto portfolio) {
        Portfolio portfolio1 = new Portfolio();
        User user=userRepo.getUserById(portfolio.getId());
        portfolio1.setUser(user);

        portfolio1.setName(portfolio.getName());

        return portfolioRepo.save(portfolio1);
    }

    public List<Portfolio> getallPortf() {
        return portfolioRepo.findAll();
    }

    @Override
    public Portfolio addCoinPortf(Long Portfolioid, List<AddCoinportfDto> coinPortfs) {

        Portfolio portfolio = portfolioRepo.getById(Portfolioid);

        List<Coin> coinList = dataFetchService.getAllCoins();

        if (portfolio == null) {
            System.out.println("Not Found Portfolio");
            return null;
        }
        for (AddCoinportfDto dto : coinPortfs) {
            for (Coin coin : coinList) {
                if (Objects.equals(dto.getCoinName(), coin.getSymbol())) {
                    System.out.println("bulundu" + coin.toString());
                    boolean coinExistsInPortfolio = false;
                    for (PortfolioCoin portfolioCoin : portfolio.getPortfolioCoins()) {
                        if (Objects.equals(portfolioCoin.getName(), dto.getCoinName())) {
                            coinExistsInPortfolio = true;
                            portfolioCoin.setQuantity(portfolioCoin.getQuantity() + dto.getQuantity());
                            break;
                        }
                    }
                    if (!coinExistsInPortfolio) {
                        PortfolioCoin coin1 = new PortfolioCoin();
                        coin1.setQuantity(dto.getQuantity());
                        coin1.setBougthPrice(dto.getBougthprice());
                        coin1.setName(dto.getCoinName());
                        portfolio.getPortfolioCoins().add(coin1);
                    }
                }
            }
        }
        calculatePortfolioPrice(Portfolioid);
        return portfolioRepo.save(portfolio);
    }

    @Override
    public Portfolio deletePortf(Long portfId) {

        Portfolio deleteportf = portfolioRepo.getById(portfId);

        if (deleteportf == null) {
            System.out.println("Not Found Portfolio");
            return null;
        }
        portfolioRepo.delete(deleteportf);
        return deleteportf;
    }

    @Transactional
    @Override
    public Portfolio deletePortfCoin(Long portfId, List<deleteCoindto> coinName) {

        Portfolio deletePortfolio = portfolioRepo.getById(portfId);

        if (deletePortfolio == null) {
            System.out.println("Not found portfolio");
            return null;
        }

        List<PortfolioCoin> coinsToRemove = new ArrayList<>();

        for (PortfolioCoin portfolio : deletePortfolio.getPortfolioCoins()) {
            for (deleteCoindto portfName : coinName) {
                if (portfName.getName().equals(portfolio.getName())) {
                    PortfolioCoin deletedcoin = coinRepo.getByName(portfolio.getName());
                    if (deletedcoin != null) {
                        coinsToRemove.add(deletedcoin);
                    } else {
                        System.out.println("No PortfolioCoin found with name: " + portfolio.getName());
                    }
                }
            }
        }

        for (PortfolioCoin coin : coinsToRemove) {
            System.out.println(coin);
            deletePortfolio.getPortfolioCoins().remove(coin);
            coinRepo.delete(coin);
        }

        coinRepo.flush();
        return deletePortfolio;
    }

    @Override
    public Portfolio calculatePortfolioPrice(Long portfId) {

        Portfolio portfolio = portfolioRepo.getById(portfId);
        Double price = 0.0;
        if (portfolio == null) {
            System.out.println("Not Found Portfolio");
            return null;
        }

        List<Coin> coinList = dataFetchService.getAllCoins();
        for (Coin coin : coinList) {
            for (PortfolioCoin portfolioCoin : portfolio.getPortfolioCoins()) {
                if (Objects.equals(portfolioCoin.getName(), coin.getSymbol())) {
                    System.out.println(coin.getLastPrice());
                    price += portfolioCoin.getQuantity() * coin.getLastPrice();
                }
            }
        }
        portfolio.setPortfolioPrice(price);
        return portfolio;
    }
}