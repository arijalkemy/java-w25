package com.ejemplo.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Elemento no encontrado con ese ID")
public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
