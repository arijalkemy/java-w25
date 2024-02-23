package com.bootcamp.ejercicio_concesionaria.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
