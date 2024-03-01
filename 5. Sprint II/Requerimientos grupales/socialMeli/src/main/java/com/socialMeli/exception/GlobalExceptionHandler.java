package com.socialMeli.exception;

import com.socialMeli.dto.response.MessageDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(NotFoundException e){
        MessageDto messageDTO = new MessageDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDTO);
    }
    @ExceptionHandler(UserIsNotVendorException.class)
    public ResponseEntity<?> userIsNotVendorException(UserIsNotVendorException e){
        MessageDto messageDTO = new MessageDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(messageDTO);
    }
    @ExceptionHandler(UserFollowException.class)
    public ResponseEntity<?> userFollowException(UserFollowException e){
        MessageDto messageDTO = new MessageDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(messageDTO);
    }
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<?> invalidDataException(InvalidDataException e){
        MessageDto messageDTO = new MessageDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageDTO);
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> invalidDataException(MethodArgumentTypeMismatchException e){
        MessageDto messageDTO = new MessageDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageDTO);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    protected ResponseEntity<?> handleValidationException(HandlerMethodValidationException ex) {
        MessageDto messageDto = new MessageDto(ex.getDetailMessageArguments());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
         Map<String, String> errors = new HashMap<>();
         ex.getBindingResult().getAllErrors().forEach( (error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); //modificar segun exepcion
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach( (violation) -> {
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
    protected ResponseEntity<?> handleValidationExceptions(HttpMessageNotReadableException ex) {
        //ClaseExcepcion excepcion = new ClaseExpcepcion("Mensaje: ", ex.getMessage());
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST); //modificar segun excepcion
    }
}
