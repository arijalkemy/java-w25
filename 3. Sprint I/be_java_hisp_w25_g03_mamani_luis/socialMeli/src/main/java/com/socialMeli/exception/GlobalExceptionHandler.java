package com.socialMeli.exception;

import com.socialMeli.dto.response.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

}
