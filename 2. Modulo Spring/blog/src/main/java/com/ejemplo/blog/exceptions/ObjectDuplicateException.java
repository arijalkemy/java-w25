package com.ejemplo.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ObjectDuplicateException extends RuntimeException{

    public ObjectDuplicateException(String message){
        super(message);
    }
}
