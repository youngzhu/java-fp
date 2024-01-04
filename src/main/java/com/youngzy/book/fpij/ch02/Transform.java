package com.youngzy.book.fpij.ch02;

import java.util.ArrayList;
import java.util.List;

import static com.youngzy.book.fpij.ch02.Folks.friends;

/**
 * @author youngzy
 * @since 2023-02-17
 */
public class Transform {
    public static void main(String[] args) {
        {
            final List<String> uppercaseNames = new ArrayList<>();

            for (String name : friends) {
                uppercaseNames.add(name.toUpperCase());
            }

            System.out.println(uppercaseNames);
        }

        {
            final List<String> uppercaseNames = new ArrayList<>();

            //BAD IDEA
            // 修改了uppercaseNames列表，不利于并发
            friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));

            System.out.println(friends);
            System.out.println(uppercaseNames);
        }

        System.out.println("--START: TRANSFORM_OUTPUT");
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.print(name + ", "));
        System.out.println();
        System.out.println("--END: TRANSFORM_OUTPUT");

        System.out.println("==START: NUMBER_OUTPUT");
        friends.stream()
                .map(name -> name.length())
                .forEach(len -> System.out.print(len + ", "));
        System.out.println();
        System.out.println("==END: NUMBER_OUTPUT");

        friends.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.print(name + ", "));
    }
}
