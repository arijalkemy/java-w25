package com.example.bootcampsprint1g6.exception;

import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ExceptionController {

    /**
     * Manages cases where the resource was not found
     * @param e Exception catched
     * @return response entity to be returned
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GenericResponseDTO> notFound(NotFoundException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    /**
     * Manages cases where is something wrong in the request
     * @param e Exception catched
     * @return response entity to be returned
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GenericResponseDTO> badRequest(BadRequestException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * Manages cases where a parameter in the request is in a wrong type
     * @param e Exception catched
     * @return response entity to be returned
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<GenericResponseDTO> methodArgumentTypeMismatch(MethodArgumentTypeMismatchException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.BAD_REQUEST.value(), "Error en el tipo de datos de los parámetros");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * Manages cases where a parameter in the request is wrong
     * @param e Exception catched
     * @return response entity to be returned
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<GenericResponseDTO> illegalArgument(IllegalArgumentException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * Manages cases where some reference attempted to access is null
     * @param e Exception catched
     * @return response entity to be returned
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<GenericResponseDTO> nullPointerException(NullPointerException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.BAD_REQUEST.value(), "Atributos faltantes, por favor verifique la información enviada.");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * Manages cases where the request is not in a readable format
     * @param e Exception catched
     * @return response entity to be returned
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<GenericResponseDTO> illegalArgument(HttpMessageNotReadableException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.BAD_REQUEST.value(), "Error en el tipo de datos enviados");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    /**
     * Manages cases where the enpoint sent in the request does not exist
     * @param e Exception catched
     * @return response entity to be returned
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<GenericResponseDTO> resourceNotFound(NoResourceFoundException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.NOT_FOUND.value(), "Endpoint inexistente");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    /**
     * Manages cases where the endpoint sent in the request exists but not for the method given
     * @param e Exception catched
     * @return response entity to be returned
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<GenericResponseDTO> httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.METHOD_NOT_ALLOWED.value(), "Metodo no soportado");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * Manages cases where a validation went wrong
     * @param e Exception catched
     * @return response entity to be returned
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponseDTO> methodArgumentNotValid(MethodArgumentNotValidException e){
        GenericResponseDTO exceptionDTO = new GenericResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }
}
