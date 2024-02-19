package com.bootcamp.ejercicio_starwars.controller;

import com.bootcamp.ejercicio_starwars.dto.PersonajeDTO;
import com.bootcamp.ejercicio_starwars.service.IService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    IService service;

    public Controller(IService service) {
        this.service = service;
    }

    @GetMapping("/getCharacters")
    public ResponseEntity<List<PersonajeDTO>> getAll(){
        return ResponseEntity.ok()
                .body(service.getAll());
    }
    @GetMapping("/getCharacters/{name}")
    public ResponseEntity<List<PersonajeDTO>> getAll(@PathVariable String name){
        return ResponseEntity.ok()
                .body(service.getCharactersByName(name));
    }
}
