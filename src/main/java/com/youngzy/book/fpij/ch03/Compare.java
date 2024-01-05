package com.youngzy.book.fpij.ch03;

import java.util.List;

/**
 * @author youngzy
 * @since 2023-02-21
 */
public class Compare {

    static void printPeople(String message, List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }

}
