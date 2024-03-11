package com.implementacionbasedatos.ejercicio1.exception;

public class LocalDateInvalidException extends RuntimeException {

    public LocalDateInvalidException() {
        super("El formato de fecha es inválido. El formato correcto es yyyy-MM-dd.");
    }
}
