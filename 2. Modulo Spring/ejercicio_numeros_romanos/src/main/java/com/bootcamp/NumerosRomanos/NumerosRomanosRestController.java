package com.bootcamp.NumerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosRestController {

    @GetMapping("/{numeroDecimal}")
    public String convertirARomano(@PathVariable int numeroDecimal){
        return new CreadorDeNumeroRomano(numeroDecimal).crearNumeroRomano();
    }
}
