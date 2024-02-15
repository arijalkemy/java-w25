package com.example.linktracker.exception;

public class InvalidLinkException extends RuntimeException {
    public InvalidLinkException(String msg) {
        super(msg);
    }
}
