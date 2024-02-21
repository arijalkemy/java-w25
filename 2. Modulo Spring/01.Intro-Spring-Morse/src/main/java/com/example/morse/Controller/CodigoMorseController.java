package com.example.morse.Controller;

import com.example.morse.domain.CodigoMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class CodigoMorseController {

    CodigoMorse codigoMorse = new CodigoMorse();

    @GetMapping("/codificar/{palabra}")
    public String codificar(@PathVariable String palabra){
        System.out.println(palabra);
        return this.codigoMorse.codificarAMorse(palabra);
    }

    @GetMapping("/decodificar/{palabra}")
    public String decodificar(@PathVariable String palabra){
        return this.codigoMorse.decodificarMorse(palabra);
    }
}
