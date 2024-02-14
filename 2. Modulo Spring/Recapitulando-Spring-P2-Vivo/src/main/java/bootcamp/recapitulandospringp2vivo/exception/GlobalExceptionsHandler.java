package bootcamp.recapitulandospringp2vivo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(value = LinkNotFoundException.class)
    public ResponseEntity<?> LinkNotFoundException(LinkNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(value = IncorrectPasswordException.class)
    public ResponseEntity<?> IncorrectPasswordException(IncorrectPasswordException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
