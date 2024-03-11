package com.bootcamp.ejercicio_qatester.Exceptions;

import com.bootcamp.ejercicio_qatester.dto.response.GenericResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException notFoundException){
        return new ResponseEntity<>(new GenericResponseDTO(notFoundException.getMessage()), HttpStatus.NOT_FOUND );
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException badRequestxception){
        return new ResponseEntity<>(new GenericResponseDTO(badRequestxception.getMessage()), HttpStatus.BAD_REQUEST );
    }
}
