package com.example.youtuber.exception;

import com.example.youtuber.dto.GenericResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GenericResponseDTO> NotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new GenericResponseDTO(HttpStatus.NOT_FOUND.value() ,e.getMessage()));
    }

    @ExceptionHandler(NotCreatedException.class)
    public ResponseEntity<GenericResponseDTO> FoundException(Exception e){
        return ResponseEntity.status(HttpStatus.FOUND).body( new GenericResponseDTO(HttpStatus.FOUND.value() ,e.getMessage()));
    }
}
