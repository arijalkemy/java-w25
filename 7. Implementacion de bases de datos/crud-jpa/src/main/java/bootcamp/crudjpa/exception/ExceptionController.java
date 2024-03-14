package bootcamp.crudjpa.exception;

import bootcamp.crudjpa.dto.response.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<GeneralResponse> studentNotFound(StudentNotFoundException e) {
        GeneralResponse response = new GeneralResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentAlreadyExistsException.class)
    public ResponseEntity<GeneralResponse> studentAlreadyExists(StudentAlreadyExistsException e) {
        GeneralResponse response = new GeneralResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
