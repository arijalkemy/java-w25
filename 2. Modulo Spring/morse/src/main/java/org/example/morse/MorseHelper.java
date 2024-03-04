package org.example.morse;

import java.util.Arrays;
import java.util.HashMap;

public class MorseHelper {
    private static HashMap<String,String> morseTable = new HashMap<>() {{
        put("A", ".-");
        put("B", "-...");
        put("C", "-.-.");
        put("D", "-..");
        put("E", ".");
        put("F", "..-.");
        put("G", "--.");
        put("H", "....");
        put("I", "..");
        put("J", ".---");
        put("K", "-.-");
        put("L", ".-..");
        put("M", "--");
        put("N", "-.");
        put("O", "---");
        put("P", ".--.");
        put("Q", "--.-");
        put("R", ".-.");
        put("S", "...");
        put("T", "-");
        put("U", "..-");
        put("V", "...-");
        put("W", ".--");
        put("X", "-..-");
        put("Y", "-.--");
        put("Z", "--..");
        put("0", "-----");
        put("1", ".----");
        put("2", "..---");
        put("3", "...--");
        put("4", "....-");
        put("5", ".....");
        put("6", "-....");
        put("7", "--...");
        put("8", "---..");
        put("9", "----.");
        put(".", ".-.-.-");
        put(",", "--..--");
        put("?", "..--..");
        put(" ", "+");
        put("!","-.-.--");
        put("/","-..-.");
        put("(","-.--.");
        put(")", "-.--.-");
        put("&",".-...");
        put(":","---...");
        put(";", "-.-.-.");
        put("=","-...-");
        put("+",".-.-.");
        put("-","-....-");
        put("_","..--.-");
        put("'", ".-..-.");
        put("$","...-..-");
        put("@",".--.-.");
    }};

    public static String encode(String message){
        return String.join("", Arrays.stream(message.split("")).
                map(element -> String.format("%s ",MorseHelper.morseTable.get(element.toUpperCase()))).toList());
    }

    public static String decode(String message){
        return String.join("", Arrays.stream(message.split(" ")).map(element ->  {
            for (HashMap.Entry<String, String> entry : morseTable.entrySet())
                if (element.equals(entry.getValue()))
                    return entry.getKey();
            return "";}).toList());
    }
}
