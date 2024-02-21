package com.bootcamp.be_java_hisp_w25_g14.exceptions;

public class BadRequestBodyException extends RuntimeException{

    public BadRequestBodyException(String message) {
        super(message);
    }
}
