package com.example.consigna.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class ControllerConsigna {
    @GetMapping("/morse/{text}")
    public String morseToSpanish(@PathVariable String text) {
        return morseConvert(text);
    }

    @GetMapping("/spanish/{text}")
    public String convertToSpanish(@PathVariable String text) {
        return spanishConvert(text);
    }

    private static final Map<String, String> SPANISH_TO_MORSE = createSpanishToMorseMap();
    private static final Map<String, String> MORSE_TO_SPANISH = createMorseToSpanishMap();

    private static Map<String, String> createSpanishToMorseMap() {
        Map<String, String> map = new HashMap<>();
        // Mapeo de caracteres español a código Morse
        map.put("A", ".-");
        map.put("B", "-...");
        map.put("C", "-.-.");
        map.put("D", "-..");
        map.put("E", ".");
        map.put("F", "..-.");
        map.put("G", "--.");
        map.put("H", "....");
        map.put("I", "..");
        map.put("J", ".---");
        map.put("K", "-.-");
        map.put("L", ".-..");
        map.put("M", "--");
        map.put("N", "-.");
        map.put("O", "---");
        map.put("P", ".--.");
        map.put("Q", "--.-");
        map.put("R", ".-.");
        map.put("S", "...");
        map.put("T", "-");
        map.put("U", "..-");
        map.put("V", "...-");
        map.put("W", ".--");
        map.put("X", "-..-");
        map.put("Y", "-.--");
        map.put("Z", "--..");
        // Agregar el mapeo para los números y otros caracteres especiales según sea necesario
        map.put("1", ".----");
        map.put("2", "..---");
        map.put("3", "...--");
        map.put("4", "....-");
        map.put("5", ".....");
        map.put("6", "-....");
        map.put("7", "--...");
        map.put("8", "---..");
        map.put("9", "----.");
        map.put("0", "-----");
        map.put(".", ".-.-.-");
        map.put(",", "--..--");
        return map;
    }

    private static Map<String, String> createMorseToSpanishMap() {
        Map<String, String> map = new HashMap<>();
        // Mapeo de código Morse a español
        for (Map.Entry<String, String> entry : SPANISH_TO_MORSE.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        return map;
    }

    private String morseConvert(String text) {
        StringBuilder morse = new StringBuilder();
        for (String word : text.toUpperCase().split("\\s+")) {
            for (char c : word.toCharArray()) {
                String morseChar = SPANISH_TO_MORSE.getOrDefault(String.valueOf(c), "");
                if (!morseChar.isEmpty()) {
                    morse.append(morseChar).append(" ");
                }
            }
            morse.append("   "); // Agregar tres espacios entre palabras
        }
        return morse.toString().trim();
    }

    private String spanishConvert(String text) {
        StringBuilder spanish = new StringBuilder();
        String[] morseWords = text.split("\\s{3}"); // Separar palabras en código Morse

        for (String morseWord : morseWords) {
            String[] morseChars = morseWord.split("\\s+"); // Separar caracteres en código Morse
            for (String morseChar : morseChars) {
                if (morseChar.equals("")) { // Verificar si es un espacio en blanco
                    spanish.append(" "); // Agregar espacio entre palabras
                } else {
                    String spanishChar = MORSE_TO_SPANISH.getOrDefault(morseChar, "");
                    if (!spanishChar.isEmpty()) {
                        spanish.append(spanishChar);
                    }
                }
            }
        }

        return spanish.toString().trim();
    }
}
