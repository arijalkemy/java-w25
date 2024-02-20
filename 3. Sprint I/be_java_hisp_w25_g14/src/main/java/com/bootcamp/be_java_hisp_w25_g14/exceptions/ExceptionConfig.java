package com.bootcamp.be_java_hisp_w25_g14.exceptions;

import com.bootcamp.be_java_hisp_w25_g14.dto.MessageDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> noFound(NotFoundException ex){
        return ResponseEntity.status(400).body(new MessageDto(ex.getMessage(), ""));
    }
    @ExceptionHandler(FollowException.class)
    public ResponseEntity<?> follow(FollowException ex){
        return ResponseEntity.status(400).body(new MessageDto(ex.getMessage(), ""));
    }

    @ExceptionHandler(NotSellerException.class)
    public ResponseEntity<?> notASeller(NotSellerException ex){
        return ResponseEntity.status(400).body(new MessageDto(ex.getMessage(), ""));
    }

    @ExceptionHandler(NotValidDateException.class)
    public ResponseEntity<?> notValidDate(NotValidDateException ex){
        return ResponseEntity.status(400).body(new MessageDto(ex.getMessage(), ""));
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> mismatchType(MethodArgumentTypeMismatchException ex){
        return ResponseEntity.status(400).body(new MessageDto("Error during parsing type value", ex.getMessage()));
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<?> noResourceFound(NoHandlerFoundException ex,  HttpServletRequest httpServletRequest){
        return ResponseEntity.status(404).body(new MessageDto("Endpoint No Found", ex.getMessage()));
    }
}
