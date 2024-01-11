package com.youngzy.book.fpij.ch11;

import java.math.BigInteger;

/**
 * @author youngzy
 * @since 2024-01-10
 */
public class Factorial {
    public BigInteger compute(long upTo) {
        BigInteger result = BigInteger.ONE;

        for(int i = 1; i <= upTo; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
