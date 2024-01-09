package com.youngzy.book.fpij.ch08;

import java.math.BigInteger;

import static com.youngzy.book.fpij.ch08.TailCalls.call;
import static com.youngzy.book.fpij.ch08.TailCalls.done;

/**
 * @author youngzy
 * @since 2023-03-24
 */
public class BigFactorial {
    public static BigInteger factorial(BigInteger n) {
        return factorialTailRec(ONE, n).invoke();
    }

    private static TailCall<BigInteger> factorialTailRec(BigInteger factorial,
                                                          BigInteger n) {
        if (n.equals(ONE)) {
            return done(factorial);
        } else {
            return call(() -> factorialTailRec(multiply(factorial, n), decrement(n)));
        }
    }

    public static BigInteger decrement(BigInteger n) {
        return n.subtract(ONE);
    }

    public static BigInteger multiply(BigInteger first, BigInteger second) {
        return first.multiply(second);
    }

    final static BigInteger ONE = BigInteger.ONE;
    final static BigInteger FIVE = new BigInteger("5");
    final static BigInteger TWENTYK = new BigInteger("20000");

    public static void main(String[] args) {
        System.out.println(factorial(FIVE));
        System.out.println(factorial(TWENTYK));
    }
}
