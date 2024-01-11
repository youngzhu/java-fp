package com.youngzy.book.fpij.ch11;

import com.youngzy.book.fpij.ch09.StockInfo;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author youngzy
 * @since 2024-01-11
 */
public class FirstRepeatedLetterFunctional extends FirstRepeatedLetter {
    public char findIn(String word) {
        return Stream.of(word.split(""))
                .filter(FirstRepeatedLetterFunctional.isDuplicated(word))
                .findFirst()
                .map(letter -> letter.charAt(0))
                .orElse('\0');
    }

    public static Predicate<String> isDuplicated(String word) {
        return letter -> word.lastIndexOf(letter) > word.indexOf(letter);
    }
}
