package com.youngzy.book.fpij.ch04;

import java.util.List;
import java.util.Map;

import static com.youngzy.book.fpij.ch04.Person.SAMPLE_DATA;
import static java.util.stream.Collectors.partitioningBy;

/**
 * @author youngzy
 * @since 2024-01-05
 */
public class Partition {
    public static void main(String[] args) {
        Map<Boolean, List<Person>> thoseWithAndWithoutMultipleEmails =
                SAMPLE_DATA.stream()
                        .collect(partitioningBy(person -> person.emailAddresses().size() > 1));

        System.out.println("Number of people with at most one email address: " +
                thoseWithAndWithoutMultipleEmails.get(false).size());

        System.out.println("Number of people with multiple email addresses: " +
                thoseWithAndWithoutMultipleEmails.get(true).size());
    }
}
