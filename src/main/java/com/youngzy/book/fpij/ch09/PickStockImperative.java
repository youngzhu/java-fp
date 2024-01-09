package com.youngzy.book.fpij.ch09;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author youngzy
 * @since 2023-03-28
 */
public class PickStockImperative {
    public static void main(String[] args) {
        List<StockInfo> stocks = new ArrayList<>();
        for (String symbol : Tickers.symbols) {
            stocks.add(StockUtil.getStockInfo(symbol));
        }

        List<StockInfo> stocksUnder500 = new ArrayList<>();
        Predicate<StockInfo> isLessThan500 = StockUtil.isPriceLessThan(500);
        for (StockInfo stock : stocks) {
            if (isLessThan500.test(stock))
                stocksUnder500.add(stock);
        }

        //
        StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);
        for (StockInfo stock : stocksUnder500) {
            highPriced = StockUtil.pickHigh(highPriced, stock);
        }

        System.out.println("High priced under $500 is " + highPriced);
    }
}
