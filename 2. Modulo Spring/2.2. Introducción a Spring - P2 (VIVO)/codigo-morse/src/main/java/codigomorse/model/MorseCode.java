package codigomorse.model;

import java.lang.reflect.Array;
import java.util.*;

public class MorseCode {
    public static Map<String, Character> morseCodeToChar = new HashMap<>() {{
        put(".-", 'A');
        put("-...", 'B');
        put("-.-.", 'C');
        put("-..", 'D');
        put(".", 'E');
        put("..-.", 'F');
        put("--.", 'G');
        put("....", 'H');
        put("..", 'I');
        put(".---", 'J');
        put("-.-", 'K');
        put(".-..", 'L');
        put("--", 'M');
        put("-.", 'N');
        put("---", 'O');
        put(".--.", 'P');
        put("--.-", 'Q');
        put(".-.", 'R');
        put("...", 'S');
        put("-", 'T');
        put("..-", 'U');
        put("...-", 'V');
        put(".--", 'W');
        put("-..-", 'X');
        put("-.--", 'Y');
        put("--..", 'Z');
    }};
    public static Map<Character, String> charToMorseCode = new HashMap<>() {{
        put('A', ".-");
        put('B', "-...");
        put('C', "-.-.");
        put('D', "-..");
        put('E', ".");
        put('F', "..-.");
        put('G', "--.");
        put('H', "....");
        put('I', "..");
        put('J', ".---");
        put('K', "-.-");
        put('L', ".-..");
        put('M', "--");
        put('N', "-.");
        put('O', "---");
        put('P', ".--.");
        put('Q', "--.-");
        put('R', ".-.");
        put('S', "...");
        put('T', "-");
        put('U', "..-");
        put('V', "...-");
        put('W', ".--");
        put('X', "-..-");
        put('Y', "-.--");
        put('Z', "--..");
        put(' ', "&nbsp;");
    }};

    public static String decode(String morseCode) {
        StringBuilder decodedText = new StringBuilder();
        String[] morseCodeWords = morseCode.split("   ");
        for (String morseCodeWord : morseCodeWords) {
            String[] morseCodeLetters = morseCodeWord.split(" ");
            for (String morseCodeLetter : morseCodeLetters) {
                decodedText.append(morseCodeToChar.get(morseCodeLetter));
            }
            decodedText.append(" ");
        }
        return decodedText.toString();
    }

    public static String encode(String text) {
        StringBuilder encodedMorseCode = new StringBuilder();
        String[] textLetters = text.split("");
        for (String textLetter : textLetters) {
            encodedMorseCode.append(charToMorseCode.get(textLetter.toUpperCase().charAt(0)));
            encodedMorseCode.append(" ");
        }
        return encodedMorseCode.toString().trim();
    }
}
