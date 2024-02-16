package com.example.MorseDecodificator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")

public class Codificator {
    public void fillHashmap(){
        morseToSpanish.put(".-", "A");
        morseToSpanish.put("-...", "B");
        morseToSpanish.put("-.-.", "C");
        morseToSpanish.put("-..", "D");
        morseToSpanish.put(".", "E");
        morseToSpanish.put("..-.", "F");
        morseToSpanish.put("--.", "G");
        morseToSpanish.put("....", "H");
        morseToSpanish.put("..", "I");
        morseToSpanish.put(".---", "J");
        morseToSpanish.put("-.-", "K");
        morseToSpanish.put(".-..", "L");
        morseToSpanish.put("--", "M");
        morseToSpanish.put("-.", "N");
        morseToSpanish.put("---", "O");
        morseToSpanish.put(".--.", "P");
        morseToSpanish.put("--.-", "Q");
        morseToSpanish.put(".-.", "R");
        morseToSpanish.put("...", "S");
        morseToSpanish.put("-", "T");
        morseToSpanish.put("..-", "U");
        morseToSpanish.put("...-", "V");
        morseToSpanish.put(".--", "W");
        morseToSpanish.put("-..-", "X");
        morseToSpanish.put("--..", "Z");
        
    }
    public HashMap<String,String> morseToSpanish = new HashMap<String,String>();
    @GetMapping("/decodificate/{morse}")
    public String Decodificate(@PathVariable String morse){
        fillHashmap();        
        List<String> MorseWords = List.of(morse.split("   "));
        StringBuilder word_spanish = new StringBuilder();
        for (String word:MorseWords){

            List<String> symbols = List.of(word.split(" "));
            for(String  symbol : symbols){
                word_spanish.append(morseToSpanish.get(symbol));

            }
            word_spanish.append(" ");
        }
        return word_spanish.toString();

    }
    
    
    @GetMapping("/codificate/{text}")
    public String Codificate(@PathVariable String text){
        fillHashmap();
        List<String> MorseWords = List.of(text.split(" "));
        StringBuilder word_spanish = new StringBuilder();
        for (String word:MorseWords){
            List<String> symbols = List.of(word.split(""));
            for(String  symbol : symbols){
                word_spanish.append(morseToSpanish.entrySet()
                        .stream()
                        .filter(entry -> Objects.equals(entry.getValue(), symbol))
                        .map(Map.Entry::getKey).toList().get(0));
}
            word_spanish.append("   ");
        }
        return word_spanish.toString();
    }


}
