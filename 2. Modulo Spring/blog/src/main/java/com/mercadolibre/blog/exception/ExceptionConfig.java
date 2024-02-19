package com.mercadolibre.blog.exception;

import com.mercadolibre.blog.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<ExceptionDto> noFoundException(NoFoundException noFoundException){
        return new ResponseEntity<>(new ExceptionDto(noFoundException.getMessage(), "runtime error"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ExceptionDto> duplicatexception(DuplicateException noFoundException){
        return new ResponseEntity<>(new ExceptionDto(noFoundException.getMessage(), "runtime error"), HttpStatus.CONFLICT);
    }
}
