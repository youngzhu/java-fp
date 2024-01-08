package com.youngzy.book.fpij.ch03;


import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static com.youngzy.book.fpij.ch03.Compare.*;
import static com.youngzy.book.fpij.ch03.People.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareTest {

    @Test
    public void ascendingAge() {
        List<Person> ascendingAge = PEOPLE.stream()
                .sorted((p1, p2) -> p1.ageDifference(p2))
                .collect(toList());

        printPeople("Sorted in ascending order by age:",
                ascendingAge);

        assertArrayEquals(ASCENDING_AGE.toArray(), ascendingAge.toArray());
    }

    @Test
    public void ascendingAgeMR() { // Method Reference
        List<Person> ascendingAge = PEOPLE.stream()
                .sorted(Person::ageDifference)
                .collect(toList());

        assertArrayEquals(ASCENDING_AGE.toArray(), ascendingAge.toArray());
    }

    @Test
    public void descendingAge() {
        List<Person> descendingAge = PEOPLE.stream()
                .sorted((p1, p2) -> p2.ageDifference(p1))
                .collect(toList());

        assertArrayEquals(DESCENDING_AGE.toArray(), descendingAge.toArray());
    }

    // 可消除重复代码
    @Test
    public void reverse() {
        Comparator<Person> compareAscending = (p1, p2) -> p1.ageDifference(p2);
        Comparator<Person> compareDescending = compareAscending.reversed();

        List<Person> ascendingAge = PEOPLE.stream()
                .sorted(compareAscending)
                .collect(toList());

        assertArrayEquals(ASCENDING_AGE.toArray(), ascendingAge.toArray());

        //
        List<Person> descendingAge = PEOPLE.stream()
                .sorted(compareDescending)
                .collect(toList());

        assertArrayEquals(DESCENDING_AGE.toArray(), descendingAge.toArray());
    }

    @Test
    public void ascendingName() {
        List<Person> ascendingName = PEOPLE.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .collect(toList());

        assertArrayEquals(ASCENDING_NAME.toArray(), ascendingName.toArray());
    }

    // 使用 Function+comparing
    @Test
    public void ascendingNameComparing() {
        Function<Person, String> byName = person -> person.getName();

        List<Person> ascendingName = PEOPLE.stream()
                .sorted(comparing(byName))
                .collect(toList());

        assertArrayEquals(ASCENDING_NAME.toArray(), ascendingName.toArray());
    }

    @Test
    public void ascendingAgeAndName() {
        Function<Person, Integer> byAge = person -> person.getAge();
        Function<Person, String> byName = person -> person.getName();

        List<Person> ascendingAgeAndName = PEOPLE.stream()
                .sorted(comparing(byAge).thenComparing(byName))
                .collect(toList());

        assertArrayEquals(ASCENDING_AGE_NAME.toArray(), ascendingAgeAndName.toArray());
    }

    @Test
    public void youngest() {
        Person youngest = PEOPLE.stream()
                .min(Person::ageDifference)
                .get();

        assertEquals(JOHN, youngest);
    }

    @Test
    public void eldest() {
        Person eldest = PEOPLE.stream()
                .max(Person::ageDifference)
                .get();

        assertEquals(GREG, eldest);
    }
}