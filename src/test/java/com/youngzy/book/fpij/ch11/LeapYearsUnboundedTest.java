package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearsUnboundedTest {
    LeapYearsUnbounded leapYearsUnbounded;

    @BeforeEach
    public void init() {
        leapYearsUnbounded = new LeapYearsUnbounded();
    }

    @Test
    public void count() {
        assertAll(
                () -> assertEquals(25,
                        leapYearsUnbounded.countFrom1900(year -> year <= 2000)),
                () -> assertEquals(27,
                        leapYearsUnbounded.countFrom1900(year -> year <= 2010)),
                () -> assertEquals(31,
                        leapYearsUnbounded.countFrom1900(year -> year <= 2025)),
                () -> assertEquals(49,
                        leapYearsUnbounded.countFrom1900(year -> year <= 2100)),
                () -> assertEquals(0,
                        leapYearsUnbounded.countFrom1900(year -> year <= 1800))
        );
    }
}