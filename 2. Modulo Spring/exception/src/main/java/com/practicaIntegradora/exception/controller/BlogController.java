package com.practicaIntegradora.exception.controller;

import com.practicaIntegradora.exception.dto.EntradaBlogDTO;
import com.practicaIntegradora.exception.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    IEntradaBlogService iEntradaBlogService;

    @PostMapping("/id")
    public EntradaBlogDTO crearId(@PathVariable EntradaBlogDTO entrada){
        return iEntradaBlogService.createBlog(entrada);
    }

    @GetMapping("/blog/{id}")
    public EntradaBlogDTO getById(@PathVariable int id){
        return iEntradaBlogService.getById( id);
    }

    @GetMapping("/blogs")
    public List<EntradaBlogDTO> getAll(){
        return iEntradaBlogService.getAll();
    }
}
