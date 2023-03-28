package com.youngzy.book.fpij.ch07;

import java.util.Arrays;
import java.util.List;

/**
 * @author youngzy
 * @since 2023-03-24
 */
public class RodCutterBasic {
    final List<Integer> prices;

    final static List<Integer> priceValues = Arrays.asList(
            2, 1, 1, 2, 2, 2, 1, 8, 9, 15
    );

    public RodCutterBasic(List<Integer> prices) {
        this.prices = prices;
    }

    public int maxProfit(int length) {
        int profit = length <= prices.size() ? prices.get(length-1) : 0;
        for (int i = 1; i < length; i++) {
            int priceWhenCut = maxProfit(i) + maxProfit(length-i);
            if (profit < priceWhenCut) {
                profit = priceWhenCut;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        RodCutterBasic rodCutter = new RodCutterBasic(priceValues);

        long start = System.currentTimeMillis();
        rodCutter.maxProfit(5);
        rodCutter.maxProfit(22);
        System.out.printf("cost: %fs", (System.currentTimeMillis() - start)/1000.00);
    }
}
