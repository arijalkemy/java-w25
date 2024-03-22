package bootcamp.empresaseguros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(VehiculoNotFoundException.class)
    public ResponseEntity<GeneralResponse> vehiculoNotFound(VehiculoNotFoundException e) {
        GeneralResponse response = new GeneralResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
