package com.joyeriaLaPerla.joyeriaLaPerla.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}