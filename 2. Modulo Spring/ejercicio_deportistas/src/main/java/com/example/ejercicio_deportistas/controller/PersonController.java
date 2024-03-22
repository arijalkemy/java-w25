package com.example.ejercicio_deportistas.controller;

import com.example.ejercicio_deportistas.dto.SportDTO;
import com.example.ejercicio_deportistas.dto.SportPersonDTO;
import com.example.ejercicio_deportistas.repository.IPersonRepository;
import com.example.ejercicio_deportistas.service.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPersonDTO>> findAll(){
        return new ResponseEntity<List<SportPersonDTO>>(personService.findSportPerson(), HttpStatus.OK);
    }
}
