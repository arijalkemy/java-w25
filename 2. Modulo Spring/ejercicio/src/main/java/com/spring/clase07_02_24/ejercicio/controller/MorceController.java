package com.spring.clase07_02_24.ejercicio.controller;

import com.spring.clase07_02_24.ejercicio.service.MorceConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorceController {
    @Autowired
    MorceConverterService morceConverterService;
    @GetMapping("/converter-to-alphabet/{morseCode}")
    public String morseCode(@PathVariable String morseCode){
        return morceConverterService.convertToAlphabet(morseCode);
    }
    @GetMapping("/converter-to-morse/{alphabetCode}")
    public String alphabetCode(@PathVariable String alphabetCode){
        return morceConverterService.normalToMorse(alphabetCode);
    }
}
