package com.example.stock.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Coin {

    private String symbol;
    private Double priceChange;
    private Double priceChangePercent;
    private Double weightedAvgPrice;
    private Double prevClosePrice;
    private Double lastQty;
    private Double lastPrice;
    private Double bidPrice;
    private Double bidQty;
    private Double askPrice;
    private Double askedpricce;
    private Double askQty;
    private Double openPrice;
    private Double highPrice;
    private Double lowPrice;
    private Double quoteVolume;
    private Double volume;
    private Date openTime;
    private Date closeTime;
    private Double count;
    @ManyToOne
    Portfolio portfolio;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(Double priceChange) {
        this.priceChange = priceChange;
    }

    public Double getPriceChangePercent() {
        return priceChangePercent;
    }

    public void setPriceChangePercent(Double priceChangePercent) {
        this.priceChangePercent = priceChangePercent;
    }

    public Double getWeightedAvgPrice() {
        return weightedAvgPrice;
    }

    public void setWeightedAvgPrice(Double weightedAvgPrice) {
        this.weightedAvgPrice = weightedAvgPrice;
    }

    public Double getPrevClosePrice() {
        return prevClosePrice;
    }

    public void setPrevClosePrice(Double prevClosePrice) {
        this.prevClosePrice = prevClosePrice;
    }

    public Double getLastQty() {
        return lastQty;
    }

    public void setLastQty(Double lastQty) {
        this.lastQty = lastQty;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Double getBidQty() {
        return bidQty;
    }

    public void setBidQty(Double bidQty) {
        this.bidQty = bidQty;
    }

    public Double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Double askPrice) {
        this.askPrice = askPrice;
    }

    public Double getAskQty() {
        return askQty;
    }

    public void setAskQty(Double askQty) {
        this.askQty = askQty;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(Double quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Coin( String symbol, Double priceChange, Double priceChangePercent, Double weightedAvgPrice, Double prevClosePrice, Double lastQty, Double lastPrice, Double bidPrice, Double bidQty, Double askPrice, Double askQty, Double openPrice, Double highPrice, Double lowPrice, Double quoteVolume, Double volume, Date openTime, Date closeTime, Double count, Portfolio portfolio) {

        this.symbol = symbol;
        this.priceChange = priceChange;
        this.priceChangePercent = priceChangePercent;
        this.weightedAvgPrice = weightedAvgPrice;
        this.prevClosePrice = prevClosePrice;
        this.lastQty = lastQty;
        this.lastPrice = lastPrice;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.quoteVolume = quoteVolume;
        this.volume = volume;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.count = count;
        this.portfolio = portfolio;
    }
    @Override
    public String toString() {
        return "Coin{" +
                ", symbol='" + symbol + '\'' +
                ", priceChange=" + priceChange +
                ", priceChangePercent=" + priceChangePercent +
                ", weightedAvgPrice=" + weightedAvgPrice +
                ", prevClosePrice=" + prevClosePrice +
                ", lastQty=" + lastQty +
                ", lastPrice=" + lastPrice +
                ", bidPrice=" + bidPrice +
                ", bidQty=" + bidQty +
                ", askPrice=" + askPrice +
                ", askQty=" + askQty +
                ", openPrice=" + openPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", quoteVolume=" + quoteVolume +
                ", volume=" + volume +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", count=" + count +
                ", portfolio=" + portfolio +
                '}';
    }

    public Coin() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return Objects.equals(symbol, coin.symbol) && Objects.equals(priceChange, coin.priceChange) && Objects.equals(priceChangePercent, coin.priceChangePercent) && Objects.equals(weightedAvgPrice, coin.weightedAvgPrice) && Objects.equals(prevClosePrice, coin.prevClosePrice) && Objects.equals(lastQty, coin.lastQty) && Objects.equals(lastPrice, coin.lastPrice) && Objects.equals(bidPrice, coin.bidPrice) && Objects.equals(bidQty, coin.bidQty) && Objects.equals(askPrice, coin.askPrice) && Objects.equals(askQty, coin.askQty) && Objects.equals(openPrice, coin.openPrice) && Objects.equals(highPrice, coin.highPrice) && Objects.equals(lowPrice, coin.lowPrice) && Objects.equals(quoteVolume, coin.quoteVolume) && Objects.equals(volume, coin.volume) && Objects.equals(openTime, coin.openTime) && Objects.equals(closeTime, coin.closeTime) && Objects.equals(count, coin.count) && Objects.equals(portfolio, coin.portfolio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, priceChange, priceChangePercent, weightedAvgPrice, prevClosePrice, lastQty, lastPrice, bidPrice, bidQty, askPrice, askQty, openPrice, highPrice, lowPrice, quoteVolume, volume, openTime, closeTime, count, portfolio);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

