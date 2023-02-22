package com.youngzy.book.fpij.ch03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author youngzy
 * @since 2023-02-22
 */
public class ListDirs {
    public static void main(String[] args) throws IOException {
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }
}
