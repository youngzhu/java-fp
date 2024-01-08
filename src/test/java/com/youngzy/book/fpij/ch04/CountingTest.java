package com.youngzy.book.fpij.ch04;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.youngzy.book.fpij.ch04.Person.SAMPLE_DATA;
import static java.util.stream.Collectors.*;

public class CountingTest {
    @Test
    public void countingLong() {
        Map<String, Long> namesCount = SAMPLE_DATA.stream()
                .collect(groupingBy(Person::firstName, counting()));

        System.out.println(namesCount);
    }

    @Test
    public void countingInt() {
        Map<String, Integer> namesCount = SAMPLE_DATA.stream()
                .collect(groupingBy(Person::firstName,
                        collectingAndThen(counting(), Long::intValue)));

        System.out.println(namesCount);
    }
}