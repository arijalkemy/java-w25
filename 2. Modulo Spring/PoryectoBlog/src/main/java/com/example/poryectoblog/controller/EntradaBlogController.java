package com.example.poryectoblog.controller;

import com.example.poryectoblog.dto.EntradaBlogDto;
import com.example.poryectoblog.service.IEntradaBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("")


}
