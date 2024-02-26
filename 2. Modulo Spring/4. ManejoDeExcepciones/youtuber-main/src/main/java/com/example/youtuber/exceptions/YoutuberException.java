package com.example.youtuber.exceptions;

import com.example.youtuber.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class YoutuberException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> notFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(e.getMessage()));
    }

    @ExceptionHandler(AlreadyPresentException.class)
    public ResponseEntity<ErrorDto> alreadyPresentException(AlreadyPresentException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ErrorDto(e.getMessage()));
    }
}
