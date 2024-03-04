package error.bootcamp.errorHandler.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler(BlogAlreadyExistsException.class)
    public ResponseEntity<?> blogAlreadyExistsException(BlogAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<?> blogNotFoundException(BlogNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
