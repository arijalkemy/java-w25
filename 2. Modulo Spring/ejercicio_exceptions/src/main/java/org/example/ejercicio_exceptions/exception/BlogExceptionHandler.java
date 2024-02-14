package org.example.ejercicio_exceptions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionMessageDTO> repeatedIdException(UniqueIdConstraintException uniqueIdConstraintException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionMessageDTO(uniqueIdConstraintException.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessageDTO> blogNotFoundException(BlogNotFoundException blogNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionMessageDTO(blogNotFoundException.getMessage()));
    }
}
