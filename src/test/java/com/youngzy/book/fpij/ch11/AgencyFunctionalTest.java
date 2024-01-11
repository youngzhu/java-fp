package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class AgencyFunctionalTest extends AgencyTest {
    @BeforeEach
    public void init() {
        agency = new AgencyFunctional();
    }
}