package com.be_java_hisp_w25_g02_zanaboni.exception;
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
