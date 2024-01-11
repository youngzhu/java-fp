package com.youngzy.book.fpij.ch11;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * @author youngzy
 * @since 2024-01-10
 */
public class FactorialFunctional extends Factorial {
    public BigInteger compute(long upTo) {
        return LongStream.rangeClosed(1, upTo)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
