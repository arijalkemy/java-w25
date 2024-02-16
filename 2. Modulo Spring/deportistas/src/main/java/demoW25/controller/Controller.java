package demoW25.controller;

import demoW25.dto.PersonDTO;
import demoW25.dto.SportDTO;
import demoW25.model.Sports;
import demoW25.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    SportService service;

    @GetMapping("/findSports")
    public ResponseEntity<List<Sports>> getSports() {

        return new ResponseEntity<>(service.getSport(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<SportDTO> getSport(@PathVariable String name) {

        return new ResponseEntity<>(service.getOneSport(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDTO>> getSport() {

        return new ResponseEntity<>(service.getPerson(), HttpStatus.OK);
    }
}
