package com.youngzy.book.fpij.ch07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author youngzy
 * @since 2023-03-24
 */
public class LazyStreams {
    private static int length(String name) {
        System.out.println("getting length for " + name);
        return name.length();
    }

    private static String toUpper(String name) {
        System.out.println("converting to uppercase: " + name);
        return name.toUpperCase();
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe",
                "Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson");

        {
            System.out.println("==START:CHAIN_OUTPUT");
            String firstNameWith3Letters = names.stream()
                    .filter(name -> length(name) == 3)
                    .map(name ->toUpper(name))
                    .findFirst()
                    .get();
            System.out.println(firstNameWith3Letters);
            System.out.println("==END:CHAIN_OUTPUT");
        }

        {
            System.out.println("==START:SPLIT_OUTPUT");
            Stream<String> namesWith3Letters = names.stream()
                            .filter(name -> length(name) == 3)
                                    .map(name -> toUpper(name));

            System.out.println("Stream created, filtered, mapped...");
            System.out.println("ready to call findFirst...");

            String firstNameWith3Letters = namesWith3Letters.findFirst()
                            .get();
            System.out.println(firstNameWith3Letters);
            System.out.println("==END:SPLIT_OUTPUT");
        }
    }
}
