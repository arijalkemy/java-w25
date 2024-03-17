package com.meli.showroom.exception;

import com.meli.showroom.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notfound(NotFoundException e){
        ResponseDTO exceptionDTO = new ResponseDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
