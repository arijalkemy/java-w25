package main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportsController {

    @GetMapping("/findSports")
    public ResponseEntity<String> findSports(){
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportByName(){
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping("/findSportsPerson")
    public ResponseEntity<String> findSportsPerson(){
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

}
