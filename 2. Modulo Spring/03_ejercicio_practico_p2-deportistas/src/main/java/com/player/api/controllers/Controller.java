package com.player.api.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.player.api.classes.Sport;
import com.player.api.classes.Person;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Controller {
    List<Sport> sports =
            List.of(new Sport("Fútbol", "Profesional"), new Sport("Tenis", "Amateur"),
                    new Sport("Baloncesto", "Profesional"), new Sport("Natación", "Amateur"),
                    new Sport("Béisbol", "Profesional"), new Sport("Golf", "Amateur"),
                    new Sport("Vóley", "Amateur"), new Sport("Ciclismo", "Profesional"),
                    new Sport("Atletismo", "Amateur"), new Sport("Rugby", "Profesional"));

    List<Person> people =
            List.of(new Person("Juan", "Pérez", 25, List.of(this.sports.get(0), this.sports.get(2))),
                    new Person("María", "López", 30, List.of(this.sports.get(4), this.sports.get(3))),
                    new Person("Carlos", "García", 28, List.of(this.sports.get(5), this.sports.get(1))),
                    new Person("Ana", "Rodríguez", 22, List.of(this.sports.get(4))),
                    new Person("Luis", "Hernández", 35, List.of(this.sports.get(0))));

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> SportList() {
        return new ResponseEntity<>(, HttpStatus.OK);
    }

    // @GetMapping("/findSport/{nombre}")
    // public String getMethodName(@PathParam nombre) {
    //     return new String();
    // }

    // @GetMapping("/findSportsPersons")
    // public String getMethodName() {
    //     return new String();
    // }

}
