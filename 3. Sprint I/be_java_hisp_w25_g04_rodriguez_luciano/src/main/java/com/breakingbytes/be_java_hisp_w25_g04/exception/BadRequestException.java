package com.breakingbytes.be_java_hisp_w25_g04.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
