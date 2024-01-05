package com.youngzy.book.fpij.ch04;

import static com.youngzy.book.fpij.ch04.Person.SAMPLE_DATA;
import static java.util.stream.Collectors.*;

/**
 * @author youngzy
 * @since 2024-01-05
 */
public class FlatMappingAndFiltering {
    public static void main(String[] args) {
//        var lastNamesAndEmailAddressesFiltered = SAMPLE_DATA.stream()
//                .collect(groupingBy(Person::lastName,
//                        flatMapping(person -> person.emailAddresses().stream(),
//                                filtering(address -> address.endsWith(".com"), toList()))));

        var lastNamesAndEmailAddressesFiltered = SAMPLE_DATA.stream()
                .collect(groupingBy(Person::lastName,
                        flatMapping(person -> person.emailAddresses().stream().map(String::toLowerCase),
                                filtering(address -> address.endsWith(".com"), toList()))));

        System.out.println(lastNamesAndEmailAddressesFiltered);
    }
}
