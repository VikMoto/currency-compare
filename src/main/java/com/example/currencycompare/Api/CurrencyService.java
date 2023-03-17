package com.example.currencycompare.Api;

import com.example.currencycompare.dto.Currency;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

public interface CurrencyService {
    HashMap<String, BigDecimal> getRate(Currency currency) throws IOException;
}
