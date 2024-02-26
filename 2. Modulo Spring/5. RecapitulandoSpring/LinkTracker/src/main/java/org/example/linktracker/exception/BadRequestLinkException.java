package org.example.linktracker.exception;

public class BadRequestLinkException extends RuntimeException{
    public BadRequestLinkException(String message) {
        super(message);
    }
}
