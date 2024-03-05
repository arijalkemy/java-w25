package com.example.athlete.controller;

import com.example.athlete.dto.PersonSportsDTO;
import com.example.athlete.dto.SportsByNameDTO;
import com.example.athlete.dto.SportsDTO;
import com.example.athlete.model.Person;
import com.example.athlete.model.Sport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("athlete")
public class AthleteController {

    public static List<Sport> sports = List.of(
            new Sport("Futbol", "Alto"),
            new Sport("Beisbol", "Intermedio")
    );

    public static List<Person> persons = List.of(
            new Person("Federico", "Perez", 30, sports.get(0)),
            new Person("Laura", "Gutierrez", 30, sports.get(1)),
            new Person("Juan", "Martinez", 30, sports.get(1)),
            new Person("Lorena", "Garzon", 30, sports.get(0))
    );

    @GetMapping("/findSports")
    public ResponseEntity<List<SportsDTO>> ListSports() {
        return ResponseEntity.ok(
                sports.stream()
                        .map((sport) -> new SportsDTO(sport.getName(), sport.getLevel()))
                        .toList()
        );
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<List<SportsByNameDTO>> FindSportByName(@PathVariable String name) {
        return ResponseEntity.ok(
                sports.stream()
                        .filter(
                                (sport) -> sport.getName().equals(name))
                        .map((sport -> new SportsByNameDTO(sport.getLevel())))
                        .toList()
        );
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonSportsDTO>> FindSportPersons() {
        return ResponseEntity.ok(
                persons.stream()
                        .map((person)-> new PersonSportsDTO(person.getName(), person.getLastName(),person.getSport().getName()))
                        .toList()
        );
    }


}
