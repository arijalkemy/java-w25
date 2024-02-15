package com.bootcamp.exception;

import com.bootcamp.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionsConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundException(NotFoundException e){
        return  new ResponseEntity<ExceptionDto>(new ExceptionDto("No se ha encontrado el blog"), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(DuplicatedEntryException.class)
    public ResponseEntity<ExceptionDto> duplicatedEntryException(DuplicatedEntryException e){
        return  new ResponseEntity<ExceptionDto>(new ExceptionDto("La entrada de blog ya ha sido creada"), HttpStatus.NOT_FOUND);

    }
}
