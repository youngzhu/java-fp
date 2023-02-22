package com.youngzy.book.fpij.ch03;

import java.io.File;
import java.util.Arrays;

/**
 * @author youngzy
 * @since 2023-02-22
 */
public class ListHiddenFiles {
    public static void main(String[] args) {
        File[] files = new File(".")
                .listFiles(file -> file.isHidden());

        new File(".").listFiles(File::isHidden);

        Arrays.stream(files).forEach(System.out::println);
    }
}
