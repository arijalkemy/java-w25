package com.bootcamp.codigomorse.model;

import java.util.HashMap;
import java.util.Map;

public class CodigoMorse {
        private static final Map<Character, String> morseCodeMap = new HashMap<>();
        private static final Map<String, Character> reverseMorseCodeMap = new HashMap<>();

        static {
            morseCodeMap.put('A', ".-");
            morseCodeMap.put('B', "-...");
            morseCodeMap.put('C', "-.-.");
            morseCodeMap.put('D', "-..");
            morseCodeMap.put('E', ".");
            morseCodeMap.put('F', "..-.");
            morseCodeMap.put('G', "--.");
            morseCodeMap.put('H', "....");
            morseCodeMap.put('I', "..");
            morseCodeMap.put('J', ".---");
            morseCodeMap.put('K', "-.-");
            morseCodeMap.put('L', ".-..");
            morseCodeMap.put('M', "--");
            morseCodeMap.put('N', "-.");
            morseCodeMap.put('O', "---");
            morseCodeMap.put('P', ".--.");
            morseCodeMap.put('Q', "--.-");
            morseCodeMap.put('R', ".-.");
            morseCodeMap.put('S', "...");
            morseCodeMap.put('T', "-");
            morseCodeMap.put('U', "..-");
            morseCodeMap.put('V', "...-");
            morseCodeMap.put('W', ".--");
            morseCodeMap.put('X', "-..-");
            morseCodeMap.put('Y', "-.--");
            morseCodeMap.put('Z', "--..");
            morseCodeMap.put('?', "..--..");
            morseCodeMap.put('!', "-.-.--");
            morseCodeMap.put('.', ".-.-.-");
            morseCodeMap.put(',', "--..--");

            for (Map.Entry<Character, String> entry : morseCodeMap.entrySet()) {
                reverseMorseCodeMap.put(entry.getValue(), entry.getKey());
            }
        }

        public static String convertToMorseCode(String text) {
            text = text.toUpperCase();
            StringBuilder morseCode = new StringBuilder();
            for (char c : text.toCharArray()) {
                if (morseCodeMap.containsKey(c)) {
                    morseCode.append(morseCodeMap.get(c)).append(" ");
                } else {
                    morseCode.append(c).append(" ");
                }
            }
            return morseCode.toString().trim();
        }

        public static String convertFromMorseCode(String morseCode) {
            StringBuilder text = new StringBuilder();
            String[] words = morseCode.split(" / ");
            for (String word : words) {
                String[] letters = word.split(" ");
                for (String letter : letters) {
                    if (reverseMorseCodeMap.containsKey(letter)) {
                        text.append(reverseMorseCodeMap.get(letter));
                    } else {
                        text.append(letter);
                    }
                }
                text.append(" ");
            }
            return text.toString().trim();
        }
    }
