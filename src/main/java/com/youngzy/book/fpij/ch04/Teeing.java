package com.youngzy.book.fpij.ch04;

import static com.youngzy.book.fpij.ch04.Person.SAMPLE_DATA;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * @author youngzy
 * @since 2024-01-05
 */
public class Teeing {
    public static void main(String[] args) {
        record MinMax(String least, String most) {
        }

        var leastAndMostEmailAddressPerson = SAMPLE_DATA.stream()
                .collect(
                        teeing(
                                minBy(comparing(person -> person.emailAddresses().size())),
                                maxBy(comparing(person -> person.emailAddresses().size())),
                                (min, max) -> new MinMax(min.map(Person::fullName).orElse(""),
                                        max.map(Person::fullName).orElse(""))));

        System.out.println(leastAndMostEmailAddressPerson);
    }
}
