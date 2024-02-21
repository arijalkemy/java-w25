package com.sfritz.linktracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sfritz.linktracker.dtos.ExceptionDto;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<ExceptionDto> invalidUrlException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(e.getMessage()));
    }
}
