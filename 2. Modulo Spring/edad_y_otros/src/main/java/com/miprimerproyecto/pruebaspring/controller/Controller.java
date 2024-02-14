package com.miprimerproyecto.pruebaspring.controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
public class Controller {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/sayGoodbye")
    public String sayGoodbye() {
        return "Goodbye, World!";
    }

    @GetMapping("/sayHello/{name}")
    public String sayHelloToName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/sayHello/{name}/{lastName}")
    public String sayHelloToName(@PathVariable String name, @PathVariable String lastName) {
        return "Hello, " + name + " " + lastName + "!";
    }

    // Endpoint para convertir números romanos a decimales
    @GetMapping("/decimal/{romanos}")
    public Integer convertirRomanosADecimal(@PathVariable String romanos) {
        HashMap<String, Integer> valor = new HashMap<>();

        valor.put("I", 1);
        valor.put("V", 5);
        valor.put("X", 10);
        valor.put("L", 50);
        valor.put("C", 100);
        valor.put("D", 500);
        valor.put("M", 1000);

        int total = 0;
        int valorDecimal = 0;
        int valorDecimalPrevio = 0;


        for (int i = 0; i < romanos.length(); i++) {

            String caracterRomano = String.valueOf(romanos.charAt(i));

            if (!valor.containsKey(caracterRomano)) {
                throw new IllegalArgumentException("El número romano ingresado es inválido: " + caracterRomano);
            }
            valorDecimal = valor.get(caracterRomano);

            if (valorDecimal > valorDecimalPrevio) {
                total += valorDecimal - valorDecimalPrevio * 2; //valorDecimalPrevio*2 porque previamente ya lo habia sumado
            } else {
                total += valorDecimal;
            }
            valorDecimalPrevio = valorDecimal;
        }

        return total;

    }

    @GetMapping("/romano/{numero}")
    public String convertirDecimalARomanos(@PathVariable Integer numero){

         int[] VALORES_DECIMALES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
         String[] SIMBOLOS_ROMANOS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder resultado = new StringBuilder();

        int indice = 0;

        while (numero > 0) {
            while (numero >= VALORES_DECIMALES[indice]) {
                resultado.append(SIMBOLOS_ROMANOS[indice]);
                numero -= VALORES_DECIMALES[indice];
            }

            indice++;
        }
        return resultado.toString();
    }

    @GetMapping("/morse/{codigo}")
    public String morseCode(@PathVariable String codigo) {

        StringBuilder palabra = new StringBuilder();

        String[] simbolos = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "?",
                "!", ".", ","};

        String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "..--..",
                "-.-.--", ".-.-.-", "--..--",
        };

        String[] palabras = codigo.split("   ");
        // Para cada caracter morse del código
        for (String p : palabras) {

            String[] caracteres = p.split(" ");

            for (String c : caracteres) {
                // Recorrer todos los morseCodes
                for (int j = 0; j < morseCodes.length; j++) {

                    // Si el caracter morse es igual al morseCode, agregar símbolo correspondiente al caracter morse
                    if (morseCodes[j].equals(c)) {
                        palabra.append(simbolos[j]);
                        break;
                    }
                }
            }

            palabra.append(" ");
        }

        return palabra.toString().trim();
    }
}
