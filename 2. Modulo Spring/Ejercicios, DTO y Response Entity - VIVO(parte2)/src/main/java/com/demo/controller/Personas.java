package com.demo.controller;
import com.demo.dto.PersonaDTO;
import com.demo.model.Deporte;
import com.demo.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Personas {
    List<Deporte> deporteList = List.of(
            new Deporte("tenis",4),
            new Deporte("futbol",4),
            new Deporte("baloncesto",4),
            new Deporte("natación",5),
            new Deporte("viclismo",5),
            new Deporte("volleyball",4)
    );
    List<Persona> personasList = List.of(
            new Persona("Edward","Tivaduisa",34),
            new Persona("María","Beltrán",56),
            new Persona("Manuel","Corrtéz",14),
            new Persona("Geraldine","Avila",20)
    );

    List<PersonaDTO> peopleList = List.of(
            new PersonaDTO(personasList.get(0).getNombre(),personasList.get(0).getApellido(),deporteList.get(0).getNombre()),
            new PersonaDTO(personasList.get(1).getNombre(),personasList.get(1).getApellido(),deporteList.get(1).getNombre()),
            new PersonaDTO(personasList.get(2).getNombre(),personasList.get(2).getApellido(),deporteList.get(2).getNombre()),
            new PersonaDTO(personasList.get(3).getNombre(),personasList.get(3).getApellido(),deporteList.get(5).getNombre())
    );

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> findAllPersons(){
        return new ResponseEntity<>(peopleList, HttpStatus.OK);
    }
}
