package com.youngzy.book.fpij.ch02;

import java.util.Optional;

import static com.youngzy.book.fpij.ch02.Folks.friends;

/**
 * @author youngzy
 * @since 2023-02-21
 */
public class PickALongest {
    public static void main(String[] args) {
        System.out.println("==START: SUM_OUTPUT");
        System.out.println("Total number of characters in all names: " +
                friends.stream()
                        .mapToInt(name -> name.length())
                        .sum());
        System.out.println("==END: SUM_OUTPUT");

        System.out.println("==START: REDUCE_OUTPUT");
        Optional<String> longestName = friends.stream()
                        .reduce((name1, name2) ->
                                name1.length() >= name2.length() ? name1 : name2);
        longestName.ifPresent(name ->
                System.out.println(String.format("A longest name: %s", name)));
        System.out.println("==END: REDUCE_OUTPUT");

        // 提供一个默认值（或者叫最小值）
        // 这样返回值也不用Optional了，因为一定会有值
        String steveOrLonger = friends.stream()
                .reduce("Steve", (name1, name2) ->
                        name1.length() >= name2.length() ? name1 : name2);
        System.out.println(steveOrLonger);
    }
}
