package com.youngzy.book.fpij.ch04;

import static com.youngzy.book.fpij.ch04.Person.SAMPLE_DATA;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * @author youngzy
 * @since 2024-01-05
 */
public class CountEmailAddressesByLastName {
    public static void main(String[] args) {
        var namesAndEmailAddressesCount = SAMPLE_DATA.stream()
                .collect(groupingBy(Person::lastName,
                        summingInt(person -> person.emailAddresses().size())));

        System.out.println(namesAndEmailAddressesCount);
    }
}
