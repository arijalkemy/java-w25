package org.bootcamp.morsecode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/romano/{number}")
    public String convertToRoman(@PathVariable int number) {
        return convert(number);
    }

    @GetMapping("/morse/{text}")
    public String convertToMorse(@PathVariable String text) {
        return morseConvert(text);
    }

    @GetMapping("/spanish/{text}")
    public String convertToSpanish(@PathVariable String text) {
        return spanishConvert(text);
    }

    private static final Map<String, String> SPANISH_TO_MORSE = createSpanishToMorseMap();
    private static final Map<String, String> MORSE_TO_SPANISH = createMorseToSpanishMap();

    private static Map<String, String> createSpanishToMorseMap() {
        Map<String, String> map = new HashMap<>();
        // Mapeo de caracteres español a código Morse
        map.put("A", ".-");
        map.put("B", "-...");
        map.put("C", "-.-.");
        map.put("D", "-..");
        map.put("E", ".");
        map.put("F", "..-.");
        map.put("G", "--.");
        map.put("H", "....");
        map.put("I", "..");
        map.put("J", ".---");
        map.put("K", "-.-");
        map.put("L", ".-..");
        map.put("M", "--");
        map.put("N", "-.");
        map.put("O", "---");
        map.put("P", ".--.");
        map.put("Q", "--.-");
        map.put("R", ".-.");
        map.put("S", "...");
        map.put("T", "-");
        map.put("U", "..-");
        map.put("V", "...-");
        map.put("W", ".--");
        map.put("X", "-..-");
        map.put("Y", "-.--");
        map.put("Z", "--..");
        // Agregar el mapeo para los números y otros caracteres especiales según sea necesario
        map.put("1", ".----");
        map.put("2", "..---");
        map.put("3", "...--");
        map.put("4", "....-");
        map.put("5", ".....");
        map.put("6", "-....");
        map.put("7", "--...");
        map.put("8", "---..");
        map.put("9", "----.");
        map.put("0", "-----");
        map.put(".", ".-.-.-");
        map.put(",", "--..--");
        return map;
    }

    private static Map<String, String> createMorseToSpanishMap() {
        Map<String, String> map = new HashMap<>();
        // Mapeo de código Morse a español
        for (Map.Entry<String, String> entry : SPANISH_TO_MORSE.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        return map;
    }

    private String convert(int number) {
        int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        int i = 0;
        while (number > 0) {
            while (number >= decimalValues[i]) {
                number -= decimalValues[i];
                roman.append(romanSymbols[i]);
            }
            i++;
        }

        return roman.toString();
    }

    private String morseConvert(String text) {
        StringBuilder morse = new StringBuilder();
        String[] letras = text.split(" ");
        for (int i=0,j=i+1; i<letras.length;i++,j++){
            if(letras[i].isEmpty() && letras[j].isEmpty()){
                morse.append(SPANISH_TO_MORSE.get("   "));
                i=j;
                j++;
            }
            else morse.append(SPANISH_TO_MORSE.get(letras[i]));

        }
        return morse.toString();
    }

    private String spanishConvert(String text) {
        StringBuilder spanish = new StringBuilder();
        for (String morseWord : text.split("   ")) {
            for (String morseLetter : morseWord.split(" ")) {
                spanish.append(MORSE_TO_SPANISH.getOrDefault(morseLetter, ""));
            }
            spanish.append(" ");
        }
        return spanish.toString().trim();
    }
}