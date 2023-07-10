package com.example.stock.dto;

import lombok.Data;

@Data
public class SellCoinDto {
    Long portfId;
    String coinName;
    Double quantity;
    Double coinprice;
}
