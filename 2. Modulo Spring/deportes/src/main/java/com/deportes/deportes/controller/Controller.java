package com.deportes.deportes.controller;

import com.deportes.deportes.classes.Deporte;
import com.deportes.deportes.classes.Persona;
import com.deportes.deportes.dto.DeporteDTO;
import com.deportes.deportes.dto.PersonaDeporteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class Controller {

    Persona persona1 = new Persona("Pedro", "Gimenez", 25);
    Persona persona2 = new Persona("Maria", "Gomez", 24);
    Deporte basket = new Deporte("Basket", 3);
    Deporte skiDiving = new Deporte("Sky Diving", 5);

    private String miVar = basket.getNombre();

    List<Persona> listaPersonas = new ArrayList<>(List.of(new Persona[]{persona1, persona2}));
    List<Deporte> listaDeportes = new ArrayList<>(List.of(new Deporte[]{basket, skiDiving}));

    // Probar http://localhost:8080/findSports
    @GetMapping("findSports")
    public String getAllSportsNames() {
        List<String> listaNombresDeportes = new ArrayList<>();
        listaDeportes.forEach(d -> listaNombresDeportes.add(d.getNombre()));
        return listaNombresDeportes.toString();
    }

    // Probar http://localhost:8080/findSport/basket
    @GetMapping("findSport/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable("name") String name) {
        System.out.println(name);
        Optional<Deporte> myDeporte = listaDeportes.stream()
                .filter(dep -> {
                    System.out.println(dep.getNombre());
                    return Objects.equals(dep.getNombre().toLowerCase(), name.toLowerCase());
                }).findAny();
        System.out.println(myDeporte);
        if (myDeporte.isPresent()){
            DeporteDTO myDeporteDTO = new DeporteDTO(myDeporte.get().getNombre(), myDeporte.get().getNivel());
            return new ResponseEntity<>(myDeporteDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>("Nombre no encontrado", HttpStatus.NOT_FOUND);
    }

    // Probar http://localhost:8080/findSportsPersons
    @GetMapping("findSportsPersons")
    public ResponseEntity<ArrayList<PersonaDeporteDTO>> getSportsPersons() {
        PersonaDeporteDTO perDep1 = new PersonaDeporteDTO("Pedro", "Gimenez", "Basket");
        PersonaDeporteDTO perDep2 = new PersonaDeporteDTO("Maráa", "Gomez", "Sky Diving");
        ArrayList<PersonaDeporteDTO> personasYDeportes = new ArrayList<>();
        personasYDeportes.add(perDep1);
        personasYDeportes.add(perDep2);
        return new ResponseEntity<>(personasYDeportes, HttpStatus.OK);
    }
}