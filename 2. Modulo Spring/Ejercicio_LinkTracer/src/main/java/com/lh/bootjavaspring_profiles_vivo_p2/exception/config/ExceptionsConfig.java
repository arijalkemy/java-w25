package com.lh.bootjavaspring_profiles_vivo_p2.exception.config;

import com.lh.bootjavaspring_profiles_vivo_p2.dto.response.ExceptionDTO;
import com.lh.bootjavaspring_profiles_vivo_p2.exception.AlreadyExistsException;
import com.lh.bootjavaspring_profiles_vivo_p2.exception.InvalidLinkException;
import com.lh.bootjavaspring_profiles_vivo_p2.exception.NotFoundLinkException;
import com.lh.bootjavaspring_profiles_vivo_p2.exception.UnauthorizedLinkException;
import com.lh.bootjavaspring_profiles_vivo_p2.util.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionsConfig {

    Mapper mapper = new Mapper();

    @ExceptionHandler(NotFoundLinkException.class)
    public ResponseEntity<ExceptionDTO> handlerNotFoundBlog(NotFoundLinkException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "No se encontró el link solicitado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ExceptionDTO> handlerInvalidLink(InvalidLinkException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "El link al que desea ingresar es invalido");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
    }

    @ExceptionHandler(UnauthorizedLinkException.class)
    public ResponseEntity<ExceptionDTO> handlerUnauthorizedLink(UnauthorizedLinkException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "El usuario no esta autenticado");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exceptionDTO);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionDTO> handlerUnauthorizedLink(AlreadyExistsException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "Ya existe un link creado con esas caracteristicas");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDTO);
    }
}
