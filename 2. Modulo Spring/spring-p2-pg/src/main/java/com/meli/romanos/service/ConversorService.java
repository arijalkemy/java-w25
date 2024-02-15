package com.meli.romanos.service;

import com.meli.romanos.utils.Conversor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConversorService {


    public ResponseEntity<?> convertirDecimalARomano(int numero){

        Map<String,String> response = new HashMap<>();
        if(numero <= 9999){
            String numeroRomano = Conversor.convertirDecimalARomano(numero);
            response.put("resultado",numeroRomano);
            return ResponseEntity.ok(response);
        }

        response.put("message","ingrese un numero menor que 9999");
        return ResponseEntity.badRequest().body(response);
    }
}
