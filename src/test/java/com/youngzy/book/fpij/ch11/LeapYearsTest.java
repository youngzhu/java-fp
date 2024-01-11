package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearsTest {
    LeapYears leapYears;

    @BeforeEach
    public void init() {
        leapYears = new LeapYears();
    }

    @Test
    public void countFrom1900() {
        assertAll(
                () -> assertEquals(25, leapYears.countFrom1900(2000)),
                () -> assertEquals(27, leapYears.countFrom1900(2010)),
                () -> assertEquals(31, leapYears.countFrom1900(2025)),
                () -> assertEquals(49, leapYears.countFrom1900(2100)),
                () -> assertEquals(0, leapYears.countFrom1900(1800))
        );
    }
}