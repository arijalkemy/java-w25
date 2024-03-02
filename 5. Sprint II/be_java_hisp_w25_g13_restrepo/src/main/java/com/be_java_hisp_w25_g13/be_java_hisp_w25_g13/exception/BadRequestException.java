package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
