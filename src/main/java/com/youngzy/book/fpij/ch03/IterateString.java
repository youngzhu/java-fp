package com.youngzy.book.fpij.ch03;

/**
 * @author youngzy
 * @since 2023-02-21
 */
public class IterateString {
    public static void main(String[] args) {
        String str = "w00t";

        System.out.println("==START: ITERATE_OUTPUT");
        str.chars()
                .forEach(ch -> System.out.println(ch));
        System.out.println("==END: ITERATE_OUTPUT");

        str.chars()
                .forEach(System.out::println);

        System.out.println("==START: FIX_OUTPUT");
        str.chars()
                .forEach(IterateString::printChar);
        System.out.println("==END: FIX_OUTPUT");

        str.chars()
                .mapToObj(ch -> Character.valueOf((char) ch))
                .forEach(System.out::println);

        System.out.println("==START: FILTER_OUTPUT");
        str.chars()
                .filter(ch -> Character.isDigit(ch))
                .forEach(ch -> printChar(ch));
        System.out.println("==END: FILTER_OUTPUT");

        str.chars()
                .filter(ch -> Character.isDigit(ch));
        str.chars()
                .filter(Character::isDigit);
        str.chars()
                .filter(Character::isDigit)
                .forEach(IterateString::printChar);
    }

    static void printChar(int ch) {
        System.out.println((char) ch);
    }
}
