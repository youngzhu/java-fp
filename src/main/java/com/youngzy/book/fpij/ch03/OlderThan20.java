package com.youngzy.book.fpij.ch03;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static com.youngzy.book.fpij.ch03.People.*;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

/**
 * @author youngzy
 * @since 2023-02-21
 */
public class OlderThan20 {

    static final Person[] OLDER_THAN_20 = {
            SARA,
            JANE,
            GREG
    };

    public static void main(String[] args) {
        final List<Person> people = asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35)
        );











        {
            System.out.println("==START:OLDEST_IN_EACH_LETTER_OUTPUT");
            Comparator<Person> byAge = Comparator.comparing(Person::getAge);
            Map<Character, Optional<Person>> oldestPersonOfEachLetter = people.stream()
                    .collect(groupingBy(p -> p.getName().charAt(0),
                            reducing(BinaryOperator.maxBy(byAge))));
            System.out.println("Oldest person of each letter:" + oldestPersonOfEachLetter);
            System.out.println("==END:OLDEST_IN_EACH_LETTER_OUTPUT");
        }
    }
}
