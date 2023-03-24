package com.youngzy.book.fpij.ch06;

import java.util.function.Supplier;

/**
 * @author youngzy
 * @since 2023-03-24
 */
public class Evaluation {
    public static boolean evaluate(int value) {
        System.out.println("evaluating ... " + value);
        simulateTimeConsumingOp(2000);
        return value > 100;
    }

    private static void simulateTimeConsumingOp(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    evaluate() 在 eagerEvaluator() 之前就执行了
     */
    public static void eagerEvaluator(boolean input1, boolean input2) {
        System.out.println("eagerEvaluator called...");
        System.out.println("accept?: " + (input1 && input2));
    }

    /*
    evaluate() 在 lazyEvaluator() 之后就执行
    */
    public static void lazyEvaluator(Supplier<Boolean> input1, Supplier<Boolean> input2) {
        System.out.println("lazyEvaluator called...");
        System.out.println("accept?: " + (input1.get() && input2.get()));
    }

    public static void main(String[] args) {
        long start, end;

        System.out.println("==START: EAGER_OUTPUT");
        start = System.currentTimeMillis();
        eagerEvaluator(evaluate(1), evaluate(2));
        end = System.currentTimeMillis();
        System.out.printf("cost: %dms\n", (end - start));
        System.out.println("==END: EAGER_OUTPUT");

        System.out.println("==START: LAZY_OUTPUT");
        start = System.currentTimeMillis();
        lazyEvaluator(() -> evaluate(1), () -> evaluate(2));
        end = System.currentTimeMillis();
        System.out.printf("cost: %dms\n", (end - start));
        System.out.println("==END: LAZY_OUTPUT");
    }
}
