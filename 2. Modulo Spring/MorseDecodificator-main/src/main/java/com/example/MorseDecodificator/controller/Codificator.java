package com.example.MorseDecodificator.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/morse")
public class Codificator {
    /*
    .... --- .-.. .- HOLA
    -- . .-. -.-. .- -.. --- .-.. .. -... .-. . MERCADO LIBRE
    ... .--. .-. .. -. --. SPRING
    * */
    public HashMap<String,String> morseToSpanish = new HashMap<String,String>(fillHashmap());
    // De código morse a español
    @GetMapping("code/{code}")
    public String decodificate(@PathVariable String code){
        List<String> MorseWords = List.of(code.split("   "));
        StringBuilder word_spanish = new StringBuilder();

        for (String word: MorseWords){
            List<String> symbols = List.of(word.split(" "));
            for(String  symbol: symbols){
                word_spanish.append(morseToSpanish.get(symbol));
            }
            word_spanish.append(" ");
        }
        return word_spanish.toString();
    }
    

    // De español a código morse
    @GetMapping("/letter/{text}")
    public String codificate(@PathVariable String text){
        List<String> MorseWords = List.of(text.toUpperCase().split(" "));
        StringBuilder word_spanish = new StringBuilder();

        for (String word:MorseWords){
            List<String> symbols = List.of(word.split(""));

            for(String  symbol : symbols){
                word_spanish.append(morseToSpanish.entrySet()
                        .stream()
                        .filter(entry -> Objects.equals(entry.getValue(), symbol))
                        .map(Map.Entry::getKey).toList().get(0));
            }
            word_spanish.append("   ");
        }
        return word_spanish.toString();
    }


    public HashMap<String, String> fillHashmap(){
        HashMap<String,String> morseToSpanishLibrary = new HashMap<>();
        morseToSpanishLibrary.put(".-", "A");
        morseToSpanishLibrary.put("-...", "B");
        morseToSpanishLibrary.put("-.-.", "C");
        morseToSpanishLibrary.put("-..", "D");
        morseToSpanishLibrary.put(".", "E");
        morseToSpanishLibrary.put("..-.", "F");
        morseToSpanishLibrary.put("--.", "G");
        morseToSpanishLibrary.put("....", "H");
        morseToSpanishLibrary.put("..", "I");
        morseToSpanishLibrary.put(".---", "J");
        morseToSpanishLibrary.put("-.-", "K");
        morseToSpanishLibrary.put(".-..", "L");
        morseToSpanishLibrary.put("--", "M");
        morseToSpanishLibrary.put("-.", "N");
        morseToSpanishLibrary.put("---", "O");
        morseToSpanishLibrary.put(".--.", "P");
        morseToSpanishLibrary.put("--.-", "Q");
        morseToSpanishLibrary.put(".-.", "R");
        morseToSpanishLibrary.put("...", "S");
        morseToSpanishLibrary.put("-", "T");
        morseToSpanishLibrary.put("..-", "U");
        morseToSpanishLibrary.put("...-", "V");
        morseToSpanishLibrary.put(".--", "W");
        morseToSpanishLibrary.put("-..-", "X");
        morseToSpanishLibrary.put("--..", "Z");
        return morseToSpanishLibrary;
    }
}
