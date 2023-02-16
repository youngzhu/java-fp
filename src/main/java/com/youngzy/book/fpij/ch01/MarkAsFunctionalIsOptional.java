package com.youngzy.book.fpij.ch01;

/**
 * @author youngzy
 * @since 2023-02-16
 */
public class MarkAsFunctionalIsOptional {

    public interface Sample1 {
        boolean test(int input);
    }

    @FunctionalInterface
    public interface Sample2 {
        boolean test(int input);
    }

    public static void main(String[] args) {
        Sample1 s1 = input -> true;
        Sample2 s2 = input -> true;

        System.out.println(s1.test(4));
        System.out.println(s2.test(4));
    }
}
