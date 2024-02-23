package com.example.deportistas.controller;


import com.example.deportistas.dto.response.DeportePersonaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportePersonaDTO>> getPersonas(){


        DeportePersonaDTO deportePersonaDTO = new DeportePersonaDTO();
        deportePersonaDTO.setNombre("Juan");
        deportePersonaDTO.setApellido("Perez");
        deportePersonaDTO.setDeporteNombre("Futbol");
        List<DeportePersonaDTO> deportePersonaDTOList = List.of(deportePersonaDTO);

        return ResponseEntity.ok(deportePersonaDTOList);

    }

}
