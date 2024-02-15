package link_tracker.exception;

import link_tracker.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> linkNotFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(
            "Recurso no encontrado",
            e.getMessage())
        );
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ErrorDTO> handleInvalidLinkException(InvalidLinkException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDTO("Link Invalido", e.getMessage()));
    }
}
