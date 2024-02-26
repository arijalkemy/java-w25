package linkTracker.exception;

import linkTracker.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ErrorDTO> invalidLinkException(InvalidLinkException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(AlreadyInvalidatedLinkException.class)
    public ResponseEntity<?> alreadyInvalidatedLinkException(AlreadyInvalidatedLinkException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(e.getMessage()));
    }


    @ExceptionHandler(InvalidPasswordException.class)
    public  ResponseEntity<?> invalidPasswordException(InvalidPasswordException e){
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorDTO(e.getMessage()));
    }
}

