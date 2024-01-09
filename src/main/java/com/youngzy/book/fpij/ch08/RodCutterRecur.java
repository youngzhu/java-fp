package com.youngzy.book.fpij.ch08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 时间比basic版还长就过分了。。
 * basic：30s左右
 * recur：书上说要按小时计
 */
public class RodCutterRecur {
    final List<Integer> prices;

    final static List<Integer> priceValues = Arrays.asList(
            2, 1, 1, 2, 2, 2, 1, 8, 9, 15
    );

    public RodCutterRecur(List<Integer> prices) {
        this.prices = prices;
    }

    public int maxProfit(int length) {
        int profit = length <= prices.size() ? prices.get(length-1) : 0;

        return Math.max(profit,
                IntStream.range(1, length)
                        .map(i -> maxProfit(i) + maxProfit(length - i))
                        .max()
                        .orElse(0));
    }

    public static void main(String[] args) {
        RodCutterRecur rodCutter = new RodCutterRecur(priceValues);

        long start = System.currentTimeMillis();
        System.out.println(rodCutter.maxProfit(5));
        System.out.println(rodCutter.maxProfit(22));
        System.out.printf("cost: %fs", (System.currentTimeMillis() - start)/1000.00);
    }
}
