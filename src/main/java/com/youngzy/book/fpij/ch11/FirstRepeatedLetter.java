package com.youngzy.book.fpij.ch11;

/**
 * @author youngzy
 * @since 2024-01-11
 */
public class FirstRepeatedLetter {
    public char findIn(String word) {
        char[] letters = word.toCharArray();

        for(char candidate: letters) {
            int count = 0;

            for(char letter: letters) {
                if(candidate == letter) {
                    count++;
                }
            }

            if(count > 1) {
                return candidate;
            }
        }

        return '\0';
    }
}
