package com.youngzy.book.fpij.ch10;

/**
 * @author youngzy
 * @since 2024-01-10
 */
// sealed JDK17 才有的关键字
public sealed interface DataOrException<T> {
    public default boolean isDataPresent() { return true; }

    public default T getDataOrThrow() {
        throw new RuntimeException("No data");
    }

    public default Exception getExceptionOrThrow() {
        throw new RuntimeException("No Exception");
    }

    public static <T> DataOrException<T> of(T data) {
        return new Data<T>(data);
    }

    public static <T> DataOrException<T> of(Exception exception) {
        return new TheException<T>(exception);
    }
}

record Data<T>(T data) implements DataOrException<T> {
    public T getDataOrThrow() { return data; }
}

record TheException<T>(Exception exception) implements DataOrException<T> {
    public boolean isDataPresent() { return false; }

    public Exception getExceptionOrThrow() { return exception; }
}
