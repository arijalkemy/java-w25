package com.bootcamp.codigomorse.controller;

import com.bootcamp.codigomorse.model.CodigoMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    @GetMapping("/encode/{palabra}")
    public static String encode(@PathVariable String palabra){
        CodigoMorse codigoMorse = new CodigoMorse();
        return "La palabra "+palabra+" en lenguaje morse es: "+codigoMorse.convertToMorseCode(palabra);
    }

    @GetMapping("/decode/{morse}")
    public static String decode(@PathVariable String morse){
        CodigoMorse lenguajeNatural = new CodigoMorse();
        return "El codigo "+morse+" en lenguaje natural es: "+lenguajeNatural.convertFromMorseCode(morse);
    }
}
