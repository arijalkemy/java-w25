package bootcamp.crudjpajewerly.exception;

import bootcamp.crudjpajewerly.dto.response.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(JewerlyNotFoundException.class)
    public ResponseEntity<GeneralResponse> jewerlyNotFound(JewerlyNotFoundException e) {
        GeneralResponse response = new GeneralResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
