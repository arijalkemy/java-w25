package com.springlh.ejercicios0802.controller;

import com.springlh.ejercicios0802.model.*;
import com.springlh.ejercicios0802.repository.DeportesRepository;
import com.springlh.ejercicios0802.repository.PersonasRepository;
import com.springlh.ejercicios0802.repository.SintomaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/covid")
public class SintomasController {
    SintomaRepository sintomaRepository;
    PersonasRepository personasRepository;

    List<SintomaDTO> sintomasAlmacenados;
    List<Persona> personasDeRiesgoAlmacenadas;
    List<PersonaDeRiesgo> personasDeRiesgo;


    public SintomasController(SintomaRepository sintomaRepository, PersonasRepository personasRepository) {

        this.sintomaRepository = sintomaRepository;
        this.personasRepository = personasRepository;

        this.sintomasAlmacenados = sintomaRepository.getSintomas();
        this.personasDeRiesgoAlmacenadas = personasRepository.getPersonasDeRiesgo();

        this.personasDeRiesgo = Arrays.asList(
                new PersonaDeRiesgo(
                        personasDeRiesgoAlmacenadas.get(0).getNombre(),
                        personasDeRiesgoAlmacenadas.get(0).getApellido(),
                        Arrays.asList(
                                sintomasAlmacenados.get(4)
                        )),
                new PersonaDeRiesgo(
                        personasDeRiesgoAlmacenadas.get(1).getNombre(),
                        personasDeRiesgoAlmacenadas.get(1).getApellido(),
                        Arrays.asList(
                                sintomasAlmacenados.get(5),
                                sintomasAlmacenados.get(6)
                        )),
                new PersonaDeRiesgo(
                        personasDeRiesgoAlmacenadas.get(2).getNombre(),
                        personasDeRiesgoAlmacenadas.get(2).getApellido(),
                        Arrays.asList(
                                sintomasAlmacenados.get(0),
                                sintomasAlmacenados.get(1),
                                sintomasAlmacenados.get(2)
                        )),
                new PersonaDeRiesgo(
                        personasDeRiesgoAlmacenadas.get(3).getNombre(),
                        personasDeRiesgoAlmacenadas.get(3).getApellido(),
                        Arrays.asList(
                                sintomasAlmacenados.get(3),
                                sintomasAlmacenados.get(4),
                                sintomasAlmacenados.get(5),
                                sintomasAlmacenados.get(6)
                        )
                )
        );
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> findSymptom() {
        return new ResponseEntity<>(sintomasAlmacenados, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Optional<SintomaDTO>> findSportByName(@PathVariable String name) {
        Optional<SintomaDTO> sintomaDTO = sintomaRepository.getSintomaByName(name);
        return new ResponseEntity<>(sintomaDTO, HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDeRiesgo>> findRiskPerson() {
        return new ResponseEntity<>(personasDeRiesgo, HttpStatus.OK);
    }
}
