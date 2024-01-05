package com.youngzy.book.fpij.ch03;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListSelectFilesTest {

    String testPath = "src/main/java/com/youngzy/book/fpij/ch03";

    @Test
    public void habitual() {
        final String[] files =
                new File(testPath).list(new java.io.FilenameFilter() {
                    public boolean accept(final File dir, final String name) {
                        return name.endsWith(".java");
                    }
                });

        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        }
    }

    @Test
    public void lambda() throws IOException {
        Files.newDirectoryStream(Paths.get(testPath),
                        path -> path.toString().endsWith(".java"))
                .forEach(System.out::println);
    }
}