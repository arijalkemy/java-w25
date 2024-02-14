package com.meli.manejoexcepciones.exception;

public class BlogAlreadyExistsException extends RuntimeException{

    public BlogAlreadyExistsException(String message){
        super(message);
    }

}

