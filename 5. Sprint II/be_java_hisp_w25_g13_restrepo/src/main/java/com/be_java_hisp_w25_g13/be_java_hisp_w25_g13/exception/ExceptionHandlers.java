package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.ExceptionDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.ValidExceptionDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> badRequest(BadRequestException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> notfound(NotFoundException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ExceptionDTO> alreadyExist(AlreadyExistException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidExceptionDTO> methodArgumentNotValid(MethodArgumentNotValidException e) {
        List<String> errorMessages = new ArrayList<>();
        for(ObjectError error: e.getBindingResult().getAllErrors()){
            if(error instanceof FieldError){
                FieldError fieldError = (FieldError) error;
                errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            } else {
                errorMessages.add(error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(new ValidExceptionDTO(errorMessages), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionDTO> methodArgumentTypeMismatch(MethodArgumentTypeMismatchException e) {
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
