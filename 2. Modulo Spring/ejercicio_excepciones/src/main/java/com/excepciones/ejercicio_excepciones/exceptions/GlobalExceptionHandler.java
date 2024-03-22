package com.excepciones.ejercicio_excepciones.exceptions;

import com.excepciones.ejercicio_excepciones.entity.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Especificamos sobre cual clase se va a ejecutar
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    // Especificamos el tipo de excepcion
    // Controlando error en caso de que no exista un archivo o elemento
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> NotFoundException(Exception e){
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    // Controlando error en caso de acer una peticion incorrecta
    public ResponseEntity<ErrorResponseDTO> BadRequestException(Exception e){
        ErrorResponseDTO errorResponseDTO=new ErrorResponseDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
    }
}
