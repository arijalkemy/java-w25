package com.bootcamp.CodigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {
    @GetMapping("/codificar/{palabra}")
    public String codigoMorse(@PathVariable String palabra){
        palabra = palabra.toUpperCase();
        Map<String, String> morseCodeDictionary = new HashMap<>();
        morseCodeDictionary.put("A", ".-");
        morseCodeDictionary.put("B", "-...");
        morseCodeDictionary.put("C", "-.-.");
        morseCodeDictionary.put("D", "-..");
        morseCodeDictionary.put("E", ".");
        morseCodeDictionary.put("F", "..-.");
        morseCodeDictionary.put("G", "--.");
        morseCodeDictionary.put("H", "....");
        morseCodeDictionary.put("I", "..");
        morseCodeDictionary.put("J", ".---");
        morseCodeDictionary.put("K", "-.-");
        morseCodeDictionary.put("L", ".-..");
        morseCodeDictionary.put("M", "--");
        morseCodeDictionary.put("N", "-.");
        morseCodeDictionary.put("O", "---");
        morseCodeDictionary.put("P", ".--.");
        morseCodeDictionary.put("Q", "--.-");
        morseCodeDictionary.put("R", ".-.");
        morseCodeDictionary.put("S", "...");
        morseCodeDictionary.put("T", "-");
        morseCodeDictionary.put("U", "..-");
        morseCodeDictionary.put("V", "...-");
        morseCodeDictionary.put("W", ".--");
        morseCodeDictionary.put("X", "-..-");
        morseCodeDictionary.put("Y", "-.--");
        morseCodeDictionary.put("Z", "--..");
        morseCodeDictionary.put("1", ".----");
        morseCodeDictionary.put("2", "..---");
        morseCodeDictionary.put("3", "...--");
        morseCodeDictionary.put("4", "....-");
        morseCodeDictionary.put("5", ".....");
        morseCodeDictionary.put("6", "-....");
        morseCodeDictionary.put("7", "--...");
        morseCodeDictionary.put("8", "---..");
        morseCodeDictionary.put("9", "----.");
        morseCodeDictionary.put("0", "-----");

        StringBuilder palabraCodificada = new StringBuilder();


        String[] palabras = palabra.split(" ");
        for(String p: palabras){
            String[] letras = p.split("");
            for(String letra: letras){
                palabraCodificada.append(morseCodeDictionary.get(letra.toUpperCase()));
                palabraCodificada.append(" ");
            }
            palabraCodificada.append("   ");
        }
        return  palabraCodificada.toString().trim();
    }

    @GetMapping("/decodificar/{codigoMorse}")
    public String decodificar(@PathVariable String codigoMorse){
        Map<String, Character> morseCodeDictionary = new HashMap<>();
        morseCodeDictionary.put(".-", 'A');
        morseCodeDictionary.put("-...", 'B');
        morseCodeDictionary.put("-.-.", 'C');
        morseCodeDictionary.put("-..", 'D');
        morseCodeDictionary.put(".", 'E');
        morseCodeDictionary.put("..-.", 'F');
        morseCodeDictionary.put("--.", 'G');
        morseCodeDictionary.put("....", 'H');
        morseCodeDictionary.put("..", 'I');
        morseCodeDictionary.put(".---", 'J');
        morseCodeDictionary.put("-.-", 'K');
        morseCodeDictionary.put(".-..", 'L');
        morseCodeDictionary.put("--", 'M');
        morseCodeDictionary.put("-.", 'N');
        morseCodeDictionary.put("---", 'O');
        morseCodeDictionary.put(".--.", 'P');
        morseCodeDictionary.put("--.-", 'Q');
        morseCodeDictionary.put(".-.", 'R');
        morseCodeDictionary.put("...", 'S');
        morseCodeDictionary.put("-", 'T');
        morseCodeDictionary.put("..-", 'U');
        morseCodeDictionary.put("...-", 'V');
        morseCodeDictionary.put(".--", 'W');
        morseCodeDictionary.put("-..-", 'X');
        morseCodeDictionary.put("-.--", 'Y');
        morseCodeDictionary.put("--..", 'Z');
        morseCodeDictionary.put(".----", '1');
        morseCodeDictionary.put("..---", '2');
        morseCodeDictionary.put("...--", '3');
        morseCodeDictionary.put("....-", '4');
        morseCodeDictionary.put(".....", '5');
        morseCodeDictionary.put("-....", '6');
        morseCodeDictionary.put("--...", '7');
        morseCodeDictionary.put("---..", '8');
        morseCodeDictionary.put("----.", '9');
        morseCodeDictionary.put("-----", '0');



        StringBuilder palabra = new StringBuilder();
        String[] palabras = codigoMorse.split(" {3}");
        for(String p: palabras){
            String[] letras = p.split(" ");
            for(String letra: letras){
                palabra.append(morseCodeDictionary.get(letra));
            }
            palabra.append(" ");
        }

        return palabra.toString().trim();
    }
}
