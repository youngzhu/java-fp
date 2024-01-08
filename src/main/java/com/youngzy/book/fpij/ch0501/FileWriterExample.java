package com.youngzy.book.fpij.ch0501;

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
        FileWriterExample fileWriterExample = new FileWriterExample("peekaboo.txt");

        try {
            fileWriterExample.writeStuff("peek-a-boo");
        }finally {
            // 必须显示调用，消息才会写入文件
            fileWriterExample.close();
        }

    }
}
