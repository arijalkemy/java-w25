package com.example.personajesdestarwars.controller;


import com.example.personajesdestarwars.dto.PersonajeDTO;
import com.example.personajesdestarwars.service.IPersonajeService;
import com.example.personajesdestarwars.service.PersonajeServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonajesController {

    IPersonajeService personajeService;

    public PersonajesController(PersonajeServiceImp personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(@PathVariable String name) {
        List<PersonajeDTO> personajes = personajeService.findAllByNameContains(name);
        return new ResponseEntity<>(personajes, HttpStatus.OK);
    }
}
