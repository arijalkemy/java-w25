package com.example.star_wars_pj.controller;

import com.example.star_wars_pj.dto.PersonajeDto;
import com.example.star_wars_pj.entity.Personaje;
import com.example.star_wars_pj.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/starwars")
public class PersonajeController {

    PersonajeService service = new PersonajeService();

    @GetMapping("")
    public ResponseEntity<List<PersonajeDto>> getAllPersonajes(){


        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDto>> getBySearch(@RequestParam String name){

        return new ResponseEntity<>(service.getBySearch(name),HttpStatus.OK);
    }

}
