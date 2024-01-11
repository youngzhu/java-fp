package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PythagoreanTriplesFunctionalTest extends PythagoreanTriplesTest {

    @BeforeEach
    public void init() {
        pythagoreanTriples = new PythagoreanTriplesFunctional();
    }

}