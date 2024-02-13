package com.mercadolibre.demow25.controller;

import com.mercadolibre.demow25.service.RomanCoverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("")

public class RomanController {

    @Autowired
    RomanCoverterService romanCoverterService;

    @GetMapping (path = "/toroman/{number}" )
    public String castRomanNumber(@PathVariable Integer number){
        return romanCoverterService.castToRoman(number);
    }
}
