package com.youngzy.book.fpij.ch11;

import java.time.Year;
import java.util.stream.IntStream;

/**
 * @author youngzy
 * @since 2024-01-10
 */
public class LeapYearsFunctional extends LeapYears {
    public int countFrom1900(int upTo) {
        System.out.println("functional style");
        return (int) IntStream.iterate(
                        1900, year -> year <= upTo, year -> year + 4)
                .filter(Year::isLeap)
                .count();
    }
}
