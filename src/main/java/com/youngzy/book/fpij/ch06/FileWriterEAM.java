package com.youngzy.book.fpij.ch06;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author youngzy
 * @since 2023-03-22
 */
public class FileWriterEAM {
    private final FileWriter writer;

    private FileWriterEAM(String filename) throws IOException {
        this.writer = new FileWriter(filename);
    }

    private void close() throws IOException {
        System.out.println("close() called automatically.");
        writer.close();
    }

    public void writeStuff(String message) throws IOException {
        writer.write(message);
    }

    public static void use(String filename,
                           UseInstance<FileWriterEAM, IOException> block)
            throws IOException {

        FileWriterEAM fileWriterEAM = new FileWriterEAM(filename);
        try {
            block.accept(fileWriterEAM);
        } finally {
            fileWriterEAM.close();
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriterEAM.use("output/eam.txt",
                writer -> writer.writeStuff("sweet"));

        FileWriterEAM.use("output/eam2.txt",
                writer -> {
                    writer.writeStuff("so");
                    writer.writeStuff(" sweet");
                });
    }
}
