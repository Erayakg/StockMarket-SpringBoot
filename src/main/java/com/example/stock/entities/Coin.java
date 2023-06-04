package com.example.stock.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Coin {

    @Id
    private Double firstId;
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
    private Double askQty;
    private Double openPrice;
    private Double highPrice;
    private Double lowPrice;
    private Double quoteVolume;
    private Double volume;
    private Date openTime;
    private Date closeTime;
    private Double count;

}
