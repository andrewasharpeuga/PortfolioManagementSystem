package com.yourpackage;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

public class StockService {
    public Stock getStock(String symbol) {
        try {
            return YahooFinance.get(symbol);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BigDecimal getStockPrice(String symbol) {
        Stock stock = getStock(symbol);
        if (stock != null) {
            return stock.getQuote().getPrice();
        }
        return null;
    }
}
