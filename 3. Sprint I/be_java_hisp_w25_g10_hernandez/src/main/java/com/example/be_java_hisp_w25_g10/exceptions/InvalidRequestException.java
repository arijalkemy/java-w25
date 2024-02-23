package com.example.be_java_hisp_w25_g10.exceptions;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String message) {
        super(message);
    }

}
