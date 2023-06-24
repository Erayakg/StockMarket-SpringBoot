package com.example.stock.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AddCoinportfDto {

    private Date bougthDate;
    private Double bougthprice;
    private String coinName;
    private Double quantity;

}
