package com.youngzy.book.fpij.ch09;

import java.math.BigDecimal;

import static java.util.stream.Collectors.joining;

/**
 * @author youngzy
 * @since 2024-01-09
 */
public class Stocks100 {
    public static void main(String[] args) {
        final BigDecimal HUNDRED = new BigDecimal("100");

        System.out.println("Stocks priced over $100 are:");

        System.out.println(
                Tickers.symbols
                        .stream()
                        .filter(symbol -> FinanceData.getPrice(symbol).compareTo(HUNDRED) > 0)
                        .sorted()
                        .collect(joining(", ")));
    }
}
