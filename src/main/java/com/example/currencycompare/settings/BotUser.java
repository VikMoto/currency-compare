package com.example.currencycompare.settings;

import lombok.Data;
import com.example.currencycompare.dto.Bank;
import com.example.currencycompare.dto.Currency;

import java.util.ArrayList;
import java.util.List;

@Data
public class BotUser {
    private final long id;
    private Bank bank;
    private List<Currency> currencies = new ArrayList<>();
    private int precision;
    private boolean scheduler;
    private int schedulerTime;

    public int getSchedulerTime() {
        return schedulerTime;
    }

    public void setSchedulerTime(int schedulerTime) {
        this.schedulerTime = schedulerTime;
    }

    public BotUser(long id) {
        this.id = id;
        bank = Bank.NBU;
        currencies.add(Currency.USD);
        precision = 2;
        scheduler = true;
        schedulerTime = 9;
    }
}