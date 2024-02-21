package com.example.covid.controller;

import com.example.covid.dtos.PersonaRiskDto;
import com.example.covid.dtos.SintomaDto;
import com.example.covid.models.Sintoma;
import com.example.covid.models.Persona;
import com.example.covid.repository.CovidRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CovidController {

    @GetMapping("findSymptom")
    public ResponseEntity<List<Sintoma>> getSintomas(){
        return ResponseEntity.ok(CovidRepository.getAllSintomas());
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<SintomaDto> getSintomaByName(@PathVariable String name){
        Optional<Sintoma> sintoma = CovidRepository.getSintomaByName(name);
        if (sintoma.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.status(200).body(new SintomaDto(sintoma.get().getGravedad()));
    }

    @GetMapping("findRiskPerson")
    public ResponseEntity<List<PersonaRiskDto>> getPersonasEnRiesgo(){
        List<Persona> personasEnRiesgo = CovidRepository.getPersonasEnRiesgo();

        List<PersonaRiskDto> personas = personasEnRiesgo.stream().map( p -> new PersonaRiskDto(p.getNombre(), p.getApellido(), p.getSintomas().stream().map(s -> s.getNombre()).toList())).toList();
        return ResponseEntity.ok(personas);
    }
}
