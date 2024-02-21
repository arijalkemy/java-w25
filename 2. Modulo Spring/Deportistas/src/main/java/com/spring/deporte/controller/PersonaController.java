package com.spring.deporte.controller;

import com.spring.deporte.dto.PersonaDTO;
import com.spring.deporte.mapper.PersonaMapper;
import com.spring.deporte.service.PersonaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/personas")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonaController {

    PersonaService personaService;

    @GetMapping("/findSportPersons")
    public ResponseEntity<List <PersonaDTO> > todosDeportistas(){

        return ResponseEntity.ok()
                             .body(PersonaMapper.getInstances(this.personaService.deportistas()));
    }
}
