package com.bootcamp.QATesters.exception;

import com.bootcamp.QATesters.dto.ErrorDTO;
import jakarta.persistence.NoResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFound(NotFoundException e){
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<ErrorDTO> noResult(NoResultException e){
        return new ResponseEntity<>( new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> illegalArgument(IllegalArgumentException e){
        return new ResponseEntity<>( new ErrorDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
