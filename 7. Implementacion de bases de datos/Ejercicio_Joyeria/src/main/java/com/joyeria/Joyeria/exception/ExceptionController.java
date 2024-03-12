package com.joyeria.Joyeria.exception;

import com.joyeria.Joyeria.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDto> notFound(NotFoundException notFound) {
        return new ResponseEntity<>(new MessageDto(notFound.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
