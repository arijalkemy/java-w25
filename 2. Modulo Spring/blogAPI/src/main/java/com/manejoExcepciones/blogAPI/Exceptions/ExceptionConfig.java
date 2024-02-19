package com.manejoExcepciones.blogAPI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    //TODO: corregir el body para que retorne un json y no un texto plano
    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<?> notFoundException(BlogNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(BlogAlreadyExistsException.class)
    public ResponseEntity<?> alreadyExistsException(BlogAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
