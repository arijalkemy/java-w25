package example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@RestController
@RequestMapping("/birthday")
public class Controller {

    @GetMapping(path = "/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAgeByBirthDate(@PathVariable Integer day,
                                                     @PathVariable Integer month,
                                                     @PathVariable Integer year){
        if (!checkDate(day, month, year)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(calculateAge(day, month, year), HttpStatus.OK);
    }


    private boolean checkDate(Integer day, Integer month, Integer year){
        return LocalDate.of(year, month, day).isBefore(LocalDate.now());
    }

    private Integer calculateAge(Integer day, Integer month, Integer year){
        return Period.between(
                LocalDate.of(year, month, day),
                LocalDate.now()
                )
                .getYears();
    }


}
