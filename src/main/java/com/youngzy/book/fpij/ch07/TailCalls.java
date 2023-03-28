package com.youngzy.book.fpij.ch07;

/**
 * @author youngzy
 * @since 2023-03-24
 */
public class TailCalls {
    public static <T> TailCall<T> call(TailCall<T> nextCall) {
        return nextCall;
    }

    public static <T> TailCall<T> done(T value) {
        return new TailCall<T>() {
            @Override
            public boolean isComplete() {
                return true;
            }

            @Override
            public T result() {
                return value;
            }

            @Override
            public TailCall<T> apply() {
                throw new Error("not implemented");
            }
        };
    }
}
