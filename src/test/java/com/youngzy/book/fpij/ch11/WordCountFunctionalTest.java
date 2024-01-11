package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class WordCountFunctionalTest extends WordCountTest {

    @BeforeEach
    public void init() {
        wordCount = new WordCountFunctional();
    }

}