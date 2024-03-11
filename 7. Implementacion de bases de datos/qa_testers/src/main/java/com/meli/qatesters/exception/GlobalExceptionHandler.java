package com.meli.qatesters.exception;

import com.meli.qatesters.dto.ResponseMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e) {
        ResponseMessageDto exceptionDto = new ResponseMessageDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto,  HttpStatus.NOT_FOUND);
    }
}
