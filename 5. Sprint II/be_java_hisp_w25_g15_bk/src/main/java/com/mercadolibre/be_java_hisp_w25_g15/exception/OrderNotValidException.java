package com.mercadolibre.be_java_hisp_w25_g15.exception;

public class OrderNotValidException extends RuntimeException{
    public OrderNotValidException(String message){
        super(message);
    }
}
