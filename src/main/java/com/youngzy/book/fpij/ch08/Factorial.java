package com.youngzy.book.fpij.ch08;

import static com.youngzy.book.fpij.ch08.TailCalls.call;
import static com.youngzy.book.fpij.ch08.TailCalls.done;

/**
 * @author youngzy
 * @since 2023-03-24
 */
public class Factorial {
    // 普通递归
    public static int factorialRec(int n) {
        if (n == 1)
            return n;
        else
            return n * factorialRec(n-1);
    }

    // 尾调用递归
    static TailCall<Integer> factorialTailRec(int factorial, int n) {
        if (n == 1)
            return done(factorial);
        else
            return call(() -> factorialTailRec(factorial*n, n-1));
    }

    public static int factorial(int n) {
        return factorialTailRec(1, n).invoke();
    }

}
