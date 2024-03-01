package com.breakingbytes.be_java_hisp_w25_g04.exception;

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ExceptionDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ExceptionValidatorsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ExceptionsConfig {
  
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> notFound(NotFoundException e) {
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> badRequest(BadRequestException e) {
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){

        // e.getFieldError().getDefaultMessage() --> Con esto se ve el mensaje de error de la validacion,
        // pero.. ¿como vemos si hay varias validaciones?
        List<ExceptionValidatorsDTO> validatorsDTO = new ArrayList<>();
        e.getFieldErrors().forEach(fieldError -> validatorsDTO.add(new ExceptionValidatorsDTO(fieldError.getField(), fieldError.getDefaultMessage())));
        ExceptionDTO exceptionDto = new ExceptionDTO("Hay campos invalidos" ,validatorsDTO);
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> notValid(MissingServletRequestParameterException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto,HttpStatus.BAD_REQUEST);
    }
}
