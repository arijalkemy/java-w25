package com.example.be_java_hisp_w25_g11_grisales.exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message){
        super(message);
    }
}
