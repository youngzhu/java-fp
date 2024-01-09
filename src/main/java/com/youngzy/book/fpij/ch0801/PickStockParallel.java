package com.youngzy.book.fpij.ch0801;

/**
 * @author youngzy
 * @since 2023-03-29
 */
public class PickStockParallel extends PickStockFunctional {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        findHighPriced(Tickers.symbols.parallelStream());
        System.out.printf("cost: %fs", (System.currentTimeMillis() - start)/1000.00);
    }
}
