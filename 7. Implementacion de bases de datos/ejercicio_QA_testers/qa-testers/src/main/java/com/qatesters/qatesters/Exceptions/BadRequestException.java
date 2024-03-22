package com.qatesters.qatesters.Exceptions;

public class BadRequestException extends RuntimeException{
    BadRequestException(String message){
        super(message);
    }
}
