package com.youngzy.book.fpij.ch10;

/**
 * @author youngzy
 * @since 2024-01-10
 */
public class AirportInfoException extends Exception {
    public AirportInfoException(String message) {
        super(message);
    }

    public AirportInfoException(Throwable cause) {
        super(cause);
    }

    public AirportInfoException(String message, Throwable cause) {
        super(message, cause);
    }
}