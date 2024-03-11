package meli.com.co.qatesters.exception;

import meli.com.co.qatesters.dto.response.MessageDto;
import meli.com.co.qatesters.dto.response.MessageWithFieldDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MessageWithFieldDto>> notValid(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                e.getAllErrors().stream()
                        .map(error -> new MessageWithFieldDto(((FieldError) error).getField(),
                                error.getDefaultMessage())).toList(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDto> notFound(NotFoundException notFound) {
        return new ResponseEntity<>(new MessageDto(notFound.getMessage()), HttpStatus.NOT_FOUND);
    }
}
