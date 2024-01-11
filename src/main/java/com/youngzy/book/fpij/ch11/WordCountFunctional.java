package com.youngzy.book.fpij.ch11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author youngzy
 * @since 2024-01-11
 */
public class WordCountFunctional extends WordCount {
    public long countInFile(
            String searchWord, String filePath) throws IOException {

        return Files.lines(Paths.get(filePath))
                .flatMap(line -> Stream.of(line.split(" ")))
                .filter(word -> word.equals(searchWord))
                .count();
    }
}
