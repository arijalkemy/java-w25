package com.nq.testcases.exception.config;

import com.nq.testcases.dto.ExceptionDTO;
import com.nq.testcases.exception.BadRequestException;
import com.nq.testcases.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("ID Nº'" + e.getMessage() + "' not found.");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e) {
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}

