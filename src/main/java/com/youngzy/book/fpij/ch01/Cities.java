package com.youngzy.book.fpij.ch01;

import java.util.Arrays;
import java.util.List;

/**
 * @author youngzy
 * @since 2023-02-16
 */
public class Cities {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Albany", "Boulder",
                "Chicago", "Denver", "Eugene");

        findChicagoImperative(cities);
        findChicagoDeclarative(cities);
    }

    private static void findChicagoDeclarative(List<String> cities) {
        System.out.println("Found Chicago?: " + cities.contains("Chicago"));
    }

    private static void findChicagoImperative(List<String> cities) {
        boolean found = false;

        for (String city : cities) {
            if (city.equals("Chicago")) {
                found = true;
                break;
            }
        }

        System.out.println("Found Chicago?: " + found);
    }
}
