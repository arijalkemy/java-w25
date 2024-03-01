package com.grupo08.socialmeli.exception;

import com.grupo08.socialmeli.dto.ExceptionDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public  ResponseEntity<?> badRequest(BadRequestException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> accessDenied(AccessDeniedException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<?> alreadyExist(AlreadyExistException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> handleValidationExceptions(MethodArgumentNotValidException e) {
        ExceptionDto error = new ExceptionDto("MethodArgumentNotValidException "+ e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDto> handleValidationExceptions(HttpMessageNotReadableException e) {
        ExceptionDto error = new ExceptionDto("HttpMessageNotReadableException "+ e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDto> handleValidationExceptions(ConstraintViolationException e) {
        ExceptionDto error = new ExceptionDto("ConstraintViolationException "+ e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
