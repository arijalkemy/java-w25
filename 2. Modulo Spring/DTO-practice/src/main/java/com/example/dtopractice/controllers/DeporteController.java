package com.example.dtopractice.controllers;

import com.example.dtopractice.dto.DeporteDTO;
import com.example.dtopractice.dto.DeportesDTO;
import com.example.dtopractice.dto.PersonasDTO;
import com.example.dtopractice.model.Deporte;
import com.example.dtopractice.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DeporteController {

  static List<Deporte> deportes = new ArrayList<>();
  static List<Persona> personas = new ArrayList<>();

  @GetMapping("/findSports")
  public ResponseEntity<DeportesDTO> findSports() {
    return new ResponseEntity<>(new DeportesDTO(loadDeportes()), HttpStatus.OK);
  }

  @GetMapping("/findSport/{nombre}")
  public ResponseEntity<DeporteDTO> findSports(@PathVariable String nombre) {
    List<Deporte> deportes = loadDeportes();

    Optional<Deporte> deporte = deportes.stream().filter(d -> d.getNombre().equals(nombre)).findFirst();

    if (deporte.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.OK);
    }

    Deporte deporteEncontrado = deporte.get();
    return new ResponseEntity<>(
        new DeporteDTO(
            deporteEncontrado.getNivel()
        ),
        HttpStatus.OK
    );
  }

  @GetMapping("/findSportsPersons")
  public ResponseEntity<PersonasDTO> findSportsPersons() {
    return new ResponseEntity<>(new PersonasDTO(), HttpStatus.OK);
  }

  private List<Deporte> loadDeportes() {
    if (!deportes.isEmpty()) return deportes;

    deportes.add(new Deporte("Futbol", 5));
    deportes.add(new Deporte("Natación", 4));

    return deportes;
  }

  private List<Persona> loadPersonas() {
    return List.of();
  }
}
