package com.example.bootcampsprint1g6.exception;

import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GenericResponseDTO> notFound(NotFoundException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GenericResponseDTO> badRequest(BadRequestException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<GenericResponseDTO> conflict(ConflictException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.CONFLICT.value(), e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<GenericResponseDTO> methodArgumentTypeMismatch(MethodArgumentTypeMismatchException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<GenericResponseDTO> illegalArgument(IllegalArgumentException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<GenericResponseDTO> illegalArgument(HttpMessageNotReadableException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

}
