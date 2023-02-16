package com.youngzy.book.fpij.ch01;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author youngzy
 * @since 2023-02-16
 */
public class Discount {
    public static void main(String[] args) {
        List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"),
                new BigDecimal("17"), new BigDecimal("20"),
                new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12")
        );

        discountImperative(prices);
        discountFunctional(prices);
    }

    private static void discountFunctional(List<BigDecimal> prices) {
        BigDecimal totalOfDiscountedPrices = prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }

    private static void discountImperative(List<BigDecimal> prices) {
        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

        for (BigDecimal price : prices) {
            if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
                totalOfDiscountedPrices = totalOfDiscountedPrices.add(
                        price.multiply(BigDecimal.valueOf(0.9))
                );
            }
        }

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }
}
