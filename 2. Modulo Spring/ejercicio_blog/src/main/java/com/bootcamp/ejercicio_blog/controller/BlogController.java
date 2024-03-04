package com.bootcamp.ejercicio_blog.controller;

import com.bootcamp.ejercicio_blog.dto.EntradaBlogDTO;
import com.bootcamp.ejercicio_blog.dto.response.ResponseEntradaBlogDTO;
import com.bootcamp.ejercicio_blog.service.BlogServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogServiceImp blogService;

    @PostMapping("/blog")
    public ResponseEntity<ResponseEntradaBlogDTO> addEntry(@RequestBody EntradaBlogDTO request){
        ResponseEntradaBlogDTO response = blogService.addEntry(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> getById(@PathVariable int id){
        return new ResponseEntity<>(blogService.getById(id), HttpStatus.OK);
    }
    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> getAll(){
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
    }
}
