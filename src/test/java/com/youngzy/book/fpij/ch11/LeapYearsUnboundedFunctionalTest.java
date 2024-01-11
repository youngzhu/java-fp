package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearsUnboundedFunctionalTest extends LeapYearsUnboundedTest {
    @BeforeEach
    public void init() {
        leapYearsUnbounded = new LeapYearsUnboundedFunctional();
    }
}