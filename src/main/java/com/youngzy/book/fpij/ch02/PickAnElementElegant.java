package com.youngzy.book.fpij.ch02;

import java.util.List;
import java.util.Optional;

import static com.youngzy.book.fpij.ch02.Folks.*;

/**
 * @author youngzy
 * @since 2023-02-21
 */
public class PickAnElementElegant {
    public static void main(String[] args) {
        System.out.println("--START: NAME_OUTPUT");
        pickName(friends, "N");
        pickName(friends, "Z");
        System.out.println("--END: NAME_OUTPUT");

        System.out.println("==START: CLOSURE_OUTPUT");
        Optional<String> foundName = friends.stream()
                .filter(name -> name.startsWith("N"))
                .findFirst();
        foundName.ifPresent(name -> System.out.println("Hello " + name ));
        System.out.println("==END: CLOSURE_OUTPUT");
    }

    private static void pickName(List<String> names, String startingLetter) {
        Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();
        System.out.println(String.format("A name starting with %s: %s",
                startingLetter, foundName.orElse("No name found")));
    }
}
