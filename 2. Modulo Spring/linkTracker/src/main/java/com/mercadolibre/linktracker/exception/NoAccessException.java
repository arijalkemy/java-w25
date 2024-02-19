package com.mercadolibre.linktracker.exception;

public class NoAccessException extends RuntimeException {
    public NoAccessException() {
    }

    public NoAccessException(String message) {
        super(message);
    }
}
