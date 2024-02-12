package org.example.parsermorse.util;

import java.util.HashMap;
import java.util.Map;

public class Utilidad {

    public static Map<Character, String> cargaMapa(){
        Map<Character, String> morseCodeDictionary = new HashMap<>();
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

        return morseCodeDictionary;
    }

    public static Map<String, Character> mapaMorseATexto(){
        Map< String,Character> morseCodeDictionary = new HashMap<>();
        morseCodeDictionary.put( ".-",'A');
        morseCodeDictionary.put("-...",'B');
        morseCodeDictionary.put("-.-.",'C');
        morseCodeDictionary.put( "-..",'D');
        morseCodeDictionary.put(".",'E');
        morseCodeDictionary.put( "..-.",'F');
        morseCodeDictionary.put("--.",'G');
        morseCodeDictionary.put("....",'H');
        morseCodeDictionary.put( "..",'I');
        morseCodeDictionary.put( ".---",'J');
        morseCodeDictionary.put( "-.-",'K');
        morseCodeDictionary.put( ".-..",'L');
        morseCodeDictionary.put( "--",'M');
        morseCodeDictionary.put( "-.",'N');
        morseCodeDictionary.put( "---",'O');
        morseCodeDictionary.put( ".--.",'P');
        morseCodeDictionary.put( "--.-",'Q');
        morseCodeDictionary.put( ".-.",'R');
        morseCodeDictionary.put( "...",'S');
        morseCodeDictionary.put( "-",'T');
        morseCodeDictionary.put( "..-",'U');
        morseCodeDictionary.put( "...-",'V');
        morseCodeDictionary.put( ".--",'W');
        morseCodeDictionary.put( "-..-",'X');
        morseCodeDictionary.put( "-.--",'Y');
        morseCodeDictionary.put( "--..",'Z');

        return morseCodeDictionary;
    }
}

