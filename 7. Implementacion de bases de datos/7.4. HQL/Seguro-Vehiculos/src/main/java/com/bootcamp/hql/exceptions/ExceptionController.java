package com.bootcamp.hql.exceptions;

import com.bootcamp.hql.model.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDto> handleNotFoundException(NotFoundException e) {
        MessageDto message = new MessageDto(e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
