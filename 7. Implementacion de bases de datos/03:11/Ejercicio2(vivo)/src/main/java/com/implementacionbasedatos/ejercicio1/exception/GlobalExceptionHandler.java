package com.implementacionbasedatos.ejercicio1.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.implementacionbasedatos.ejercicio1.dto.res.MessageResDTO;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {
        MessageResDTO messageException = new MessageResDTO(e.getMessage());
        return new ResponseEntity<>(messageException, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(LocalDateInvalidException.class)
    public ResponseEntity<?> LocalDateInvalid(Exception e) {
        MessageResDTO messageException = new MessageResDTO(e.getMessage());
        return new ResponseEntity<>(messageException, HttpStatusCode.valueOf(400));
    }
}
