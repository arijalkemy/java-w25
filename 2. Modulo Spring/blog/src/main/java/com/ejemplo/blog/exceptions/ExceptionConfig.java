package com.ejemplo.blog.exceptions;

import com.ejemplo.blog.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(ObjectDuplicateException.class)
    public ResponseEntity<ExceptionDTO> objectDuplicateException(ObjectDuplicateException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(),
                "Ya existe un elemento con el ID suminstrado",
                HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.CONFLICT);
    }
}
