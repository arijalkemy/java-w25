package com.linktracker.linktracker.exception;

import com.linktracker.linktracker.dto.response.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ExceptionDto> invalidLinkException(InvalidLinkException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionDto(e.getMessage(), 404));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionDto(e.getMessage(), 404));
    }
}
