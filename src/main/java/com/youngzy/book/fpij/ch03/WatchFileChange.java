package com.youngzy.book.fpij.ch03;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

/**
 * @author youngzy
 * @since 2023-02-22
 */
public class WatchFileChange {
    public static void main(String[] args) throws Exception {
        new Thread(() -> watchFileChange()).start();

        File file = new File("watch/sample.txt");
        file.createNewFile();
        Thread.sleep(5000);
        file.setLastModified(System.currentTimeMillis());
    }

    static void watchFileChange() {
        try {

            Path path = Paths.get("watch");
            WatchService watchService = path.getFileSystem().newWatchService();

            path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("Report any file changed within next 1 minute...");

            WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);

            if (watchKey != null) {
                watchKey.pollEvents().stream()
                        .forEach(event -> System.out.println(event.context()));
            }
        } catch (InterruptedException | IOException e) {
            System.out.println(e);
        }
    }
}
