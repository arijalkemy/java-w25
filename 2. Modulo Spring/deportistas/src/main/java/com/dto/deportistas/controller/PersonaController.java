package com.dto.deportistas.controller;

import com.dto.deportistas.dto.PersonaDTO;
import com.dto.deportistas.model.Persona;
import com.dto.deportistas.service.ServicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    ServicePerson servicePerson;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> getPersonas (){
        return new ResponseEntity<>(servicePerson.getPersonas(), HttpStatus.OK);
    }
}
