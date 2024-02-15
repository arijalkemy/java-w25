package com.meli.romanos.controller;

import com.meli.romanos.service.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/conversor")
public class ConversorControlller {

    private ConversorService conversorService ;

    @Autowired
    public ConversorControlller(ConversorService conversorService) {
        this.conversorService = conversorService;
    }

    @GetMapping("/{numero}")
    public ResponseEntity<?> convertirDecimalARomano(@PathVariable int numero){
        return conversorService.convertirDecimalARomano(numero);
    }
}
