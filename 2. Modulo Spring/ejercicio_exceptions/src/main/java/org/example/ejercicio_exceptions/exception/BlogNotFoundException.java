package org.example.ejercicio_exceptions.exception;

public class BlogNotFoundException extends RuntimeException{

    public BlogNotFoundException(String message) {
        super(message);
    }
}
