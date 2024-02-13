package org.morsecode.model;

import java.util.*;

public final class Morse {

    private static final Map<Character, String> morseCodeDictionary = new HashMap<>();
    private static final Map<String, Character> morseDecodeDictionary = new HashMap<>();

    // Private constructor to prevent instantiation
    private Morse() {};
    // Static block for initialization when the class is loaded
    static {
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
        morseCodeDictionary.put('1', ".----");
        morseCodeDictionary.put('2', "..---");
        morseCodeDictionary.put('3', "...--");
        morseCodeDictionary.put('4', "....-");
        morseCodeDictionary.put('5', ".....");
        morseCodeDictionary.put('6', "-....");
        morseCodeDictionary.put('7', "--...");
        morseCodeDictionary.put('8', "---..");
        morseCodeDictionary.put('9', "----.");
        morseCodeDictionary.put('0', "-----");
        morseCodeDictionary.put('?', "..--..");
        morseCodeDictionary.put('!', "-.-.--");
        morseCodeDictionary.put('.', ".-.-.-");
        morseCodeDictionary.put(',', "--..--");
        morseCodeDictionary.put(' ', "   ");

        for(Map.Entry<Character, String> entry: morseCodeDictionary.entrySet()){
            morseDecodeDictionary.put(entry.getValue(), entry.getKey());
        }
    }

    public static String encode(String text){
        StringBuilder sb = new StringBuilder();
        text = text.toUpperCase();
        for(int i = 0; i < text.length(); i++){
            String coded = morseCodeDictionary.get(text.charAt(i));
            sb.append(coded);
            if(coded.equals(" ")){
                continue;
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String decode(String code){
        StringBuilder sb = new StringBuilder();
        String[] words = code.split("   "); // ".--   .--. ..-" -> [".--", ".--. ..-"]

        for(String word : words) {
            String[] codeLetras = word.split(" "); //".-- .--. ..-" -> [".--", ".--.", "..-"]
            Arrays.stream(codeLetras)
                    .map(morseDecodeDictionary::get)
                    .forEach(sb::append);
            sb.append(" ");
        }

        return sb.toString();
    }
}
