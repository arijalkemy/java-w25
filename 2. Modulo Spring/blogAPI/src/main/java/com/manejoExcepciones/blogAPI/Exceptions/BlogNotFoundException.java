package com.manejoExcepciones.blogAPI.Exceptions;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String message) {
        super(message);
    }
}
