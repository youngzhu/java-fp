package com.youngzy.book.fpij.ch07;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.youngzy.book.fpij.ch07.Memoizer.callMemoized;

/**
 * @author youngzy
 * @since 2023-03-27
 */
public class RodCutterMemoized extends RodCutterBasic {
    public RodCutterMemoized(List<Integer> prices) {
        super(prices);
    }

    public int maxProfit(int rodLength) {
        BiFunction<Function<Integer, Integer>, Integer, Integer> compute = (func, length) -> {
            int profit = length <= prices.size() ? prices.get(length-1) : 0;
            for (int i = 1; i < length; i++) {
                int priceWhenCut = func.apply(i) + func.apply(length-i);
                if (profit < priceWhenCut) {
                    profit = priceWhenCut;
                }
            }
            return profit;
        };

        return callMemoized(compute, rodLength);
    }

    public static void main(String[] args) {
        RodCutterMemoized rodCutterMemoized = new RodCutterMemoized(priceValues);

        long start = System.currentTimeMillis();
        System.out.println(rodCutterMemoized.maxProfit(5));
        System.out.println(rodCutterMemoized.maxProfit(22));
        System.out.printf("cost: %fs", (System.currentTimeMillis() - start)/1000.00);
    }
}
