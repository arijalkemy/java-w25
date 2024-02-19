package com.mercadolibre.linktracker.exception;

public class NoFoundException extends RuntimeException {
    public NoFoundException() {
    }

    public NoFoundException(String message) {
        super(message);
    }
}
