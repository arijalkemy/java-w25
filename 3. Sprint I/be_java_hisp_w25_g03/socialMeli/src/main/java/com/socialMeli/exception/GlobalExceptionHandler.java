package com.socialMeli.exception;

import com.socialMeli.dto.response.ExceptionDto;
import com.socialMeli.dto.response.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(NotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
    }
    @ExceptionHandler(UserIsNotVendorException.class)
    public ResponseEntity<?> userIsNotVendorException(UserIsNotVendorException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionDto);
    }
    @ExceptionHandler(UserFollowException.class)
    public ResponseEntity<?> userFollowException(UserFollowException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionDto);
    }
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<?> invalidDataException(InvalidDataException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

}
