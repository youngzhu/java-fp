package com.youngzy.book.fpij.ch11;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author youngzy
 * @since 2024-01-11
 */
public class WordCount {
    public long countInFile(String searchWord, String filePath) throws IOException {

        long count = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//        InputStream inputStream = WordCount.class.getClassLoader().getResourceAsStream(filePath);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;

        while((line = bufferedReader.readLine()) != null) {
            String[] words = line.split(" ");

            for(String word: words) {
                if(word.equals(searchWord)) {
                    count++;
                }
            }
        }

        return count;
    }
}
