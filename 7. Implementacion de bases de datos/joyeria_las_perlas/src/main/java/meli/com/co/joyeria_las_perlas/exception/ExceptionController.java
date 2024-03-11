package meli.com.co.joyeria_las_perlas.exception;

import meli.com.co.joyeria_las_perlas.dto.response.MessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<MessageDto> notFoundExceptionHandler(NotFoundException exception){
        return ResponseEntity.badRequest().body(new MessageDto(exception.getMessage()));
    }

}
