package com.youngzy.book.fpij.ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author youngzy
 * @since 2023-02-21
 */
public class Compare {
    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35)
        );

        {
            System.out.println("==START: AGE_ASCEND_OUTPUT");
            List<Person> ascendingAge = people.stream()
                    .sorted((p1, p2) -> p1.ageDifference(p2))
                    .collect(Collectors.toList());
            printPeople("Sorted in ascending order by age:",
                    ascendingAge);
            System.out.println("==END: AGE_ASCEND_OUTPUT");
        }

        {
            System.out.println("==START: AGE_ASCEND_MR_OUTPUT");
            List<Person> ascendingAge = people.stream()
                    .sorted(Person::ageDifference)
                    .collect(Collectors.toList());
            printPeople("Sorted in ascending order by age:",
                    ascendingAge);
            System.out.println("==END: AGE_ASCEND_MR_OUTPUT");
        }

        {
            System.out.println("==START: AGE_DESCEND_OUTPUT");
            printPeople("Sorted in descending order by age:",
                    people.stream()
                            .sorted((p1, p2) -> p2.ageDifference(p1))
                            .collect(Collectors.toList())
            );
            System.out.println("==END: AGE_DESCEND_OUTPUT");

            System.out.println("==START: REVERSE_ORDER_OUTPUT");
            Comparator<Person> compareAscending = (p1, p2) -> p1.ageDifference(p2);
            Comparator<Person> compareDescending = compareAscending.reversed();
            printPeople("Sorted in ascending order by age:",
                    people.stream()
                            .sorted(compareAscending)
                            .collect(Collectors.toList())
            );
            printPeople("Sorted in descending order by age:",
                    people.stream()
                            .sorted(compareDescending)
                            .collect(Collectors.toList())
            );
            System.out.println("==END: REVERSE_ORDER_OUTPUT");

            System.out.println("==START: NAME_ASCEND_OUTPUT");
            printPeople("Sorted in ascending order by name:",
                    people.stream()
                            .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                            .collect(Collectors.toList())
            );
            System.out.println("==END: NAME_ASCEND_OUTPUT");
        }

        {
            System.out.println("==START: YOUNGEST_OUTPUT");
            people.stream()
                    .min(Person::ageDifference)
                    .ifPresent(youngest -> System.out.println("Youngest: " + youngest));
            System.out.println("==END: YOUNGEST_OUTPUT");
        }

        {
            System.out.println("==START: ELDEST_OUTPUT");
            people.stream()
                    .max(Person::ageDifference)
                    .ifPresent(eldest -> System.out.println("Eldest: " + eldest));
            System.out.println("==END: ELDEST_OUTPUT");
        }

        {
            people.stream()
                    .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()));

            printPeople("Sorted in ascending order by name:",
                    people.stream()
                            .sorted(Comparator.comparing((Person p) -> p.getName()))
                            .collect(Collectors.toList())
            );

            Function<Person, String> byName = person -> person.getName();
            people.stream().sorted(Comparator.comparing(byName));
        }

        {
            System.out.println("==START: SORT_NAME_AND_AGE_OUTPUT");
            Function<Person, Integer> byAge = person -> person.getAge();
            Function<Person, String> byName = person -> person.getName();
            printPeople("Sorted in ascending order by age and name:",
                    people.stream()
                            .sorted(Comparator.comparing(byAge).thenComparing(byName))
                            .collect(Collectors.toList())
            );

            System.out.println("==END: SORT_NAME_AND_AGE_OUTPUT");
        }
    }

    static void printPeople(String message, List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }
}
