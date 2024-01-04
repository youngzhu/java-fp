package com.youngzy.book.fpij.ch01;

import java.util.Arrays;
import java.util.List;

/**
 * @author youngzy
 * @since 2024-01-04
 */
public class Discount {
    static final List<Integer> prices = Arrays.asList(10, 30, 17, 20, 18, 45, 12);

    private static void discountFunctional(List<Integer> prices) {
        final double totalOfDiscountedPrices = prices.stream()
                .filter(price -> price > 20)
                .mapToDouble(price -> price * 0.9)
                .sum();

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }

    private static void discountImperative(List<Integer> prices) {
        double totalOfDiscountedPrices = 0.0;

        for (int price : prices) {
            if (price > 20) {
                totalOfDiscountedPrices += price * 0.9;
            }
        }

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }

    public static void main(String[] args) {
        discountImperative(prices);
        discountFunctional(prices);
    }
}
