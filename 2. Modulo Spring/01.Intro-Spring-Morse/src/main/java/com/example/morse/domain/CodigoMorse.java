package com.example.morse.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CodigoMorse {
    Map<Character, String> morseCodeDictionary = new HashMap<>();
    Map<String, Character> invertedMorseCodeDictionary = new HashMap<>();

    public CodigoMorse() {
        this.morseCodeDictionary.put('A', ".-");
        this.morseCodeDictionary.put('B', "-...");
        this.morseCodeDictionary.put('C', "-.-.");
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
        morseCodeDictionary.put('0', "-----");
        morseCodeDictionary.put('1', ".----");
        morseCodeDictionary.put('2', "..---");
        morseCodeDictionary.put('3', "...--");
        morseCodeDictionary.put('4', "....-");
        morseCodeDictionary.put('5', ".....");
        morseCodeDictionary.put('6', "-....");
        morseCodeDictionary.put('7', "--...");
        morseCodeDictionary.put('8', "---..");
        morseCodeDictionary.put('9', "----.");
        morseCodeDictionary.put(',', "--..--");
        morseCodeDictionary.put('.', ".-.-.-");
        morseCodeDictionary.put('?', "..--..");
        morseCodeDictionary.put('!', "-.-.--");
        morseCodeDictionary.put(' ', "  ");
        this.invertedMorseCodeDictionary = invertMapUsingStreams(morseCodeDictionary);
    }

    public String decodificarMorse(String morse) {
        StringBuilder frase = new StringBuilder();
        String[] palabrasMorse = morse.split("   ");
        for (String palabra : palabrasMorse) {
            String[] letrasMorse = palabra.toUpperCase().split(" ");
            for (String letra : letrasMorse) {
                frase.append(invertedMorseCodeDictionary.get(letra));
            }
            frase.append(" ");
        }
        return frase.toString();
    }

    public String codificarAMorse(String palabra) {
        StringBuilder morse = new StringBuilder();
        for (char caracter : palabra.toUpperCase().toCharArray()) {
            if (caracter == ' ') {
                morse.append(morseCodeDictionary.get(caracter));
            } else
                morse.append(morseCodeDictionary.get(caracter) + ' ');
        }
        return morse.toString();
    }

    public static <V, K> Map<V, K> invertMapUsingStreams(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

}




