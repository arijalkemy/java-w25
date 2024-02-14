package com.ejercicio.redirecciones2.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(annotations = ResponseStatus.class)
public class GlobalExceptionHandler {

}
