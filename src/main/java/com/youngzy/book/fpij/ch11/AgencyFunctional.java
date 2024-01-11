package com.youngzy.book.fpij.ch11;

import java.util.Set;

/**
 * @author youngzy
 * @since 2024-01-10
 */
public class AgencyFunctional extends Agency {
    public boolean isChaperoneRequired(Set<Person> people) {
        return people.size() > 0 &&
                people.stream()
                        .noneMatch(person -> person.age() >= 18);
    }
}
