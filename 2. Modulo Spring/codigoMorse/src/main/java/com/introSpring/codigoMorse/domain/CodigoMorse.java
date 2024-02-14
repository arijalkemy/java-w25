package com.introSpring.codigoMorse.domain;

import java.util.HashMap;
import java.util.Map;

public class CodigoMorse {
    Map<String, String> morseCodeDictionary = new HashMap<>();

    public CodigoMorse() {
        // Agregar las traducciones del abecedario
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

        // Agregar las traducciones de los números
        morseCodeDictionary.put("0", "-----");
        morseCodeDictionary.put("1", ".----");
        morseCodeDictionary.put("2", "..---");
        morseCodeDictionary.put("3", "...--");
        morseCodeDictionary.put("4", "....-");
        morseCodeDictionary.put("5", ".....");
        morseCodeDictionary.put("6", "-....");
        morseCodeDictionary.put("7", "--...");
        morseCodeDictionary.put("8", "---..");
        morseCodeDictionary.put("9", "----.");

        // Agregar las traducciones de los signos de puntuación
        morseCodeDictionary.put(",", "--..--");
        morseCodeDictionary.put(".", ".-.-.-");
        morseCodeDictionary.put("?", "..--..");
        morseCodeDictionary.put("!", "-.-.--");
    }

    public String decodificarMorse(String morse) {
        String[] morseList = morse.split("   ");
        for (String palabra : morseList) {
            for (int i = 0; i < palabra.length(); i++) {
                //this.morseCodeDictionary.get
            }
        }
        return "";
    }

    public String codificarMorse(String frase){
        String[] palabras = frase.split(" ");
        for(String car:palabras){
            
            for (int i = 0; i < ; i++) {

            }
        }
    }

}
