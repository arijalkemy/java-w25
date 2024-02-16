package com.ejemplo.blog.controller;

import com.ejemplo.blog.dto.ExceptionDTO;
import com.ejemplo.blog.dto.ResponseDTO;
import com.ejemplo.blog.exceptions.NotFoundException;
import com.ejemplo.blog.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogsController {

    @Autowired
    IService service;
    @GetMapping("/blogs")
    public ResponseEntity<List<ResponseDTO>> getBlogs(){

        return new ResponseEntity<>(service.getBlogs(), HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDTO> listNotFound(NotFoundException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(),
                "No se encuntra almacenado ningun blog",
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
