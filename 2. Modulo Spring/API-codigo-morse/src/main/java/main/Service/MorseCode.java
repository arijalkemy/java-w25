package main.Service;

import java.util.HashMap;

public class MorseCode {

    private static final HashMap<Character, String> charToMorse = new HashMap<>();
    private static final HashMap<String, Character> morseToChar = new HashMap<>();

    static {
        // Mapeo de caracteres a código Morse
        charToMorse.put('A', ".-");
        charToMorse.put('B', "-...");
        charToMorse.put('C', "-.-.");
        charToMorse.put('D', "-..");
        charToMorse.put('E', ".");
        charToMorse.put('F', "..-.");
        charToMorse.put('G', "--.");
        charToMorse.put('H', "....");
        charToMorse.put('I', "..");
        charToMorse.put('J', ".---");
        charToMorse.put('K', "-.-");
        charToMorse.put('L', ".-..");
        charToMorse.put('M', "--");
        charToMorse.put('N', "-.");
        charToMorse.put('O', "---");
        charToMorse.put('P', ".--.");
        charToMorse.put('Q', "--.-");
        charToMorse.put('R', ".-.");
        charToMorse.put('S', "...");
        charToMorse.put('T', "-");
        charToMorse.put('U', "..-");
        charToMorse.put('V', "...-");
        charToMorse.put('W', ".--");
        charToMorse.put('X', "-..-");
        charToMorse.put('Y', "-.--");
        charToMorse.put('Z', "--..");
        charToMorse.put('0', "-----");
        charToMorse.put('1', ".----");
        charToMorse.put('2', "..---");
        charToMorse.put('3', "...--");
        charToMorse.put('4', "....-");
        charToMorse.put('5', ".....");
        charToMorse.put('6', "-....");
        charToMorse.put('7', "--...");
        charToMorse.put('8', "---..");
        charToMorse.put('9', "----.");
        charToMorse.put('?', "..--..");
        charToMorse.put('!', "-.-.--");
        charToMorse.put('.', ".-.-.-");
        charToMorse.put(',', "--..--");
        charToMorse.put(' ', "   ");

        // Mapeo de código Morse a caracteres
        for (Character character : charToMorse.keySet()) {
            morseToChar.put(charToMorse.get(character), character);
        }
    }

    public String encode(String text) {
        StringBuilder morseCode = new StringBuilder();
        text = text.toUpperCase(); // Convertimos el texto a mayúsculas para manejarlo consistentemente
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (charToMorse.containsKey(c)) {
                morseCode.append(charToMorse.get(c)).append(" ");
            } else if (c == ' ') {
                morseCode.append(" ");
            } else {
                // Si encontramos un carácter que no tiene un equivalente en código Morse, lo ignoramos
            }
        }
        return morseCode.toString();
    }

    public String decode(String morseCode) {
        StringBuilder text = new StringBuilder();
        String[] words = morseCode.split("   "); // Dividimos el código Morse en palabras
        for (String word : words) {
            String[] letters = word.split(" "); // Dividimos cada palabra en letras
            for (String letter : letters) {
                if (morseToChar.containsKey(letter)) {
                    text.append(morseToChar.get(letter));
                } else {
                    // Si encontramos un código Morse que no tiene un equivalente en caracteres, lo ignoramos
                }
            }
            text.append(" "); // Agregamos un espacio entre palabras
        }
        return text.toString();
    }

}
