package com.example.be_java_hisp_w25_g11_grisales.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
