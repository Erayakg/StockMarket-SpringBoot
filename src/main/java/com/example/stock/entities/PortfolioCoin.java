package com.example.stock.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class PortfolioCoin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Double bougthPrice;
    private Double totalprice;
    private Double salePrice;

    private Date BougthDate;


    private Date salesDate;
    private Double quantity;
    @ManyToOne
    Portfolio portfolio;



}
