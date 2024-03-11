package com.example.configurando_jpa.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.configurando_jpa.dto.res.MessageDto;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {
        MessageDto messageException = new MessageDto(e.getMessage());
        return ResponseEntity.status(404).body(messageException.getMessage());
    }
}
