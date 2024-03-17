package com.javaw25.qatester.exception;

import com.javaw25.qatester.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> getNotFoundException(NotFoundException e){
        return new ResponseEntity<>(new MessageDto((e.getMessage())), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> getBadRequestException(BadRequestException e){
        return new ResponseEntity<>(new MessageDto((e.getMessage())), HttpStatus.NOT_FOUND);
    }
}
