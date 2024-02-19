package org.bootcamp.starwars.controller;

import org.bootcamp.starwars.DTO.PersonajeDto;
import org.bootcamp.starwars.entity.Personaje;
import org.bootcamp.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/getall")
    public ResponseEntity<List<PersonajeDto>> getAll(){
        return new ResponseEntity<>(personajeService.getAll(), HttpStatus.OK);
    }
}
