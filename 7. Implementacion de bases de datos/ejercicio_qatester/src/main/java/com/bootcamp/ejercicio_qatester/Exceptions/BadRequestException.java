package com.bootcamp.ejercicio_qatester.Exceptions;

public class BadRequestException extends RuntimeException{
    BadRequestException(String message){
        super(message);
    }
}
