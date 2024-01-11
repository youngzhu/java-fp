package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class FirstRepeatedLetterFunctionalTest extends FirstRepeatedLetterTest {
    @BeforeEach
    public void init() {
        firstRepeatedLetter = new FirstRepeatedLetterFunctional();
    }
}