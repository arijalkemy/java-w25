package org.example.age.controller;

import org.example.age.exception.BirthdayInvalidException;
import org.example.age.helper.AgeHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("age")
public class AgeController {
    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> GetAgeByBirthday(
            @PathVariable int day,
            @PathVariable int month,
            @PathVariable int year
    ){
        if(!AgeHelper.isValidBirthday(day,month,year))
            throw new BirthdayInvalidException();
        return ResponseEntity.ok(AgeHelper.getAgeByBirthday(day,month,year));
    }
}
