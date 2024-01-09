package com.youngzy.book.fpij.ch0801;

import java.util.stream.Stream;

/**
 * @author youngzy
 * @since 2023-03-29
 */
public class PickStockFunctional {
    public static void findHighPriced(Stream<String> symbols) {
        StockInfo highPriced = symbols
                .map(StockUtil::getStockInfo)
                .filter(StockUtil.isPriceLessThan(500))
                .reduce(StockUtil::pickHigh)
                .get();

        System.out.println("High priced under $500 is " + highPriced);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        findHighPriced(Tickers.symbols.stream());
        System.out.printf("cost: %fs", (System.currentTimeMillis() - start)/1000.00);
    }
}
