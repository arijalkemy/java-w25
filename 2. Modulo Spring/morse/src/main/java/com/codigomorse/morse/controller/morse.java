package com.codigomorse.morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController

public class morse {
    public String translator(char morse, String type){
        HashMap<String, Character> morseToAlphabet = new HashMap<>();
        // Mapear los caracteres Morse al alfabeto
        morseToAlphabet.put(".-", 'A');
        morseToAlphabet.put("-...", 'B');
        morseToAlphabet.put("-.-.", 'C');
        morseToAlphabet.put("-..", 'D');
        morseToAlphabet.put(".", 'E');
        morseToAlphabet.put("..-.", 'F');
        morseToAlphabet.put("--.", 'G');
        morseToAlphabet.put("....", 'H');
        morseToAlphabet.put("..", 'I');
        morseToAlphabet.put(".---", 'J');
        morseToAlphabet.put("-.-", 'K');
        morseToAlphabet.put(".-..", 'L');
        morseToAlphabet.put("--", 'M');
        morseToAlphabet.put("-.", 'N');
        morseToAlphabet.put("---", 'O');
        morseToAlphabet.put(".--.", 'P');
        morseToAlphabet.put("--.-", 'Q');
        morseToAlphabet.put(".-.", 'R');
        morseToAlphabet.put("...", 'S');
        morseToAlphabet.put("-", 'T');
        morseToAlphabet.put("..-", 'U');
        morseToAlphabet.put("...-", 'V');
        morseToAlphabet.put(".--", 'W');
        morseToAlphabet.put("-..-", 'X');
        morseToAlphabet.put("-.--", 'Y');
        morseToAlphabet.put("--..", 'Z');
        morseToAlphabet.put(" ", ' ');

        if(type.equals("spanish")){
            char value= morseToAlphabet.getOrDefault(morse, '?');
            return value + "";
        }else{
            String clave = null;
            for (Map.Entry<String, Character> entry : morseToAlphabet.entrySet()) {
                if (entry.getValue().equals(morse)) {
                    clave = entry.getKey();
                    break;
                }
            }
            return clave;
        }


    }

    @GetMapping("/toMorse/{codigo}")
    public String toMorse(@PathVariable String codigo){
        StringBuilder finalLeter = new StringBuilder();
        char[] chars = codigo.toUpperCase().toCharArray();

        for (char ch: chars){
            String value =  translator(ch, "morse");
            finalLeter.append(value);
        }
        return finalLeter.toString();
    }
}
