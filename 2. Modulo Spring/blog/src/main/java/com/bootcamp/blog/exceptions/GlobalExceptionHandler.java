package com.bootcamp.blog.exceptions;

import com.bootcamp.blog.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> AlreadyBlogExistException(AlreadyBlogExistException e){

        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(new ExceptionDTO(e.getMessage())); //Already_reported?
    }

    @ExceptionHandler
    public ResponseEntity<?> NotFoundBlogException(NotFoundBlogException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(e.getMessage()));
    }
}
