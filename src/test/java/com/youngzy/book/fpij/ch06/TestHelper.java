package com.youngzy.book.fpij.ch06;

import static org.junit.Assert.fail;

/**
 * @author youngzy
 * @since 2023-03-23
 */
public class TestHelper {
    public static <X extends Throwable> Throwable assertThrows(Class<X> exceptionClass,
                                                               Runnable block) {
        try {
            block.run();
        } catch (Throwable x) {
            if (exceptionClass.isInstance(x)) {
                return x;
            }
        }

        fail("Failed to throw expected exception");
        return null;
    }
}
