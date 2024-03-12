package com.example.poryectoblog.controller;

import com.example.poryectoblog.dto.EntradaBlogDto;
import com.example.poryectoblog.service.IEntradaBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntradaBlogController {

    private IEntradaBlogService entradaBlogService;

    public EntradaBlogController(IEntradaBlogService entradaBlogService) {
        this.entradaBlogService = entradaBlogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> addNewBlog(@RequestBody EntradaBlogDto entradaBlogDto){

        return entradaBlogService.addNewEntradaBlog(entradaBlogDto);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> addNewBlog(@PathVariable Integer id){

        return entradaBlogService.getEntradaBlogById(id);
    }


}
