package com.youngzy.book.fpij.ch0801;

import java.math.BigDecimal;
import java.util.function.Predicate;

/**
 * @author youngzy
 * @since 2023-03-28
 */
public class PickStockImperativeClubbed {
    public static void main(String[] args) {
        StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);

        Predicate<StockInfo> isLessThan500 = StockUtil.isPriceLessThan(500);

        for (String symbol : Tickers.symbols) {
            StockInfo stock = StockUtil.getStockInfo(symbol);

            if (isLessThan500.test(stock))
                highPriced = StockUtil.pickHigh(highPriced, stock);
        }

        System.out.println("High priced under $500 is " + highPriced);
    }
}
