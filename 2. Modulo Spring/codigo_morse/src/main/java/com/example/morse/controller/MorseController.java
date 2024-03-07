package com.example.morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;


@RestController

public class MorseController {
    @GetMapping("/decoding/{morse}")
    public String decoding(@PathVariable String morse){
        return traducirAMorse(morse);
    }

    @GetMapping("/encoding/{frase}")
    public String encoding(@PathVariable String frase){
        return traducirDeMorse(frase.toUpperCase());
    }
    //pensar para hacer con substrings
    //pensar para hacer con el espacio en el diccionario
    private String traducirDeMorse(String frase){
        HashMap<Character , String> morseCodeDictionary = new HashMap<>();
        morseCodeDictionary.put('A', ".-");
        morseCodeDictionary.put('B', "-...");
        morseCodeDictionary.put('C', "-.-.");
        morseCodeDictionary.put('D', "-..");
        morseCodeDictionary.put('E', ".");
        morseCodeDictionary.put('F', "..-.");
        morseCodeDictionary.put('G', "--.");
        morseCodeDictionary.put('H', "....");
        morseCodeDictionary.put('I', "..");
        morseCodeDictionary.put('J', ".---");
        morseCodeDictionary.put('K', "-.-");
        morseCodeDictionary.put('L', ".-..");
        morseCodeDictionary.put('M', "--");
        morseCodeDictionary.put('N', "-.");
        morseCodeDictionary.put('O', "---");
        morseCodeDictionary.put('P', ".--.");
        morseCodeDictionary.put('Q', "--.-");
        morseCodeDictionary.put('R', ".-.");
        morseCodeDictionary.put('S', "...");
        morseCodeDictionary.put('T', "-");
        morseCodeDictionary.put('U', "..-");
        morseCodeDictionary.put('V', "...-");
        morseCodeDictionary.put('W', ".--");
        morseCodeDictionary.put('X', "-..-");
        morseCodeDictionary.put('Y', "-.--");
        morseCodeDictionary.put('Z', "--..");

        //morseCodeDictionary.put('%20', " ");

        String[] palabras = frase.split(" ");

        StringBuilder constructor = new StringBuilder();

        for (int i = 0; i < palabras.length ; i++) {
            char[] palabra = palabras[i].toCharArray();
            for(char palabr : palabra){
                constructor.append(morseCodeDictionary.get(palabr));
                constructor.append(" ");
            }
            constructor.append("  ");

        }
        System.out.println(constructor);
        return constructor.toString();
    }

    private String traducirAMorse(String morse){
        HashMap<String , Character> morseCodeMap = new HashMap<>();

        morseCodeMap.put(".-", 'A');
        morseCodeMap.put("-...", 'B');
        morseCodeMap.put("-.-.", 'C');
        morseCodeMap.put("-..", 'D');
        morseCodeMap.put(".", 'E');
        morseCodeMap.put("..-.", 'F');
        morseCodeMap.put("--.", 'G');
        morseCodeMap.put("....", 'H');
        morseCodeMap.put("..", 'I');
        morseCodeMap.put(".---", 'J');
        morseCodeMap.put("-.-", 'K');
        morseCodeMap.put(".-..", 'L');
        morseCodeMap.put("--", 'M');
        morseCodeMap.put("-.", 'N');
        morseCodeMap.put("---", 'O');
        morseCodeMap.put(".--.", 'P');
        morseCodeMap.put("--.-", 'Q');
        morseCodeMap.put(".-.", 'R');
        morseCodeMap.put("...", 'S');
        morseCodeMap.put("-", 'T');
        morseCodeMap.put("...-", 'V');
        morseCodeMap.put(".--", 'W');
        morseCodeMap.put("-..-", 'X');
        morseCodeMap.put("-.--", 'Y');
        morseCodeMap.put("--..", 'Z');

        String[] palabras = morse.split("   ");

        StringBuilder constructor = new StringBuilder();

        for (int i = 0; i < palabras.length ; i++) {
            String[] letra = palabras[i].split(" ");
            for (String letras : letra){
                constructor.append(morseCodeMap.get(letras));
            }
            constructor.append(" ");
        }
        return constructor.toString();
    }
}
