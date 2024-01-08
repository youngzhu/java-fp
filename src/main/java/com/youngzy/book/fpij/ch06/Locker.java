package com.youngzy.book.fpij.ch06;

import java.util.concurrent.locks.Lock;

/**
 * @author youngzy
 * @since 2023-03-23
 */
public class Locker {
    public static void runLocked(Lock lock, Runnable block) {
        lock.lock();

        try {
            block.run();
        } finally {
            lock.unlock();
        }
    }
}
