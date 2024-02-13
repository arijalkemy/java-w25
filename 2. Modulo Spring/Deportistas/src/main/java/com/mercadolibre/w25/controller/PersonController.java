package com.mercadolibre.w25.controller;

import com.mercadolibre.w25.dto.PersonDto;
import com.mercadolibre.w25.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonServices personServices;

    @GetMapping("/findAll")
    public ResponseEntity<List<PersonDto>> findSports(){
        return  new ResponseEntity<>(personServices.getAllPerson(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PersonDto> addSport(@RequestBody PersonDto personDao) {
        personServices.addPerson(personDao);
        return new ResponseEntity<>(personDao, HttpStatus.OK);
    }
}
