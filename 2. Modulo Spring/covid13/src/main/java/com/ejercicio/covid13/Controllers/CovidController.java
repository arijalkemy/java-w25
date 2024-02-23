package com.ejercicio.covid13.Controllers;

import com.ejercicio.covid13.Models.Persona;
import com.ejercicio.covid13.Models.PersonaDTO;
import com.ejercicio.covid13.Models.SIntoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController

public class CovidController {
    private List<SIntoma> sintomas = Arrays.asList(
            new SIntoma(1, "Fiebre", "Alto"),
            new SIntoma(2, "Tos seca", "Moderado")
            // Agrega más síntomas según sea necesario
    );

    private List<Persona> personas = Arrays.asList(
            new Persona(1, "Juan", "Perez", 25, Arrays.asList(sintomas.get(0))),
            new Persona(2, "Ana", "Gomez", 70, Arrays.asList(sintomas.get(1)))
            // Agrega más personas según sea necesario
    );

    @GetMapping("/getSintomas")
    public ResponseEntity<List<SIntoma>> getSintomas() {
        return ResponseEntity.ok(sintomas);
    }

    ;

    @GetMapping("/getSintomas/{name}")
    public ResponseEntity<String> getSintomaByName(@PathVariable String name) {
        SIntoma sIntoma = sintomas.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
        if (sIntoma != null) {
            return new ResponseEntity<>("Nivel de gravedad " + name + "; " + sIntoma.getNivelDeGravedad(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontro el sintoma  " + name, HttpStatus.NO_CONTENT);
        }
    };

    @GetMapping("/getFindrisk")
    public ResponseEntity<List<PersonaDTO>> getFindrisk() {
        List<PersonaDTO> personaDTOss = personas.stream()
                .filter(p -> p.getEdad() > 60 && !p.getSintomas().isEmpty())
                .map(p -> new PersonaDTO(p.getNombre(), p.getApellido()))
                .collect(Collectors.toList());
        if(personaDTOss.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(personaDTOss, HttpStatus.OK);
        }
    };


};
