package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstRepeatedLetterTest {
    FirstRepeatedLetter firstRepeatedLetter;

    @BeforeEach
    public void init() {
        firstRepeatedLetter = new FirstRepeatedLetter();
    }

    @Test
    public void findFirstRepeating() {
        assertAll(
                () -> assertEquals('l', firstRepeatedLetter.findIn("hello")),
                () -> assertEquals('h', firstRepeatedLetter.findIn("hellothere")),
                () -> assertEquals('a', firstRepeatedLetter.findIn("magicalguru")),
                () -> assertEquals('\0', firstRepeatedLetter.findIn("once")),
                () -> assertEquals('\0', firstRepeatedLetter.findIn(""))
        );
    }
}