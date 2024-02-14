package com.numerosRomanos.conversion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/converToRome/{numero}")
    public String sayHello(@PathVariable int numero){
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 3999");
        }

        String numeroRomano = convertirARomano(numero);
        return "El número " + numero + " en números romanos es: " + numeroRomano;
    }

    public static String convertirARomano(int numero) {
        int[] valoresDecimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] valoresRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < valoresDecimales.length; i++) {
            while (numero >= valoresDecimales[i]) {
                resultado.append(valoresRomanos[i]);
                numero -= valoresDecimales[i];
            }
        }

        return resultado.toString();
    }

}
