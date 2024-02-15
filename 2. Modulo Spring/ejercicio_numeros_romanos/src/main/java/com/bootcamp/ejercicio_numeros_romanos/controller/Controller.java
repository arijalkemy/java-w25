package com.bootcamp.ejercicio_numeros_romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/convert/{num}")
    public String convert(@PathVariable int num){
        if (num < 1 || num > 3999)
            return "El número ingresado se puede representar en números romanos :(";

        String res = convertir(num);
        return "La representación en números romanos es: " + res;
    }

    @GetMapping()
    public String home(){
        return "Agrega en la URL '/convert/numero' para convertir un número decimal a romano!";
    }


    private String convertir (int numero){
        /* Creo las tablas con los valores */
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] miles = {"", "M", "MM", "MMM"};

        /* Transformo el número decimal recibido a número romano */
        int mil, cen, dec, uni;

        mil = numero / 1000;
        numero = numero % 1000;
        cen = numero / 100;
        numero = numero % 100;
        dec = numero / 10;
        numero = numero % 10;
        uni = numero;

        /* Concateno la respuesta */
        return miles[mil] + centenas[cen] + decenas[dec] + unidades[uni];
    }

}
