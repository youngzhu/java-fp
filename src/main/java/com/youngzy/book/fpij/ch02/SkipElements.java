package com.youngzy.book.fpij.ch02;

import static com.youngzy.book.fpij.ch02.Folks.friends;

/**
 * @author youngzy
 * @since 2024-01-04
 */
public class SkipElements {
    public static void main(String[] args) {
        System.out.println("//" + "START:SKIP_OUTPUT");
        // 跳过前4个元素
        friends.stream()
                .skip(4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("//" + "END:SKIP_OUTPUT");

        // since JDK9
//        System.out.println("//" + "START:DROP_OUTPUT");
//        friends.stream()
//                .dropWhile(name -> name.length() > 4)
//                .map(String::toUpperCase)
//                .forEach(System.out::println);
//        System.out.println("//" + "END:DROP_OUTPUT");
    }
}
