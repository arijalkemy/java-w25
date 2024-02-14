package com.spring.clase07_02_24.ejercicio.service;

import org.springframework.stereotype.Service;

@Service
public class MorceConverterService {
    public String convertToAlphabet(String morseCode){
        StringBuilder result = new StringBuilder();

        // Define el alfabeto en código Morse
        String[] morseAlphabet = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", " "};

        // Define el alfabeto normal correspondiente
        char[] normalAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '};

        // Divide la secuencia en palabras
        String[] words = morseCode.split("   ");

        // Convierte cada palabra en código Morse a su equivalente en el alfabeto normal
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                for (int i = 0; i < morseAlphabet.length; i++) {
                    if (letter.equals(morseAlphabet[i])) {
                        result.append(normalAlphabet[i]);
                        break;
                    }
                }
            }
            result.append(" ");
        }

        return result.toString();
    }
    public String normalToMorse(String normalText) {
        StringBuilder result = new StringBuilder();

        // Define el alfabeto en código Morse
        String[] morseAlphabet = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        // Define el alfabeto normal correspondiente
        char[] normalAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        // Convierte cada letra en el texto normal a su equivalente en código Morse
        for (int i = 0; i < normalText.length(); i++) {
            char letter = normalText.charAt(i);
            for (int j = 0; j < normalAlphabet.length; j++) {
                if (Character.toUpperCase(letter) == normalAlphabet[j]) {
                    result.append(morseAlphabet[j]);
                    result.append(" ");
                    break;
                }
            }
        }

        return result.toString().trim();
    }
}
