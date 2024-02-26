package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDTO> handleValidationExceptions(HttpMessageNotReadableException ex) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }
}
