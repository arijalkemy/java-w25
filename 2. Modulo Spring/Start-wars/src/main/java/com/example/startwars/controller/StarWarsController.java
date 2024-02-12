package com.example.startwars.controller;

import com.example.startwars.dto.PersonajeDTO;
import com.example.startwars.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StarWarsController {

  @GetMapping("/{nombre}")
  ResponseEntity<List<PersonajeDTO>> encontrar(@PathVariable String nombre){
    PersonajeService personajeService = new PersonajeService();
    return new ResponseEntity<>(personajeService.get(nombre), HttpStatus.OK);
  }
}
