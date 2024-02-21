package ejercicio.blog.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(IngresoEntradaExistenteException.class)
    public ResponseEntity<?> ingresoEntradaExistenteException(Exception e) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(e.getMessage());
    }

    @ExceptionHandler(EntradaNotFoundException.class)
    public ResponseEntity<?> entradaNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
