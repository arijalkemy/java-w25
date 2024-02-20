package main.controller;

import main.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/{day}/{month}/{year}")
    public int getEdad (@PathVariable int day,@PathVariable int month, @PathVariable int year){
        return Persona.getEdad(day, month, year);
    }
}
