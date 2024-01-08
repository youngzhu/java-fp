package com.youngzy.book.fpij.ch07;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author youngzy
 * @since 2023-03-24
 */
public class Primes {
    private static int primeAfter(int n) {
        if (isPrime(n+1)) {
            return n+1;
        } else {
            return primeAfter(n+1);
        }
    }

    private static boolean isPrime(int n) {
        return n > 1 && IntStream.rangeClosed(2, (int)Math.sqrt(n))
                .noneMatch(divisor -> n % divisor == 0);
    }

    public static List<Integer> primes(int from, int count) {
        return Stream.iterate(primeAfter(from-1), Primes::primeAfter)
                .limit(count)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("10 primes from 1: " + primes(1, 10));
        System.out.println("5 primes from 100: " + primes(100, 5));
        System.out.println("5000 primes from 2: " + primes(2, 5000));
    }
}
