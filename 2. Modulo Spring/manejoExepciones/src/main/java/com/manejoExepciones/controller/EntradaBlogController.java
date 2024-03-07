package com.manejoExepciones.controller;

import com.manejoExepciones.dto.IDBlogDTO;
import com.manejoExepciones.dto.RequestBlogDTO;
import com.manejoExepciones.dto.ResponseBlogDTO;
import com.manejoExepciones.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EntradaBlogController {

    private IEntradaBlogService entradaBlogService;

    @Autowired
    public EntradaBlogController(IEntradaBlogService entradaBlogService) {
        this.entradaBlogService = entradaBlogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<IDBlogDTO> save(@RequestBody RequestBlogDTO requestBlogDTO){
        IDBlogDTO idBlogDTO = entradaBlogService.save(requestBlogDTO);
        return ResponseEntity.ok().body(idBlogDTO);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<ResponseBlogDTO> getById(@PathVariable int id){
        return ResponseEntity.ok().body(entradaBlogService.getById(id).get());
    }

    @GetMapping ("/blogs")
    public ResponseEntity<List<ResponseBlogDTO>> getAll(){
        return ResponseEntity.ok().body(entradaBlogService.getAll());
    }


}
