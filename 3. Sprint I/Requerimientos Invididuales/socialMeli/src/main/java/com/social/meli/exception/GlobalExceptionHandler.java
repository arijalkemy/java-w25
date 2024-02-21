package com.social.meli.exception;

import com.social.meli.dto.response.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDTO> notFoundException(NotFoundException e){
        MessageDTO exceptionDto = new MessageDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
    }
    @ExceptionHandler(UserIsNotVendorException.class)
    public ResponseEntity<MessageDTO> userIsNotVendorException(UserIsNotVendorException e){
        MessageDTO exceptionDto = new MessageDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionDto);
    }
    @ExceptionHandler(UserFollowException.class)
    public ResponseEntity<MessageDTO> userFollowException(UserFollowException e){
        MessageDTO exceptionDto = new MessageDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionDto);
    }
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<MessageDTO> invalidDataException(InvalidDataException e){
        MessageDTO exceptionDto = new MessageDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

}
