package com.youngzy.book.fpij.ch06;

/**
 * @author youngzy
 * @since 2023-03-23
 */
@FunctionalInterface
public interface UseInstance<T, X extends Throwable> {
    void accept(T instance) throws X;
}
