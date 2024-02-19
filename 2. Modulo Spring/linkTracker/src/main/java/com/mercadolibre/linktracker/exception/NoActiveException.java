package com.mercadolibre.linktracker.exception;

public class NoActiveException extends RuntimeException {
    public NoActiveException() {
    }

    public NoActiveException(String message) {
        super(message);
    }
}
