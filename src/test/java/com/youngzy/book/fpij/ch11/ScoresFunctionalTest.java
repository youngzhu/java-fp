package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ScoresFunctionalTest extends ScoresTest {

    @BeforeEach
    public void init() {
        scores = new ScoresFunctional();
    }

}