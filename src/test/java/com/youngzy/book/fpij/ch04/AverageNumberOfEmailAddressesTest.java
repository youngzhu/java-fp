package com.youngzy.book.fpij.ch04;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.youngzy.book.fpij.ch04.Person.SAMPLE_DATA;

public class AverageNumberOfEmailAddressesTest {
    @Test
    public void test1() {
        double avg = SAMPLE_DATA.stream()
                .map(Person::emailAddresses)
                .mapToDouble(List::size)
                .sum() / SAMPLE_DATA.size() * 1.0;

        System.out.println("Average number of email addresses: " + avg);
    }

    @Test
    public void test2() {
        double avg = SAMPLE_DATA.stream()
                .map(Person::emailAddresses)
                .mapToDouble(List::size)
                .average()
                .orElse(0);

        System.out.println("Average number of email addresses: " + avg);
    }

    @Test
    public void test3() {
        double avg = SAMPLE_DATA.stream()
                .mapToDouble(p -> p.emailAddresses().size())
                .average()
                .orElse(0);

        System.out.println("Average number of email addresses: " + avg);
    }

    @Test
    public void test4() {
        double avg = SAMPLE_DATA.stream()
                .collect(Collectors.averagingDouble(p -> p.emailAddresses().size()));

        System.out.println("Average number of email addresses: " + avg);
    }
}