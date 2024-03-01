package com.mercadolibre.be_java_hisp_w25_g15.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
