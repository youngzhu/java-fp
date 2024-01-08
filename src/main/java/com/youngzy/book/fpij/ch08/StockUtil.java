package com.youngzy.book.fpij.ch08;

import com.youngzy.book.fpij.ch05.YahooFinance;

import java.math.BigDecimal;
import java.util.function.Predicate;

/**
 * @author youngzy
 * @since 2023-03-28
 */
public class StockUtil {
    public static StockInfo getStockInfo(String ticker) {
        return new StockInfo(ticker, YahooFinance.getPrice(ticker));
    }

    public static Predicate<StockInfo> isPriceLessThan(int price) {
        return stockInfo ->
                stockInfo.price.compareTo(BigDecimal.valueOf(price)) < 0;
    }

    public static StockInfo pickHigh(StockInfo s1, StockInfo s2) {
        return s1.price.compareTo(s2.price) > 0 ? s1 : s2;
    }
}
