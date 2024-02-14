package com.bootcamp.ejercicio_blog.exception;

import com.bootcamp.ejercicio_blog.dto.response.ExceptionResponseDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<?> notfound(NotFoundException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponseDTO(e.getMessage()));
        }

        @ExceptionHandler(BadRequestException.class)
        public ResponseEntity<?> badRequest(BadRequestException e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDTO(e.getMessage()));

        }

        @ExceptionHandler(NoContentException.class)
        public ResponseEntity<?> noContent(NoContentException e){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ExceptionResponseDTO(e.getMessage()));
        }
}
