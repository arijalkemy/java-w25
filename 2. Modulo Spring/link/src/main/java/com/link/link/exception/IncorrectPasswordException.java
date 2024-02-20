package com.link.link.exception;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException (String message) {
        super(message);
    }
}
