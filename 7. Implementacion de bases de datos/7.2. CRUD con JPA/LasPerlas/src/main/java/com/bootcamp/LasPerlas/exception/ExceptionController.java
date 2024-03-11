package com.bootcamp.LasPerlas.exception;

import com.bootcamp.LasPerlas.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        MessageDTO exceptionDTO = new MessageDTO(ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageDTO> handleValidationExceptions(HttpMessageNotReadableException ex) {
        MessageDTO exceptionDTO = new MessageDTO(ex.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDTO> notFoundException (NotFoundException e) {
        MessageDTO exceptionMessage = new MessageDTO(e.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }


}
