package com.youngzy.book.fpij.ch03;

import java.util.List;

import static com.youngzy.book.fpij.ch03.People.*;
import static java.util.Arrays.asList;

/**
 * @author youngzy
 * @since 2023-02-21
 */
public class Compare {

    final static List<Person> ASCENDING_AGE = asList(
            JOHN,
            SARA,
            JANE,
            GREG
    );

    final static List<Person> DESCENDING_AGE = asList(
            GREG,
            SARA,
            JANE,
            JOHN
    );

    final static List<Person> ASCENDING_NAME = asList(
            GREG,
            JANE,
            JOHN,
            SARA
    );

    final static List<Person> ASCENDING_AGE_NAME = asList(
            JOHN,
            JANE,
            SARA,
            GREG
    );

    static void printPeople(String message, List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }

}
