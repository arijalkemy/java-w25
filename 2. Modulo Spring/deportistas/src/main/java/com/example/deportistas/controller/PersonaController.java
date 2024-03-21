package com.example.deportistas.controller;


import com.example.deportistas.dto.response.DeportePersonaDTO;
import com.example.deportistas.model.Persona;
import com.example.deportistas.repository.PersonaRepository;
import com.example.deportistas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportePersonaDTO>> getPersonas(){
      return ResponseEntity.ok(personaService.getPersonas());

    }

}
