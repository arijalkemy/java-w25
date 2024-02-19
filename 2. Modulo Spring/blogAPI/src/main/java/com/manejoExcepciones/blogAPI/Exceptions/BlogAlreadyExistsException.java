package com.manejoExcepciones.blogAPI.Exceptions;

public class BlogAlreadyExistsException extends RuntimeException{
    public BlogAlreadyExistsException(String message) {
        super(message);
    }
}
