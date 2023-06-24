package com.example.stock.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;

    Double portfolioPrice;

    @OneToMany(cascade = CascadeType.ALL)
    List<PortfolioCoin>  portfolioCoins =new ArrayList<>();

    @ManyToOne
    User user;

    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
    }
}
