package com.bootcamp.be_java_hisp_w25_g02.exception;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
