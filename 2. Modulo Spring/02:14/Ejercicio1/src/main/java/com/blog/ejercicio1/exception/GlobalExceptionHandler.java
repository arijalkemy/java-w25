package com.blog.ejercicio1.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.blog.ejercicio1.dto.ExceptionDTO;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {
        ExceptionDTO messageException = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(404).body(messageException.getMessage());
    }
}
