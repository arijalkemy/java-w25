package com.bootcamp.clase9feb.starWars.controller;

import com.bootcamp.clase9feb.starWars.dto.response.PersonajeDTO;
import com.bootcamp.clase9feb.starWars.services.IPersonajeService;
import com.bootcamp.clase9feb.starWars.services.PersonajeServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
    IPersonajeService servicio;

    public PersonajeController (PersonajeServiceImp servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> getByName(@PathVariable String name){
        List<PersonajeDTO> personajesDto = servicio.getByName(name);
        return ResponseEntity.ok(personajesDto);
    }
}
