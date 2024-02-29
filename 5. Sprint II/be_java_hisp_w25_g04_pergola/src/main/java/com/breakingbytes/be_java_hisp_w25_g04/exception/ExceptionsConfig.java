package com.breakingbytes.be_java_hisp_w25_g04.exception;

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsConfig {
  
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> notFound(NotFoundException e) {
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> badRequest(BadRequestException e) {
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
