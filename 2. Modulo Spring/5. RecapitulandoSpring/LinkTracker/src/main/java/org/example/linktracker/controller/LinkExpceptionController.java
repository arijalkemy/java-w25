package org.example.linktracker.controller;

import org.example.linktracker.dto.response.MessageDto;
import org.example.linktracker.exception.BadRequestLinkException;
import org.example.linktracker.exception.InvalidateLinkException;
import org.example.linktracker.exception.NotFoundException;
import org.example.linktracker.exception.PersistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExpceptionController {


    @ExceptionHandler(BadRequestLinkException.class)
    public ResponseEntity<?> badRequestException(BadRequestLinkException exception){
        return new ResponseEntity<>(new MessageDto(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException exception){
        return new ResponseEntity<>(new MessageDto(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<?> persistenceException(PersistenceException exception){
        return new ResponseEntity<>(new MessageDto(exception.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidateLinkException.class)
    public ResponseEntity<?> invalidateLinkException(InvalidateLinkException exception){
        return new ResponseEntity<>(new MessageDto(exception.getMessage()), HttpStatus.NOT_FOUND);
    }




}
