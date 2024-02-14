package bootcamp.dtoresponseentityvivo.controller;

import bootcamp.dtoresponseentityvivo.service.BirthdayServiceImp;
import bootcamp.dtoresponseentityvivo.service.IBirthdayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@RestController
public class BirthdayController {

    private final IBirthdayService birthdayService = new BirthdayServiceImp();

    @GetMapping(path = "/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAgeByBirthDate(@PathVariable Integer day,
                                     @PathVariable Integer month,
                                     @PathVariable Integer year){
        if (!birthdayService.checkDate(day, month, year)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(birthdayService.calculateAge(day, month, year), HttpStatus.OK);
    }


}
