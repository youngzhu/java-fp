package com.youngzy.book.fpij.ch05;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * @author youngzy
 * @since 2023-03-20
 */
public class CalculateNAV {
    private Function<String, BigDecimal> priceFinder;

    public CalculateNAV(Function<String, BigDecimal> priceFinder) {
        this.priceFinder = priceFinder;
    }

    public BigDecimal computeStockWorth(String ticker, int shares) {
        return priceFinder.apply(ticker)
                .multiply(BigDecimal.valueOf(shares));
    }

    public static void main(String[] args) {
        // 雅虎服务用不了
        CalculateNAV calculateNAV = new CalculateNAV(YahooFinance::getPrice);

        System.out.println(String.format("100 shares of Google worth: $%.2f",
                calculateNAV.computeStockWorth("GOOG", 100)));
    }
}
