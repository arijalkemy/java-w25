package com.mercadolibre.app_deportistas_nq.controller;

import com.mercadolibre.app_deportistas_nq.service.IPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(personService.findPersons());
    }

    @GetMapping("/sporstmen")
    public ResponseEntity<?> getSportsmen() {
        return ResponseEntity.ok(personService.findPersonSports());
    }
}
