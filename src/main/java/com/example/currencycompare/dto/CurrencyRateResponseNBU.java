package com.example.currencycompare.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyRateResponseNBU implements CurrencyRateResponse{
    private Long r030;
    private String txt;
    private BigDecimal rate;
    private Currency cc;
    private String exchangedate;

}
