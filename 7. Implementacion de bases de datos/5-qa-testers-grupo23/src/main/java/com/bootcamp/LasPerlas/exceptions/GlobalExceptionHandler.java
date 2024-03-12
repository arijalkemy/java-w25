package com.bootcamp.LasPerlas.exceptions;

import com.bootcamp.LasPerlas.dto.MessageExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> testNotFoundException(TestNotFoundException e){
        MessageExceptionDto messageDto = new MessageExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDto);
    }
}
