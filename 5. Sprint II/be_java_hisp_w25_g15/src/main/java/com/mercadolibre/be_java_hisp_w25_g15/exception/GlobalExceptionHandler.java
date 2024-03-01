package com.mercadolibre.be_java_hisp_w25_g15.exception;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.MessageResponseDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageResponseDto> notFoundException(NotFoundException e){
        return new ResponseEntity<>(new MessageResponseDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    //Excepciones de validaciones

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleHandlerMethodValidationException(HandlerMethodValidationException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> errors = new HashMap<>();
        ex.getAllValidationResults().forEach(validationResult -> {
            // Suponiendo que cada validationResult tiene al menos un ResolvableError
            validationResult.getResolvableErrors().forEach(resolvableError -> {
                // Aquí asumimos que necesitas algún identificador único para el error; ajusta según sea necesario
                String errorKey = ((DefaultMessageSourceResolvable) Arrays.stream(Objects.requireNonNull(resolvableError.getArguments())).toList().get(0)).getDefaultMessage();
                String errorMessage = resolvableError.getDefaultMessage();
                errors.put(errorKey, errorMessage);
            });
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.badRequest().body(new MessageResponseDto(ex.getMessage()));
    }

    //Excepciones de formato de datos, actualmente se lanza cuando se envia una fecha invalida
    @ExceptionHandler(MismatchedInputException.class)
    public ResponseEntity<Object> handleMismatchedInputException(MismatchedInputException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(new MessageResponseDto(errorMessage), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<MessageResponseDto> handleMethodConflictException(ConflictException conflictException){
        return new ResponseEntity<>(new MessageResponseDto(conflictException.getMessage()),HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<MessageResponseDto> handleConversionFailedException(ConversionFailedException e) {
        String errorMessage = e.getValue()+ " is not a valid value";
        return new ResponseEntity<>(new MessageResponseDto(errorMessage), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotValidException.class)
    public ResponseEntity<MessageResponseDto> orderNotValidException(Exception e){
        return new ResponseEntity<>(new MessageResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
