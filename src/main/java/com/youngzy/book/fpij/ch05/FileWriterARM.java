package com.youngzy.book.fpij.ch05;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author youngzy
 * @since 2023-03-22
 */
public class FileWriterARM implements AutoCloseable {
    private final FileWriter writer;

    public FileWriterARM(String filename) throws IOException {
        this.writer = new FileWriter(filename);
    }

    public void writeStuff(String message) throws IOException {
        writer.write(message);
    }

    public void close() throws IOException {
        System.out.println("close() called automatically.");
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        try(FileWriterARM fileWriterExample = new FileWriterARM("peekaboo.txt")){
            fileWriterExample.writeStuff("peek-a-boo by FileWriterARM");

            System.out.println("done with the resource.");
        }
    }
}
