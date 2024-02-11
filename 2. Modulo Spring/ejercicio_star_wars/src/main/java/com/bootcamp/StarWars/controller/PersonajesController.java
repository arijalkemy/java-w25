package com.bootcamp.StarWars.controller;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import com.bootcamp.StarWars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonajesController {
    @Autowired
    PersonajeService personajeService;

    @GetMapping("/searchCharacter/{name}")
    public ResponseEntity<List<PersonajeDTO>> searchCharacter(@PathVariable String name){
        List<PersonajeDTO> characters;
        characters = personajeService.buscarPorNombre(name);
        if(characters.isEmpty()){
            return new ResponseEntity<>(characters, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
}
