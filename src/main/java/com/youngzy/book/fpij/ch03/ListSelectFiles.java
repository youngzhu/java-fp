package com.youngzy.book.fpij.ch03;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author youngzy
 * @since 2023-02-22
 */
public class ListSelectFiles {
    public static void main(String[] args) throws Exception {
        String testPath = "src/main/java/com/youngzy/book/fpij/ch03";

        {
            String[] files = new File(testPath)
                    .list(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.endsWith(".java");
                        }
                    });
//            System.out.println(files);
        }

        Files.newDirectoryStream(Paths.get(testPath),
                        path -> path.toString().endsWith(".java"))
                .forEach(System.out::println);
    }
}
