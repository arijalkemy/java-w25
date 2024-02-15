package com.example.linktracker.exception;

import com.example.linktracker.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ConfigExceptions {


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseDTO(e.getMessage()));
    }


    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<?> wrongPasswordException(WrongPasswordException e){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ResponseDTO(e.getMessage()));
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<?> invalidLinkException(InvalidLinkException e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new ResponseDTO(e.getMessage()));
    }
}
