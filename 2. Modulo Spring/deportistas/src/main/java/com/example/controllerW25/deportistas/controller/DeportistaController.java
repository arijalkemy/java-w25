package com.example.controllerW25.deportistas.controller;

import com.example.controllerW25.deportistas.model.Deporte;
import com.example.controllerW25.deportistas.service.DeportistaService;
import com.example.controllerW25.deportistas.dto.PersonaDeportistaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deportistas")
public class DeportistaController {
    private final DeportistaService deportistaService;

    public DeportistaController(DeportistaService deportistaService) {
        this.deportistaService = deportistaService;
    }
    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        return new ResponseEntity<>(deportistaService.findAllSports(), HttpStatus.OK);
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> findSports(@PathVariable String name) {
        return new ResponseEntity<>(deportistaService.findSport(name), HttpStatus.OK);
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeportistaDTO>> findSportsPersons() {
        return new ResponseEntity<>(deportistaService.findSportPersons(), HttpStatus.OK);
    }
}
