package com.sfritz.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sfritz.blog.dtos.ExceptionDto;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(e.getMessage()));
    }

    @ExceptionHandler(AlreadyPresentException.class)
    public ResponseEntity<ExceptionDto> alreadyPresentException(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionDto(e.getMessage()));
    }
}
