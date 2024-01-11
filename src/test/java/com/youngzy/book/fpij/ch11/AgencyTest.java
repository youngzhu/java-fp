package com.youngzy.book.fpij.ch11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AgencyTest {
    Agency agency;

    @BeforeEach
    public void init() {
        agency = new Agency();
    }

    @Test
    public void isChaperoneRequired() {
        assertAll(
                () -> assertTrue(agency.isChaperoneRequired(
                        Set.of(new Person("Jake", 12)))),
                () -> assertTrue(agency.isChaperoneRequired(
                        Set.of(new Person("Jake", 12), new Person("Pam", 14)))),
                () -> assertTrue(agency.isChaperoneRequired(
                        Set.of(new Person("Shiv", 8),
                                new Person("Sam", 9), new Person("Jill", 11)))),
                () -> assertTrue(agency.isChaperoneRequired(
                        Set.of(new Person("Ava", 17)))),
                () -> assertFalse(agency.isChaperoneRequired(
                        Set.of(new Person("Jake", 12), new Person("Pam", 18)))),
                () -> assertFalse(agency.isChaperoneRequired(Set.of()))
        );
    }
}