package com.youngzy.book.fpij.ch03;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author youngzy
 * @since 2023-02-22
 */
public class ListSubDirs {
    static void listTheHardWay() {
        List<File> files = new ArrayList<>();

        File[] filesInCurrentDir = new File(".").listFiles();
        for (File f : filesInCurrentDir) {
            File[] filesInSubDir = f.listFiles();
            if (filesInSubDir != null) {
                files.addAll(Arrays.asList(filesInSubDir));
            } else {
                files.add(f);
            }
        }

        System.out.println("Count: " + files.size());
    }

    static void betterWay() {
        List<File> files = Stream.of(new File(".").listFiles())
                .flatMap(file -> file.listFiles() == null ?
                        Stream.of(file) : Stream.of(file.listFiles()))
                .collect(Collectors.toList());
        System.out.println("Count: " + files.size());
    }

    public static void main(String[] args) {
        System.out.println("START:HARD_WAY_OUTPUT");
        listTheHardWay();
        System.out.println("END:HARD_WAY_OUTPUT");

        betterWay();
    }
}
