package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.GenericResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponseDTO> methodArgumentNotValid(MethodArgumentNotValidException e) {
        String message = e.getMessage();
        if (e.getFieldError() != null) message = e.getFieldError().getDefaultMessage();
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.BAD_REQUEST.value(), message);
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

}
