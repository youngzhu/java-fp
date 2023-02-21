package com.youngzy.book.fpij.ch02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.youngzy.book.fpij.ch02.Folks.*;

/**
 * @author youngzy
 * @since 2023-02-17
 */
public class PickElementsMultipleCollection {
    public static void main(String[] args) {
        {
            long countFriendsStartN = friends.stream()
                    .filter(name -> name.startsWith("N"))
                    .count();

            long countEditorsStartN = editors.stream()
                    .filter(name -> name.startsWith("N"))
                    .count();

            long countComradesStartN = comrades.stream()
                    .filter(name -> name.startsWith("N"))
                    .count();

            System.out.println(countFriendsStartN);
            System.out.println(countEditorsStartN);
            System.out.println(countComradesStartN);
        }

        Predicate<String> startsWithN = name -> name.startsWith("N");

        long countFriendsStartN = friends.stream()
                .filter(startsWithN)
                .count();
        long countEditorsStartN = editors.stream()
                .filter(startsWithN)
                .count();
        long countComradesStartN = comrades.stream()
                .filter(startsWithN)
                .count();

        System.out.println("==");
        System.out.println(countFriendsStartN);
        System.out.println(countEditorsStartN);
        System.out.println(countComradesStartN);
    }
}
