package com.ejemplo.blog.controller;

import com.ejemplo.blog.dto.EntradaBlogDTO;
import com.ejemplo.blog.dto.ResponseDTO;
import com.ejemplo.blog.service.IService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    IService service;

    public Controller(IService service) {
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<ResponseDTO> createBlog(@RequestBody EntradaBlogDTO entradaBlogDTO){

        return new ResponseEntity<>(service.create(entradaBlogDTO), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<ResponseDTO> getBlog(@PathVariable Integer id){

        return new ResponseEntity<>(service.getBlog(id), HttpStatus.OK);
    }


}
