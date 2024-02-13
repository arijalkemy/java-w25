package com.mercadolibre.demow25.service;

import com.mercadolibre.demow25.dto.Morsedto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService {

    Map<Character, String> morseCode = new HashMap<>();

    public MorseService(){
        morseCode.put('a',".-");
        morseCode.put('b',"-...");
        morseCode.put('c',"-.-.");
        morseCode.put('d',"-..");
        morseCode.put('e',".");
        morseCode.put('f',"..-.");
        morseCode.put('g',"--.");
        morseCode.put('h',"....");
        morseCode.put('i',"..");
        morseCode.put('j',".---");
        morseCode.put('k',"-.-");
        morseCode.put('l',".-..");
        morseCode.put('m',"--");
        morseCode.put('n',"-.");
        morseCode.put('o',"---");
        morseCode.put('p',".--.");
        morseCode.put('q',"--.-");
        morseCode.put('r',".-.");
        morseCode.put('s',"..." );
        morseCode.put('t',"-");
        morseCode.put('u',"..-");
        morseCode.put('v',"...-");
        morseCode.put('w',".--");
        morseCode.put('x',"-..-");
        morseCode.put('y',"-.--");
        morseCode.put('z',"--..");
        morseCode.put('1',".----");
        morseCode.put('2',"..---");
        morseCode.put('3',"...--");
        morseCode.put('4',"....-");
        morseCode.put('5',".....");
        morseCode.put('6',"-....");
        morseCode.put('7',"--...");
        morseCode.put('8',"---..");
        morseCode.put('9',"----.");
        morseCode.put('0',"-----");
        morseCode.put('?',"..--..");
        morseCode.put('!',"-.-.--");
        morseCode.put('.',".-.-.-");
        morseCode.put(',',"--..--");
    }

    public Morsedto decodeEntry(String entry){
        String [] morseWords = entry.split("   ");

        var decodedWords = Arrays.stream(morseWords).map(x -> {
            String[] morseLetters = x.split(" ");
            String decodedWord= "";

            for(String letter: morseLetters){
                decodedWord+=decodeLetter(letter);
            }
            return  decodedWord;
        }).toList();

        String decodedPhrase="";
        for(String word : decodedWords){
            decodedPhrase+= " " + word;
        }

        return new Morsedto(entry, decodedPhrase.trim());
    }

    private String decodeLetter(String letter){
        if (this.morseCode.containsValue(letter))
            return  String.valueOf(this.morseCode.entrySet().stream().filter(entry -> entry.getValue().equalsIgnoreCase(letter)).map(Map.Entry::getKey).findFirst().orElse('@'));
        else
            return "@";
    }

    public Morsedto encodeEntry(String entry){
        String[] words = entry.split(" ");

        var morseWords = Arrays.stream(words).map(w -> {
            String morseWord= "";
            for (char c: w.toCharArray()){
                morseWord+= " "+ this.morseCode.get(c);
            }
            return  morseWord.trim();
        }).toList();

        String morsePhrase="";
        for(String morseWord : morseWords){
            morsePhrase+= "   " + morseWord;
        }

        return new Morsedto(morsePhrase.trim(), entry);
    }


}
