package com.youngzy.book.fpij.ch03;

import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;

import static com.youngzy.book.fpij.ch03.OlderThan20.OLDER_THAN_20;
import static com.youngzy.book.fpij.ch03.People.PEOPLE;
import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertArrayEquals;

public class OlderThan20Test {
    @Test
    public void badIdea() {
        List<Person> olderThan20 = new ArrayList<>();
        PEOPLE.stream()
                .filter(p -> p.getAge() > 20)
                .forEach(p -> olderThan20.add(p));

        assertArrayEquals(OLDER_THAN_20, olderThan20.toArray());
    }

    @Test
    public void collectVerbose() {
        List<Person> olderThan20 = PEOPLE.stream()
                .filter(p -> p.getAge() > 20)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        assertArrayEquals(OLDER_THAN_20, olderThan20.toArray());
    }

    @Test
    public void collectToList() {
        List<Person> olderThan20 = PEOPLE.stream()
                .filter(p -> p.getAge() > 20)
                .collect(toList());

        assertArrayEquals(OLDER_THAN_20, olderThan20.toArray());
    }

    @Test
    public void groupBy() {
        Map<Integer, List<Person>> groupBy = PEOPLE.stream()
                .collect(groupingBy(Person::getAge));

        System.out.println("Grouped by age: " + groupBy);
    }

    @Test
    public void nameOfPeopleByAge() {
        Map<Integer, List<String>> nameOfPeopleByAge = PEOPLE.stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));

        System.out.println("Grouped by age: " + nameOfPeopleByAge);
    }

    @Test
    public void oldestPersonOfEachLetter() {
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);

        Map<Character, Optional<Person>> oldestPersonOfEachLetter = PEOPLE.stream()
                // group by the first character of the name
                // and reduce to the person with the maximum age.
                .collect(groupingBy(p -> p.getName().charAt(0),
                        reducing(BinaryOperator.maxBy(byAge))));

        System.out.println("Oldest person of each letter: " + oldestPersonOfEachLetter);
    }
}