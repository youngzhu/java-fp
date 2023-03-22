package com.youngzy.book.fpij.ch04;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author youngzy
 * @since 2023-03-22
 */
public class HandleException {
    public static void main(String[] args) {
        Stream.of("/usr", "/tmp")
                .map(path -> {
                    try {
                        return new File(path).getCanonicalPath();
                    } catch (IOException e) {
                        return e.getMessage();
                    }
                })
                .forEach(System.out::println);
    }
}
