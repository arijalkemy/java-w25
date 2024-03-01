package com.mercadolibre.be_java_hisp_w25_g15.exception;

public class ConflictException extends RuntimeException{
    public ConflictException(String message){
        super(message);
    }
}
