package com.relations.relations.Excepciones;

import com.relations.relations.dto.response.GenericReponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException notFoundException){
        return new ResponseEntity<>(new GenericReponseDTO(notFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
