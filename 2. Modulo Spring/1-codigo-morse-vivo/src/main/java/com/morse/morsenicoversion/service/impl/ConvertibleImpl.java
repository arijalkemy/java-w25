package com.morse.morsenicoversion.service.impl;

import com.morse.morsenicoversion.service.ICovertible;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConvertibleImpl implements ICovertible {

    // 1 espacio -> separa los códigos.
    // 3 espacios -> separar palabras.

    @Override
    public String morseToText(String morseCode) {
        // 1- Separar las palabras -> genera List<String> (lista de palabras).
        // 2- Separar los códigos de cada palabra (letras) -> genera List<String> (codigos/letras).
        // 3- Armar la palabra y devolverla

        StringBuilder finalWord = new StringBuilder();
        Map<String, Character> map = morseToTextMap();

        List<String> words = Arrays.stream(morseCode.split("   ")).toList();
        for (String word : words) {
            List<String> letters = Arrays.stream(word.split(" ")).toList();
            for (String letter : letters) {
                finalWord.append(map.get(letter));
            }
            finalWord.append(" ");
        }

        return finalWord.toString();
    }

    @Override
    public String textToMorse(String text) {
        StringBuilder finalWord = new StringBuilder();
        Map<Character, String> map = textToMorseMap();

        List<String> words = Arrays.stream(text.toUpperCase().split(" ")).toList();
        for (String word : words) {
            char[] letters = word.toCharArray();
            for (char letter : letters) {
                finalWord.append(map.get(letter)).append(" ");
            }
            finalWord.append("  ");
        }

        return finalWord.toString();
    }

    private Map<String, Character> morseToTextMap() {
        Map<String,Character> morseCodeDictionary = new HashMap<>();

        morseCodeDictionary.put( ".-",'A');
        morseCodeDictionary.put("-...",'B');
        morseCodeDictionary.put("-.-.",'C');
        morseCodeDictionary.put( "-..",'D');
        morseCodeDictionary.put(".",'E');
        morseCodeDictionary.put( "..-.",'F');
        morseCodeDictionary.put("--.",'G');
        morseCodeDictionary.put("....",'H');
        morseCodeDictionary.put( "..",'I');
        morseCodeDictionary.put( ".---",'J');
        morseCodeDictionary.put( "-.-",'K');
        morseCodeDictionary.put( ".-..",'L');
        morseCodeDictionary.put( "--",'M');
        morseCodeDictionary.put( "-.",'N');
        morseCodeDictionary.put( "---",'O');
        morseCodeDictionary.put( ".--.",'P');
        morseCodeDictionary.put( "--.-",'Q');
        morseCodeDictionary.put( ".-.",'R');
        morseCodeDictionary.put( "...",'S');
        morseCodeDictionary.put( "-",'T');
        morseCodeDictionary.put( "..-",'U');
        morseCodeDictionary.put( "...-",'V');
        morseCodeDictionary.put( ".--",'W');
        morseCodeDictionary.put( "-..-",'X');
        morseCodeDictionary.put( "-.--",'Y');
        morseCodeDictionary.put( "--..",'Z');

        return morseCodeDictionary;
    }


    private Map<Character, String> textToMorseMap() {
        Map<Character, String> morseCodeDictionary = new HashMap<>();

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

        return morseCodeDictionary;
    }
}
