package joyeria.joyas.exception;

import joyeria.joyas.DTO.Response.GenericResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException notFoundException){
        return new ResponseEntity<>(new GenericResponseDto(notFoundException.getMessage()), HttpStatus.NOT_FOUND );
    }
}
