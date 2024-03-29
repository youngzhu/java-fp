package com.youngzy.book.fpij.ch08;

import java.util.stream.Stream;

/**
 * @author youngzy
 * @since 2023-03-24
 */
@FunctionalInterface
public interface TailCall<T> {
    TailCall<T> apply();

    default boolean isComplete() { return false; }

    default T result() {
        throw new Error("not implemented");
    }

    default T invoke() {
        return Stream.iterate(this, TailCall::apply)
                .filter(TailCall::isComplete)
                .findFirst()
                .get()
                .result();
    }
}
