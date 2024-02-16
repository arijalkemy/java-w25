package com.ejemplo.linkTracker.exception;

import com.ejemplo.linkTracker.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class ExceptionConfig {

    @ExceptionHandler(ObjectDuplicateException.class)
    public ResponseEntity<ExceptionResponseDTO> objectDuplicateException(ObjectDuplicateException e){

        return new ResponseEntity<>(new ExceptionResponseDTO(e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> notFoundException(NotFoundException e){

        return new ResponseEntity<>(new ExceptionResponseDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponseDTO> badRequestException(BadRequestException e){

        return new ResponseEntity<>(new ExceptionResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
