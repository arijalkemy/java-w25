package org.example.manejo_de_excepciones_p1_vivo.exception;

import org.example.manejo_de_excepciones_p1_vivo.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<?> notFound(NotFoundException e){
            ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
            return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(BadRequestException.class)
        public  ResponseEntity<?> badRequest(BadRequestException e){
            ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
            return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(AlreadyExistException.class)
        public ResponseEntity<?> alreadyExist(AlreadyExistException e){
            ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
            return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
        }
}
