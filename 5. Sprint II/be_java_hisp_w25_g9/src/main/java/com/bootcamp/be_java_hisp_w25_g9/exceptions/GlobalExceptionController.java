package com.bootcamp.be_java_hisp_w25_g9.exceptions;

import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageWithFieldDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionController {

    @ExceptionHandler
    public ResponseEntity<MessageDto> noUsersFoundExceptionHandler(NoUsersFoundException e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageDto> badRequest(BadRequestException e){
        MessageDto messageDto = new MessageDto(e.getMessage());
        return new ResponseEntity<>(messageDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDto> notFound (NotFoundException e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MessageWithFieldDto>> notValid (MethodArgumentNotValidException e){
        return new ResponseEntity<>(
                e.getAllErrors().stream()
                        .map(error -> new MessageWithFieldDto(((FieldError) error).getField(),
                                error.getDefaultMessage())).toList(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageDto> notReadableHttp (HttpMessageNotReadableException e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
