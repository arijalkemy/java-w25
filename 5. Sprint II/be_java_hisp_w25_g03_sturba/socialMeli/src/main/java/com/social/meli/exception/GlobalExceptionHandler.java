package com.social.meli.exception;

import com.social.meli.dto.response.MessageDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDto> NotFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDto(e.getMessage()));
    }
    @ExceptionHandler(UserIsNotVendorException.class)
    public ResponseEntity<MessageDto> userIsNotVendorException(UserIsNotVendorException e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new MessageDto(e.getMessage()));
    }
    @ExceptionHandler(UserFollowException.class)
    public ResponseEntity<MessageDto> userFollowException(UserFollowException e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new MessageDto(e.getMessage()));
    }
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<MessageDto> invalidDataException(InvalidDataException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageDto(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
         Map<String, String> errors = new HashMap<>();
         ex.getBindingResult().getAllErrors().forEach( error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); //modificar segun exepcion
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach( violation -> {
            String fieldName = getFieldName(violation.getPropertyPath().toString());
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); //modificar segun exepcion
    }

    private String getFieldName(String propertyPath) {
        int lastDotIndex = propertyPath.lastIndexOf('.');
        return lastDotIndex > 0 ? propertyPath.substring(lastDotIndex + 1) : propertyPath;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<MessageDto> handleValidationExceptions(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(new MessageDto(ex.getMessage()));
    }

}
