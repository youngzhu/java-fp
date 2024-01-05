package com.youngzy.book.fpij.ch03;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author youngzy
 * @since 2024-01-05
 */
public class People {
    final static Person JOHN = new Person("John", 20);
    public static final Person SARA = new Person("Sara", 21);
    public static final Person JANE = new Person("Jane", 21);
    public static final Person GREG = new Person("Greg", 35);


    final static List<Person> PEOPLE = asList(
            SARA,
            JOHN,
            JANE,
            GREG
    );

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

}
