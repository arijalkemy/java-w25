package com.example.youtuber.controller;

import com.example.youtuber.dto.EntradaBlogDTO;
import com.example.youtuber.dto.GenericResponseDTO;
import com.example.youtuber.entity.EntradaBlog;
import com.example.youtuber.service.IEntradaBlogService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api")
public class EntradaBlogController {

    // sala 13
    private IEntradaBlogService entradaBlogService;

    public EntradaBlogController(IEntradaBlogService entradaBlogService){
        this.entradaBlogService = entradaBlogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<GenericResponseDTO> crearEntradaBlog(@RequestBody EntradaBlogDTO entradaBlogDTO ){

        return ResponseEntity.status(HttpStatus.CREATED).body(this.entradaBlogService.savePost(entradaBlogDTO));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> obtenerEntradaPorId(@PathVariable int id){
        return new ResponseEntity<>(this.entradaBlogService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> obtenerEntradas(){
        return new ResponseEntity<>(this.entradaBlogService.findAll(), HttpStatus.OK);
    }
}