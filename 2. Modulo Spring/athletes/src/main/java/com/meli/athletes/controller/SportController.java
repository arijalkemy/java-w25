package com.meli.athletes.controller;

import com.meli.athletes.dto.PersonDTO;
import com.meli.athletes.dto.SportDTO;
import com.meli.athletes.dto.SportLevelDTO;
import com.meli.athletes.dto.SportNameDTO;
import com.meli.athletes.entity.Person;
import com.meli.athletes.entity.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/sport")
public class SportController {

    @GetMapping("/findSports")
    public List<SportDTO> findSports() {
        return getSports().stream().map(sport -> new SportDTO(sport.getName(), sport.getLevel())).toList();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<SportLevelDTO> findSportByName(@PathVariable String name) {
        Sport sport = getSports().stream().filter(sp -> Objects.equals(sp.getName(), name)).findFirst().orElse(null);

        if (sport == null) {
            throw new RuntimeException("El deporte no se encontró en la BD");
        }

        SportLevelDTO sportLevelDTO = new SportLevelDTO(sport.getLevel());

        return new ResponseEntity<>(sportLevelDTO, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public List<PersonDTO> findPersonas() {
        return getPersons().stream().map(person -> new PersonDTO(
                person.getName(), person.getLastname(),
                new SportNameDTO(person.getSport().getName()))).toList();
    }

    private List<Sport> getSports() {
        return List.of(
                new Sport("CrossFit", "Advanced"),
                new Sport("Rugby", "Amateur"),
                new Sport("Soccer", "Middle")
        );
    }

    private List<Person> getPersons() {
        return List.of(
                new Person("Nicolás", "Aimar", 28, new Sport("CrossFit", "Advanced")),
                new Person("John", "Doe", 30, new Sport("Rugby", "Amateur")),
                new Person("Juan", "Pérez", 20, new Sport("Soccer", "Middle"))
        );
    }
}