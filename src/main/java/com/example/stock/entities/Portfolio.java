package com.example.stock.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Portfolio {
    @Id
    private Long id;
    Date createdDate ;
    Double portfolioPrice;
    Double Pairs;

    @OneToMany
    List<Coin> coinList;
}
