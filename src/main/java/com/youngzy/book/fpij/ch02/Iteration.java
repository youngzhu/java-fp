package com.youngzy.book.fpij.ch02;

import java.util.function.Consumer;

import static com.youngzy.book.fpij.ch02.Folks.friends;

/**
 * @author youngzy
 * @since 2023-02-16
 */
public class Iteration {
    public static void main(String[] args) {
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        for (String name : friends) {
            System.out.println(name);
        }

        System.out.println("--START: INTERNAL_FOR_EACH_OUTPUT");
        friends.forEach(new Consumer<String>() { //Verbose, please don't do this
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("--END: INTERNAL_FOR_EACH_OUTPUT");

        System.out.println("--START: INTERNAL_OUTPUT");
        friends.forEach((final String name) -> System.out.println(name));
        System.out.println("--END: INTERNAL_OUTPUT");

        friends.forEach((name) -> System.out.println(name));
        friends.forEach(name -> System.out.println(name));
        friends.forEach(System.out::println);
    }
}
