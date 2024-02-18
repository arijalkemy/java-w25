package com.bootcamp.linkTracker.exception;

import com.bootcamp.linkTracker.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler(NotFoundLinkException.class)
    public ResponseEntity<?> notFoundLinkException(NotFoundLinkException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(NotFoundLinkException.class)
    public ResponseEntity<?> invalidateLinkException(InvalidateLinkException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                body(new ExceptionDTO(e.getMessage()));
    }

}
