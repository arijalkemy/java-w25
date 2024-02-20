package main.controller;

import main.dto.DeporteResponseDTO;
import main.dto.PersonaDeporteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    //Para validar si una persona es deportista
    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteResponseDTO>> getSports(){
        List<DeporteResponseDTO> sports = List.of(new DeporteResponseDTO("Futbol",1),new DeporteResponseDTO("Voley",2));
        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Integer> existSport(@PathVariable String name){
        List<DeporteResponseDTO> sports = List.of(new DeporteResponseDTO("Futbol",1),
                new DeporteResponseDTO("Voley",2));

        int level = sports.stream()
                .filter(s-> s.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró la persona"))
                .getLevel();

        return new ResponseEntity<>(level,HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> getSportPerson(){

        List<PersonaDeporteDTO> personSports =
                List.of(new PersonaDeporteDTO("Carlos","Futbol"),
                        new PersonaDeporteDTO("Julian","Voley"));

        return new ResponseEntity<>(personSports, HttpStatus.OK);
    }

}
