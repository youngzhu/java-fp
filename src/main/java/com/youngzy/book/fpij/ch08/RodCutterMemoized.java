package com.youngzy.book.fpij.ch08;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

import static com.youngzy.book.fpij.ch08.Memoizer.callMemoized;

/**
 * @author youngzy
 * @since 2023-03-27
 */
public class RodCutterMemoized {
    private final List<Integer> prices;

    public RodCutterMemoized(final List<Integer> pricesForLengths) {
        prices = pricesForLengths;
    }

    // 1st edition
//    public int maxProfit(int rodLength) {
//        BiFunction<Function<Integer, Integer>, Integer, Integer> compute = (func, length) -> {
//            int profit = length <= prices.size() ? prices.get(length-1) : 0;
//            for (int i = 1; i < length; i++) {
//                int priceWhenCut = func.apply(i) + func.apply(length-i);
//                if (profit < priceWhenCut) {
//                    profit = priceWhenCut;
//                }
//            }
//            return profit;
//        };
//
//        return callMemoized(compute, rodLength);
//    }

    public int maxProfit(final int length) {
        return callMemoized(this::computeMaxProfit, length);
    }

    private int computeMaxProfit(
            Function<Integer, Integer> memoizedFunction, int length) {

        int priceAtLength = length <= prices.size() ? prices.get(length - 1) : 0;

        return Math.max(priceAtLength, IntStream.range(1, length)
                .map(i -> memoizedFunction.apply(i) + memoizedFunction.apply(length - i))
                .max()
                .orElse(0));
    }

    public static void main(String[] args) {
        final List<Integer> priceValues =
                Arrays.asList(2, 1, 1, 2, 2, 2, 1, 8, 9, 15);

        RodCutterMemoized rodCutterMemoized = new RodCutterMemoized(priceValues);

        long start = System.currentTimeMillis();
        System.out.println(rodCutterMemoized.maxProfit(5));
        System.out.println(rodCutterMemoized.maxProfit(22));
        System.out.println(rodCutterMemoized.maxProfit(500));
        System.out.printf("cost: %fs", (System.currentTimeMillis() - start)/1000.00);
    }
}
