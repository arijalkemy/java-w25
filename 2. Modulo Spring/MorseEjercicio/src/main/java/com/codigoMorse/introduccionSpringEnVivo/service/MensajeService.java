package com.codigoMorse.introduccionSpringEnVivo.service;

import java.util.HashMap;

public class MensajeService {

    public static String codificar(String mensaje){
        HashMap<String, String> spanishToMorseMap = new HashMap<>();
        spanishToMorseMap.put("A", ".-");
        spanishToMorseMap.put("B", "-...");
        spanishToMorseMap.put("C", "-.-.");
        spanishToMorseMap.put("D", "-..");
        spanishToMorseMap.put("E", ".");
        spanishToMorseMap.put("F", "..-.");
        spanishToMorseMap.put("G", "--.");
        spanishToMorseMap.put("H", "....");
        spanishToMorseMap.put("I", "..");
        spanishToMorseMap.put("J", ".---");
        spanishToMorseMap.put("K", "-.-");
        spanishToMorseMap.put("L", ".-..");
        spanishToMorseMap.put("M", "--");
        spanishToMorseMap.put("N", "-.");
        spanishToMorseMap.put("O", "---");
        spanishToMorseMap.put("P", ".--.");
        spanishToMorseMap.put("Q", "--.-");
        spanishToMorseMap.put("R", ".-.");
        spanishToMorseMap.put("S", "...");
        spanishToMorseMap.put("T", "-");
        spanishToMorseMap.put("U", "..-");
        spanishToMorseMap.put("V", "...-");
        spanishToMorseMap.put("W", ".--");
        spanishToMorseMap.put("X", "-..-");
        spanishToMorseMap.put("Y", "-.--");
        spanishToMorseMap.put("Z", "--..");
        spanishToMorseMap.put(" ", "/"); // Usamos '/' para separar las palabras en código Morse

        // Convertir el mensaje español a mayúsculas y dividirlo en letras individuales
        String[] spanishLetters = mensaje.toUpperCase().split("");

        StringBuilder morseMessage = new StringBuilder();

        // Traducir cada letra española a su equivalente en código morse
        for (String spanishLetter : spanishLetters) {
            if (spanishToMorseMap.containsKey(spanishLetter)) {
                morseMessage.append(spanishToMorseMap.get(spanishLetter)).append(" "); // Agregamos un espacio entre cada letra en código Morse
            } else {
                // Si no reconocemos la letra, la dejamos sin traducir
                morseMessage.append(spanishLetter);
            }
        }

        return morseMessage.toString().trim();
    }
    public static String decodificar(String mensaje){
        // Mapeo de letras en código morse a letras en español
        HashMap<String, String> morseToSpanishMap = new HashMap<>();
        morseToSpanishMap.put(".-", "A");
        morseToSpanishMap.put("-...", "B");
        morseToSpanishMap.put("-.-.", "C");
        morseToSpanishMap.put("-..", "D");
        morseToSpanishMap.put(".", "E");
        morseToSpanishMap.put("..-.", "F");
        morseToSpanishMap.put("--.", "G");
        morseToSpanishMap.put("....", "H");
        morseToSpanishMap.put("..", "I");
        morseToSpanishMap.put(".---", "J");
        morseToSpanishMap.put("-.-", "K");
        morseToSpanishMap.put(".-..", "L");
        morseToSpanishMap.put("--", "M");
        morseToSpanishMap.put("-.", "N");
        morseToSpanishMap.put("---", "O");
        morseToSpanishMap.put(".--.", "P");
        morseToSpanishMap.put("--.-", "Q");
        morseToSpanishMap.put(".-.", "R");
        morseToSpanishMap.put("...", "S");
        morseToSpanishMap.put("-", "T");
        morseToSpanishMap.put("..-", "U");
        morseToSpanishMap.put("...-", "V");
        morseToSpanishMap.put(".--", "W");
        morseToSpanishMap.put("-..-", "X");
        morseToSpanishMap.put("-.--", "Y");
        morseToSpanishMap.put("--..", "Z");
        morseToSpanishMap.put(" ", " "); // Agregamos un mapeo directo para el espacio

        // Dividir el mensaje morse en letras individuales
        String[] morseWords = mensaje.split(" ");
        StringBuilder translatedMessage = new StringBuilder();

        // Traducir cada letra morse a su equivalente en español
        for (String morseWord : morseWords) {
            if (morseToSpanishMap.containsKey(morseWord)) {
                translatedMessage.append(morseToSpanishMap.get(morseWord));
            } else {
                // Si no reconocemos el código morse, lo dejamos como está (podría ser un número o símbolo)
                translatedMessage.append(morseWord);
            }
        }

        return translatedMessage.toString();
    }
}
