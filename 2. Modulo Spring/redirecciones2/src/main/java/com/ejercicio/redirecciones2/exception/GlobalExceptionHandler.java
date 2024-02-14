package com.ejercicio.redirecciones2.exception;

import com.ejercicio.redirecciones2.dto.ResponseMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyInvalidException.class)
    public ResponseEntity<ResponseMessageDTO> invalidLinkException(AlreadyInvalidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessageDTO(e.getMessage()));
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ResponseMessageDTO> invalidLinkException(AlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseMessageDTO(e.getMessage()));
    }
}
