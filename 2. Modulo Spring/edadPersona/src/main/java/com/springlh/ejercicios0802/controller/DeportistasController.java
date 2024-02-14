package com.springlh.ejercicios0802.controller;

import com.springlh.ejercicios0802.model.Deporte;
import com.springlh.ejercicios0802.model.Persona;
import com.springlh.ejercicios0802.model.PersonaDeportista;
import com.springlh.ejercicios0802.repository.DeportesRepository;
import com.springlh.ejercicios0802.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/deportistas")
public class DeportistasController {

    DeportesRepository deportesRepository;
    PersonasRepository personasRepository;

    List<Persona> personasAlmacenadas;
    List<Deporte> deportesAlmacenados;

    List<PersonaDeportista> personasDeportistas;

    public DeportistasController(DeportesRepository deportesRepository, PersonasRepository personasRepository) {
        this.deportesRepository = deportesRepository;
        this.personasRepository = personasRepository;

        this.personasAlmacenadas = personasRepository.getPersonas();
        this.deportesAlmacenados = deportesRepository.getDeportes();

        this.personasDeportistas = Arrays.asList(
                new PersonaDeportista(
                        personasAlmacenadas.get(0).getNombre(),
                        personasAlmacenadas.get(0).getApellido(),
                        deportesAlmacenados.get(0).getNombre()),
                new PersonaDeportista(
                        personasAlmacenadas.get(1).getNombre(),
                        personasAlmacenadas.get(1).getApellido(),
                        deportesAlmacenados.get(1).getNombre()),
                new PersonaDeportista(
                        personasAlmacenadas.get(2).getNombre(),
                        personasAlmacenadas.get(2).getApellido(),
                        deportesAlmacenados.get(2).getNombre()),
                new PersonaDeportista(
                        personasAlmacenadas.get(3).getNombre(),
                        personasAlmacenadas.get(3).getApellido(),
                        deportesAlmacenados.get(3).getNombre()),
                new PersonaDeportista(
                        personasAlmacenadas.get(4).getNombre(),
                        personasAlmacenadas.get(4).getApellido(),
                        deportesAlmacenados.get(4).getNombre()),
                new PersonaDeportista(
                        personasAlmacenadas.get(5).getNombre(),
                        personasAlmacenadas.get(5).getApellido(),
                        deportesAlmacenados.get(5).getNombre()),
                new PersonaDeportista(
                        personasAlmacenadas.get(6).getNombre(),
                        personasAlmacenadas.get(6).getApellido(),
                        deportesAlmacenados.get(6).getNombre())
        );
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        return new ResponseEntity<>(deportesAlmacenados, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Optional<Deporte>> findSportByName(@PathVariable String name) {
        Optional<Deporte> deporte = deportesRepository.getDeporteByName(name);
        return new ResponseEntity<>(deporte, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeportista>> findSportsPersons() {
        return new ResponseEntity<>(personasDeportistas, HttpStatus.OK);
    }
}
