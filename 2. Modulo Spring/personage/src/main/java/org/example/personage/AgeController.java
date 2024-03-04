package org.example.personage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/age")
public class AgeController {
    @GetMapping("/{day}/{month}/{year}")
    public Integer get(@PathVariable short day,@PathVariable short month,@PathVariable int year){
        return (int)ChronoUnit.YEARS.between(LocalDate.of(year,month,day),LocalDate.now());
    }
}
