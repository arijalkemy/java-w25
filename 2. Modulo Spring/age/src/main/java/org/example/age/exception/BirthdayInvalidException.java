package org.example.age.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid birthday")
public class BirthdayInvalidException extends RuntimeException{

}
