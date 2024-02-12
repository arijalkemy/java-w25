package org.example.parsermorse.controller;


import org.example.parsermorse.util.Utilidad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
public class MorseController {

    @GetMapping("/convert-text/{morse}")
    public String convert(@PathVariable String morse) {
        StringBuilder finalWord = new StringBuilder();
        Map<String, Character> map = Utilidad.mapaMorseATexto();

        List<String> words = Arrays.stream(morse.split("   ")).toList();
        for (String word: words){
            List<String> letters = Arrays.stream(word.split(" ")).toList();

            for(String letter: letters){
                finalWord.append(map.get(letter));
            }

            finalWord.append(" ");
        }

        return finalWord.toString();

    }

    @GetMapping("/convert-morse/{text}")
    public String convertToMorse(@PathVariable String text){
        StringBuilder finalMorse = new StringBuilder();
        List<String> words = Arrays.stream(text.split(" ")).toList();
        Map<Character, String> map = Utilidad.cargaMapa();

        for (String word: words){
            char[] letters = word.toCharArray();

            for(char letter: letters){
                finalMorse.append(map.get(letter));
            }

            finalMorse.append(" ");
        }

        return finalMorse.toString();
    }

}

