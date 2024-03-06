package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloRestContoller {

    @GetMapping("/{morseCode}")
    public String sayHello(@PathVariable String morseCode){
        //Variable a retornar
        String finalWord = "";
        String[] letras = {};
        //datos equivalentes
        Map<String, String> morseParse = new HashMap<>(){{
            put("A",  ".-");
            put("B",  "-...");
            put("C",  "-.-.");
            put("D",  "-..");
            put("E",  ".");
            put("F",  "..-.");
            put("G",  "--.");
            put("H",  "....");
            put("I",  "..");
            put("J",  ".---");
            put("K",  "-.-");
            put("L",  ".-..");
            put("M",  "--");
            put("N",  "-.");
            put("O",  "---");
            put("P",  ".--.");
            put("Q",  "--.-");
            put("R",  ".-.");
            put("S",  "...");
            put("T",  "-");
            put("U",  "..-");
            put("V",  "...-");
            put("W",  ".--");
            put("X",  "-..-");
            put("Y",  "-.--");
            put("Z",  "--..");
            put("1",  ".----");
            put("3",  "...--");
            put("4",  "....-");
            put("5",  ".....");
            put("6",  "-....");
            put("7",  "--...");
            put("8",  "---..");
            put("9",  "----.");
            put("0",  "-----");
            put("?",  "..--..");
            put("!",  "-.-.--");
            put(".",  ".-.-.-");
            put(",",  "--..--");
        }};
        //Obtenemos lista de Palabras
        String[] palabras = morseCode.split("   ");

        //Recorremos las Palabras para obtener cada letra
        for(String palabra : palabras){
            letras = palabra.split(" ");

            //Recorremos las Letras para traducrilas y asignarlo a la palabra final
            for (String letraMorse : letras) {
                for (Map.Entry<String, String> entrada : morseParse.entrySet()) {
                    if (entrada.getValue().equals(letraMorse)) {
                        finalWord += entrada.getKey();
                        break;
                    }
                }
            }
            //Espacio entre palabras
            finalWord += " ";
        }

        //Se retorna la palabra final
        return finalWord;
    }
}
