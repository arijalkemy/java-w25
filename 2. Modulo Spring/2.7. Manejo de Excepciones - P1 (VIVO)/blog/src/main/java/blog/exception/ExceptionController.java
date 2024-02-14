package blog.exception;

import blog.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = AlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> alreadyExistsException(AlreadyExistsException e) {
        return new ResponseEntity<>(
            new ErrorDTO(
                    "Ya existe el recurso a crear",
                    e.getMessage()
            ),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundException(NotFoundException e) {
        return new ResponseEntity<>(
            new ErrorDTO(
                    "No se encontró el recurso solicitado",
                    e.getMessage()
            ),
            HttpStatus.NOT_FOUND
        );
    }
}
