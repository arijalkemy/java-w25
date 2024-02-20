package com.starwars.starwars.controller;

import com.starwars.starwars.service.PersonajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajeController {
    @GetMapping("/personaje/{name}")
    public String getPersonajeByName(@PathVariable String name) {
        PersonajeService personajeService = new PersonajeService();
        return ResponseEntity.ok(personajeService.getPersonajeByName(name)
        ).toString();
    }
}
