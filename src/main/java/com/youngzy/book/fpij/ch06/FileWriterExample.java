package com.youngzy.book.fpij.ch06;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author youngzy
 * @since 2023-03-22
 */
public class FileWriterExample {
    private final FileWriter writer;

    public FileWriterExample(String filename) throws IOException {
        this.writer = new FileWriter(filename);
    }

    public void writeStuff(String message) throws IOException {
        writer.write(message);
    }

    @Override
    protected void finalize() throws Throwable {
        writer.close();
    }

    public void close() throws IOException {
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        FileWriterExample fileWriterExample = new FileWriterExample("output/peekaboo.txt");

        // 空文件
//        fileWriterExample.writeStuff("peek-a-boo");

        // 有内容
//        fileWriterExample.writeStuff("call close()");
//        fileWriterExample.close();

        // 保证一定会调 close()
        try { //Rather verbose
            fileWriterExample.writeStuff("ensure call close()");
        } finally {
            fileWriterExample.close();
        }

    }
}
