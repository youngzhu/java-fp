package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class FactorialFunctionalTest extends FactorialTest {
    @BeforeEach
    public void init() {
        factorial = new FactorialFunctional();
    }
}