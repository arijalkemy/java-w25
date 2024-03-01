package com.bootcamp.be_java_hisp_w25_g14.exceptions;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String message) {
        super(message);
    }
}
