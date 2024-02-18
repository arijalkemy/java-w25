package org.mercadolibre.codigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static java.util.Map.entry;

@RestController
public class MorseController {
    private Map<String, String> morseMap = Map.ofEntries(
        entry("A", ".-"),
        entry("B", "-..."),
        entry("C", "-.-."),
        entry("D", "-.."),
        entry("E", "."),
        entry("F", "..-."),
        entry("G", "--."),
        entry("H", "...."),
        entry("I", ".."),
        entry("J", ".---"),
        entry("K", "-.-"),
        entry("L", ".-.."),
        entry("M", "--"),
        entry("N", "-."),
        entry("O", "---"),
        entry("P", ".--."),
        entry("Q", "--.-"),
        entry("R", ".-."),
        entry("S", "..."),
        entry("T", "-"),
        entry("U", "..-"),
        entry("V", "...-"),
        entry("W", ".--"),
        entry("X", "-..-"),
        entry("Y", "-.--"),
        entry("Z", "--.."),
        entry("1", ".----"),
        entry("2", "..---"),
        entry("3", "...--"),
        entry("4", "....-"),
        entry("5", "....."),
        entry("6", "-...."),
        entry("7", "--..."),
        entry("8", "---.."),
        entry("9", "----."),
        entry("0", "-----"),
        entry("?", "..--.."),
        entry("!", "-.-.--"),
        entry(".", ".-.-.-"),
        entry(",", "--..--"),
        entry(" ", " ")
    );

    @GetMapping("/morseToText")
    public String morseToText(@RequestParam String code) {
        String[] words = code.trim().split("\\s{3}");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            String[] letters = word.split("\\s");
            for (String letter : letters) {
                for (Map.Entry<String, String> entry : morseMap.entrySet()) {
                    if (Objects.equals(entry.getValue(), letter)) {
                        result.append(entry.getKey());
                        break;
                    }
                }
            }
            result.append(" ");
        }
        return result.toString();
    }

    @GetMapping("/textToMorse")
    public String textToMorse(@RequestParam String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            for (Map.Entry<String, String> entry : morseMap.entrySet()) {
                if (entry.getKey().charAt(0) == text.toUpperCase().charAt(i)) {
                    result.append(entry.getValue());
                    break;
                }
            }
            result.append(" ");
        }
        return result.toString();
    }
}