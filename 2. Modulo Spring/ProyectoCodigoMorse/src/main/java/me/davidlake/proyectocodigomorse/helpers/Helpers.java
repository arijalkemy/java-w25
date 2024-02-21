package me.davidlake.proyectocodigomorse.helpers;

import java.util.HashMap;
import java.util.Map;

public class Helpers {
    private final static HashMap<Character,String> toMorseDictionary = new HashMap<>() {{
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
        put('0', "-----");
        put('1', ".----");
        put('2', "..---");
        put('3', "...--");
        put('4', "....-");
        put('5', ".....");
        put('6', "-....");
        put('7', "--...");
        put('8', "---..");
        put('9', "----.");
    }};

    private  final static HashMap<String,Character> fromMorseDictionary = new HashMap<>() {{
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
        put("-----", '0');
        put(".----", '1');
        put("..---", '2');
        put("...--", '3');
        put("....-", '4');
        put(".....", '5');
        put("-....", '6');
        put("--...", '7');
        put("---..", '8');
        put("----.", '9');
    }};

    public static String encriptMessage(String message) {
        var output = new StringBuilder();
        String[] words = message.split(" ");
        for (String word : words) {
            for (char character : word.toCharArray()) {
                output.append(toMorseDictionary.getOrDefault(character, ""));
                output.append(" ");
            }

            output.deleteCharAt(output.length() - 1);
            output.append(" / ");
        }

        return output.toString().trim();
    }

    public static String decriptMessage(String message){
        return getString(message);
    }

    private static String getString(String message) {
        StringBuilder output = new StringBuilder();
        String[] words = message.split(" {3}");
        for(String word : words) {
            String[] symbols = word.split(" ");
            for(String symbol : symbols) {
                output.append(((Map<String, Character>) Helpers.fromMorseDictionary).get(symbol));
            }

            output.append(" ");
        }

        return output.toString().trim();
    }
}
