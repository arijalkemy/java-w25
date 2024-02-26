package com.meli.obtenerdiploma.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerValidationException (MethodArgumentNotValidException ex) {
        // Investigar cuando fallá mas de un campo y como mostrarlo
        // Se genera una especie de lista: fieldErrores
        return new ResponseEntity<>(RuntimeException.class, HttpStatus.BAD_REQUEST);
    } // Cuando falla una validacion --> Osea cuando no cumple con la validacion

    // Averiguar que hace cada una de estas
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handlerValidationException (HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(RuntimeException.class, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handlerValidationException (MissingServletRequestParameterException ex) {
        return new ResponseEntity<>(RuntimeException.class, HttpStatus.BAD_REQUEST);
    }
}
