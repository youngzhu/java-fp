package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearsFunctionalTest extends LeapYearsTest {
    @BeforeEach
    public void init() {
        leapYears = new LeapYearsFunctional();
    }
}