package com.bootcamp.be_java_hisp_w25_g14.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
