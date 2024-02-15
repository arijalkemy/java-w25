package com.bootcamp.exception;

public class DuplicatedEntryException extends RuntimeException{
    public DuplicatedEntryException(String message) {
        super(message);
    }
}
