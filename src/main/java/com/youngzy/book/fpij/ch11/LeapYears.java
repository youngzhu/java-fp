package com.youngzy.book.fpij.ch11;

import java.time.Year;

/**
 * @author youngzy
 * @since 2024-01-10
 */
public class LeapYears {
    public int countFrom1900(int upTo) {
        int numberOfLeapYears = 0;

        for(int i = 1900; i <= upTo; i += 4) {
            if(Year.isLeap(i)) {
                numberOfLeapYears++;
            }
        }

        return numberOfLeapYears;
    }
}
