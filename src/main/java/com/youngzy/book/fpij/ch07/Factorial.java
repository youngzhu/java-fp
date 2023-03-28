package com.youngzy.book.fpij.ch07;

import static com.youngzy.book.fpij.ch07.TailCalls.call;
import static com.youngzy.book.fpij.ch07.TailCalls.done;

/**
 * @author youngzy
 * @since 2023-03-24
 */
public class Factorial {
    public static int factorialRec(int n) {
        if (n == 1)
            return n;
        else
            return n * factorialRec(n-1);
    }

    public static TailCall<Integer> factorialTailRec(int factorial, int n) {
        if (n == 1)
            return done(factorial);
        else
            return call(() -> factorialTailRec(factorial*n, n-1));
    }

    public static int factorial(int n) {
        return factorialTailRec(1, n).invoke();
    }

    public static void main(String[] args) {
        System.out.println("==START:FACT_REC_DISPLAY_5_OUTPUT");
        System.out.println(factorialRec(5));
        System.out.println("==END:FACT_REC_DISPLAY_5_OUTPUT");

        System.out.println("==START:FACT_REC_DISPLAY_LARGE_OUTPUT");
        try {
            System.out.println(factorialRec(20000));
        } catch (StackOverflowError e) {
            System.out.println(e);
        }
        System.out.println("==END:FACT_REC_DISPLAY_LARGE_OUTPUT");

        System.out.println("==START:FACT_TAIL_REC_DISPLAY_5_OUTPUT");
        System.out.println(factorialTailRec(1, 5).invoke());
        System.out.println("==END:FACT_TAIL_REC_DISPLAY_5_OUTPUT");

        System.out.println("==START:FACT_TAIL_REC_DISPLAY_LARGE_OUTPUT");
        System.out.println(factorialTailRec(1, 20000).invoke());
        System.out.println("==END:FACT_TAIL_REC_DISPLAY_LARGE_OUTPUT");

        System.out.println("==START:FACTORIAL_DISPLAY_OUTPUT");
        System.out.println(factorial(5));
        System.out.println(factorial(20000));
        System.out.println("==END:FACTORIAL_DISPLAY_OUTPUT");
    }
}
