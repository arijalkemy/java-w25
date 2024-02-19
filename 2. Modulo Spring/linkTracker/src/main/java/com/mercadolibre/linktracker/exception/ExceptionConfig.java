package com.mercadolibre.linktracker.exception;

import com.mercadolibre.linktracker.dto.InfoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<InfoDto> nofoundException( NoFoundException ex){
        return new ResponseEntity<>(new InfoDto(ex.getMessage(),"elemenet not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoActiveException.class)
    public ResponseEntity<InfoDto> noActiveException( NoActiveException ex){
        return new ResponseEntity<>(new InfoDto(ex.getMessage(),"elemenet not found"), HttpStatus.GONE);
    }

    @ExceptionHandler(NoAccessException.class)
    public ResponseEntity<InfoDto> noAccessException( NoAccessException ex){
        return new ResponseEntity<>(new InfoDto(ex.getMessage(),"elemenet not found"), HttpStatus.UNAUTHORIZED);
    }
}
