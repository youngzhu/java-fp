package com.youngzy.book.fpij.ch0801;

import java.math.BigDecimal;

/**
 * @author youngzy
 * @since 2023-03-28
 */
public class StockInfo {
    final String ticker;
    final BigDecimal price;

    public StockInfo(String ticker, BigDecimal price) {
        this.ticker = ticker;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ticker: %s, price: %g", ticker, price);
    }
}
