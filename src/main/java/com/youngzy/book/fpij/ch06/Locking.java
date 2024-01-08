package com.youngzy.book.fpij.ch06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.youngzy.book.fpij.ch06.Locker.runLocked;

/**
 * @author youngzy
 * @since 2023-03-23
 */
public class Locking {
    Lock lock = new ReentrantLock();

    protected void setLock(Lock lock) {
        this.lock = lock;
    }

    // 旧模式：冗长、易错、难维护
    public void doOp1() {
        lock.lock();
        try {
            // ...critical code...
        } finally {
            lock.unlock();
        }
    }

    // lambda
    public void doOp2() {
        runLocked(lock, () -> {/* ...critical code... */});
    }
    public void doOp3() {
        runLocked(lock, () -> {/* ...critical code... */});
    }
    public void doOp4() {
        runLocked(lock, () -> {/* ...critical code... */});
    }
}
