package com.romanos.romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {

    @GetMapping
    public String sayHello(){

        return "Server is up and running!";

    }

    @GetMapping ("/{number}")
    public int convertToDecimal(@PathVariable String number){
        return NumberConverter.romanToDecimal(number);
    }
}
