package com.example.BootcampW25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@RestController
public class Controller{

    @GetMapping("/calculateDate/{day}/{month}/{year}")
    public String calculateDate(@PathVariable int day, @PathVariable int month, @PathVariable int year) {

        if (day < 1 || day > 31) {
            return "Invalid day";
        }
        if (month < 1 || month > 12) {
            return "Invalid month";
        }
        if (year < 1900 || year > 2024) {
            return "Invalid year";
        }

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);


        return age.getYears() + " ";
    }



    @GetMapping("/getRoman/{number}")
    public String getRoman(@PathVariable Integer number) {
        System.out.println("numero:" + number);
        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbersToCompare.length; i++)
            for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);

        return romanNumber.toString();
    }

    @GetMapping("/getMorse/{code}")
    public String getMorse(@PathVariable String code){
        return getMorseCodeToAlphabet(code);
    }

    public String getMorseCodeToAlphabet(String code){
        HashMap<String, Character> morseCode = getStringCharacterHashMap();

        StringBuilder codeMorseToAlphabet = new StringBuilder();

        String[] mensaje = code.split(" {3}");
        if (mensaje.length == 0){
            return "";
        }

        for (int i = 0; i < mensaje.length; i++) {

            String palabra = mensaje[i];
            if (palabra.isEmpty()){
                continue;
            }
            String[] caracteres = palabra.split(" ");
            for(String car : caracteres){
                codeMorseToAlphabet.append(morseCode.get(car));
            }
            if (i != mensaje.length - 1)
                codeMorseToAlphabet.append(" ");
        }

//        if (mensaje.length == 1){
//            for(String letra : code.split(" ")){
//                System.out.println("awa" + letra + morseCode.get(letra));
//                codeMorseToAlphabet.append(morseCode.get(letra));
//            }
//        } else {
//            for (String palabra : mensaje){
//                for(String letra : palabra.split(" ")){
//                    codeMorseToAlphabet.append(morseCode.get(letra));
//                }
//                codeMorseToAlphabet.append(" ");
//            }
//        }

        return codeMorseToAlphabet.toString();
    }

    private static HashMap<String, Character> getStringCharacterHashMap() {
        HashMap<String, Character> morseCode = new HashMap<>();

        morseCode.put(".-", 'A');
        morseCode.put("-...", 'B');
        morseCode.put("-.-.", 'C');
        morseCode.put("-..", 'D');
        morseCode.put(".", 'E');
        morseCode.put("..-.", 'F');
        morseCode.put("--.", 'G');
        morseCode.put("....", 'H');
        morseCode.put("..", 'I');
        morseCode.put(".---", 'J');
        morseCode.put("-.-", 'K');
        morseCode.put(".-..", 'L');
        morseCode.put("--", 'M');
        morseCode.put("-.", 'N');
        morseCode.put("---", 'O');
        morseCode.put(".--.", 'P');
        morseCode.put("--.-", 'Q');
        morseCode.put(".-.", 'R');
        morseCode.put("...", 'S');
        morseCode.put("-", 'T');
        morseCode.put("..-", 'U');
        morseCode.put("...-", 'V');
        morseCode.put(".--", 'W');
        morseCode.put("-..-", 'X');
        morseCode.put("-.--", 'Y');
        morseCode.put("--..", 'Z');

        morseCode.put(".----", '1');
        morseCode.put("..---", '2');
        morseCode.put("...--", '3');
        morseCode.put("....-", '4');
        morseCode.put(".....", '5');
        morseCode.put("-....", '6');
        morseCode.put("--...", '7');
        morseCode.put("---..", '8');
        morseCode.put("----.", '9');
        morseCode.put("-----", '0');

        morseCode.put("..--..", '?');
        morseCode.put(".-.-.--", '!');
        morseCode.put(".-.-.-", '.');
        morseCode.put("--..--", ',');
        return morseCode;
    }
}