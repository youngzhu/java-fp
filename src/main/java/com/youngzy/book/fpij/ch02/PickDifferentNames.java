package com.youngzy.book.fpij.ch02;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.youngzy.book.fpij.ch02.Folks.*;

/**
 * @author youngzy
 * @since 2023-02-17
 */
public class PickDifferentNames {
    static Predicate<String> checkStartWith(String letter) {
        return name -> name.startsWith(letter);
    }

    public static void main(String[] args) {
        {
            Predicate<String> startWithN = name -> name.startsWith("N");
            Predicate<String> startWithB = name -> name.startsWith("B");
            long countFriendsStartN = friends.stream()
                    .filter(startWithN)
                    .count();
            long countFriendsStartB = friends.stream()
                    .filter(startWithB)
                    .count();

            System.out.println(String.format("startWithN: %d, startWithB: %d",
                    countFriendsStartN, countFriendsStartB));
        }

        {
            long countFriendsStartN = friends.stream()
                    .filter(checkStartWith("N"))
                    .count();
            long countFriendsStartB = friends.stream()
                    .filter(checkStartWith("B"))
                    .count();

            System.out.println(String.format("startWithN: %d, startWithB: %d",
                    countFriendsStartN, countFriendsStartB));
        }

        {
            Function<String, Predicate<String>> startWithLetter =
                    (String letter) -> {
                        Predicate<String> checkStart = (String name) -> name.startsWith(letter);
                        return checkStart;
                    };

            long countFriendsStartN = friends.stream()
                    .filter(startWithLetter.apply("N"))
                    .count();
            long countFriendsStartB = friends.stream()
                    .filter(startWithLetter.apply("B"))
                    .count();

            System.out.println(String.format("startWithN: %d, startWithB: %d",
                    countFriendsStartN, countFriendsStartB));
        }

        {
            Function<String, Predicate<String>> startWithLetter =
                    (String letter) -> (String name) -> name.startsWith(letter);

            long countFriendsStartN = friends.stream()
                    .filter(startWithLetter.apply("N"))
                    .count();
            long countFriendsStartB = friends.stream()
                    .filter(startWithLetter.apply("B"))
                    .count();

            System.out.println(String.format("startWithN: %d, startWithB: %d",
                    countFriendsStartN, countFriendsStartB));
        }

        {
            Function<String, Predicate<String>> startWithLetter =
                    letter -> name -> name.startsWith(letter);

            long countFriendsStartN = friends.stream()
                    .filter(startWithLetter.apply("N"))
                    .count();
            long countFriendsStartB = friends.stream()
                    .filter(startWithLetter.apply("B"))
                    .count();

            System.out.println(String.format("startWithN: %d, startWithB: %d",
                    countFriendsStartN, countFriendsStartB));
        }
    }
}
