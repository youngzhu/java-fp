package com.youngzy.book.fpij.ch04;

import org.junit.jupiter.api.Test;

import static com.youngzy.book.fpij.ch04.Person.SAMPLE_DATA;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    @Test
    public void anyMatch() {
        assertTrue(SAMPLE_DATA.stream()
                .anyMatch(person -> person.emailAddresses().size() > 0));

        assertFalse(SAMPLE_DATA.stream()
                .anyMatch(person -> person.emailAddresses().size() > 10));
    }

    @Test
    public void allMatch() {
        assertFalse(SAMPLE_DATA.stream()
                .allMatch(person -> person.emailAddresses().size() > 0));

        assertTrue(SAMPLE_DATA.stream()
                .anyMatch(person -> person.emailAddresses().size() >= 0));
    }

    @Test
    public void noneMatch() {
        assertFalse(SAMPLE_DATA.stream()
                .noneMatch(person -> person.emailAddresses().size() > 0));

        assertTrue(SAMPLE_DATA.stream()
                .noneMatch(person -> person.emailAddresses().size() > 10));
    }
}