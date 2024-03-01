package com.bootcamp.be_java_hisp_w25_g02.exception;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.GenericResponseDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashSet;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e){
        return new ResponseEntity<>(new GenericResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        return new ResponseEntity<>(new GenericResponseDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValid(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new GenericResponseDTO(e.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> methodArgumentNotValid(HttpMessageNotReadableException e){
        return new ResponseEntity<>(new GenericResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constrintViolation( ConstraintViolationException e){
        Set<GenericResponseDTO> genericResponseDTOS = new HashSet<>();
        for (ConstraintViolation constraintViolation: e.getConstraintViolations()){
            genericResponseDTOS.add(new GenericResponseDTO(constraintViolation.getMessage()));
        }
        return new ResponseEntity<>(genericResponseDTOS, HttpStatus.BAD_REQUEST);
    }
}
