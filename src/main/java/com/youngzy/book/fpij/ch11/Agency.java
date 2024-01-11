package com.youngzy.book.fpij.ch11;

import java.util.Set;

/**
 * @author youngzy
 * @since 2024-01-10
 */
public class Agency {
    public boolean isChaperoneRequired(Set<Person> people) {
        boolean required = true;

        if(people.size() == 0) {
            required = false;
        } else {
            for(var person: people) {
                if(person.age() >= 18) {
                    required = false;
                    break;
                }
            }
        }

        return required;
    }
}
