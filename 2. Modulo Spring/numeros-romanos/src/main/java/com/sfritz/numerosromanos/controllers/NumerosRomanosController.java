package com.sfritz.numerosromanos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfritz.numerosromanos.models.NumeroRomano;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class NumerosRomanosController {

    @GetMapping("/{numero}")
    public Map<String,Object> getMethodName(@PathVariable String numero) {
        Map<String,Object> map = new HashMap<>();
        try {
            NumeroRomano nR = new NumeroRomano(Integer.parseInt(numero));
            map.put("Numero_romano", nR.getNumero());
        } catch (Exception e) {
            map.put("Numero_romano", "Ingrese un numero valido");
        }
        return map;
    }
    
}
