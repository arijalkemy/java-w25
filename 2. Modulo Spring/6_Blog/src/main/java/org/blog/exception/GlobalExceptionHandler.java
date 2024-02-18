package org.blog.exception;

import org.blog.utils.ExceptionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(RuntimeException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionMapper.newExceptionResponseDTO(e.getMessage()));
    }


    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> AlreadyExistException(RuntimeException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ExceptionMapper.newExceptionResponseDTO(e.getMessage()));
    }
}
