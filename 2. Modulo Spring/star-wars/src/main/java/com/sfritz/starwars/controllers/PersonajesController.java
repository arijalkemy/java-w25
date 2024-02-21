package com.sfritz.starwars.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfritz.starwars.dtos.PersonajeDTO;
import com.sfritz.starwars.services.PersonajeService;
import com.sfritz.starwars.services.PersonajeServiceImpl;

@RestController
@RequestMapping("/personaje")
public class PersonajesController {

    private PersonajeService service;

    public PersonajesController(PersonajeServiceImpl service){
        this.service = service;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajeByName(@PathVariable String name){
        List<PersonajeDTO> personajeDTOs = service.getPersonajesByName(name);
        return new ResponseEntity<>(personajeDTOs,HttpStatus.OK);
    }
}
