package com.bootcamp.be_java_hisp_w25_g9.exceptions;

import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> notFound (NotFoundException e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
