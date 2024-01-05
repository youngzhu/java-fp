package com.youngzy.book.fpij.ch04;

import org.junit.Test;

import java.util.List;

import static com.youngzy.book.fpij.ch04.Person.SAMPLE_DATA;

public class MapVSFlatMapTest {

    @Test
    public void map() {
        List<List<String>> listOfListOfEmailAddresses = SAMPLE_DATA.stream()
                .map(Person::emailAddresses)
                .toList();

        System.out.println(listOfListOfEmailAddresses);
    }

    @Test
    public void flatMap() {
        List<String> listOfEmailAddresses = SAMPLE_DATA.stream()
                .flatMap(p -> p.emailAddresses().stream())
                .toList();

        System.out.println(listOfEmailAddresses);
    }
}