package ejer.linktracker.exception;

import ejer.linktracker.DTO.response.GenericExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice (annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<?> ResourceAlreadyExistsException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(LinkNotAvailableException.class)
    public ResponseEntity<?> LinkNotAvailableException(Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GenericExceptionDTO(e.getMessage()));
    }
}
