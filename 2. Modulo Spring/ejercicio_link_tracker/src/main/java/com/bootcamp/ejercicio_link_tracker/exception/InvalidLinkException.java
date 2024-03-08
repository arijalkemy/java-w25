package com.bootcamp.ejercicio_link_tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidLinkException extends RuntimeException {
    public InvalidLinkException(String message) {
        super(message);
    }
}