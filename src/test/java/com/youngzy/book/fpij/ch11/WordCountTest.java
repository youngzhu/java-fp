package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCountTest {
    WordCount wordCount;

    @BeforeEach
    public void init() {
        wordCount = new WordCount();
    }

    @Test
    public void count() {
        assertAll(
                () -> assertEquals(3,
                        wordCount.countInFile("big", "src/test/resources/refactoring_test.txt")),
                () -> assertEquals(1,
                        wordCount.countInFile("world", "src/test/resources/refactoring_test.txt"))

        );
    }

    @Test
    public void fileEncoding() {
        System.out.println(System.getProperty("file.encoding"));
    }
}