package com.miprimerproyecto.pruebaspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloRestController {

    //SALA 8
    
    @GetMapping("hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello world, I'm " + name;
    }

    @GetMapping("/decimal/{romanos}")
    public Integer convertirRomanosADecimal(@PathVariable String romanos) {

        HashMap<String, Integer> valor = new HashMap<>();

        valor.put("I", 1);
        valor.put("V", 5);
        valor.put("X", 10);
        valor.put("L", 50);
        valor.put("C", 100);
        valor.put("D", 500);
        valor.put("M", 1000);

        int total = 0;
        int valorDecimal = 0;
        int valorDecimalPrevio = 0;


        for (int i = 0; i < romanos.length(); i++) {

            String caracterRomano = String.valueOf(romanos.charAt(i));

            if (!valor.containsKey(caracterRomano)) {
                throw new IllegalArgumentException("El número romano ingresado es inválido: " + caracterRomano);
            }
            valorDecimal = valor.get(caracterRomano);

            if (valorDecimal > valorDecimalPrevio) {
                total += valorDecimal - valorDecimalPrevio * 2; //valorDecimalPrevio*2 porque previamente ya lo habia sumado
            } else {
                total += valorDecimal;
            }
            valorDecimalPrevio = valorDecimal;
        }

        return total;

    }

    @GetMapping("roman/{decimal}")
    public String romanNumber(@PathVariable Integer decimal) {

        // StringBuilder para construir el número romano
        StringBuilder romanNumber = new StringBuilder();

        // Arrays de números decimales a comparar y sus núm. romanos correspondientes
        int[] numbersToCompare = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // Recorrer el array numbersToCompare (núm. decimales)
        for (int i = 0; i < numbersToCompare.length; i++) {

            // Repetir
            // Si el decimal ingresado es mayor o igual al numero a comparar en el momento...
            // ...agregar romano correspondiente al string...
            // ...y restar núm. a comparar al decimal ingresado.
            for (; decimal >= numbersToCompare[i]; decimal -= numbersToCompare[i]) {
                romanNumber.append(romanNumbers[i]);
            }
        }
        return romanNumber.toString();
    }

    @GetMapping("morse/{codigo}")
    public String morsePalabra(@PathVariable String codigo) {

        StringBuilder palabra = new StringBuilder();

        /*String[] simbolos = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "?",
                "!", ".", ","};

        String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "..--..",
                "-.-.--", ".-.-.-", "--..--",
        };*/

        // Definir el mapa de códigos Morse y símbolos
        Map<String, String> morseMap = new HashMap<>();
        morseMap.put(".-", "A");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        morseMap.put("..-.", "F");
        morseMap.put("--.", "G");
        morseMap.put("....", "H");
        morseMap.put("..", "I");
        morseMap.put(".---", "J");
        morseMap.put("-.-", "K");
        morseMap.put(".-..", "L");
        morseMap.put("--", "M");
        morseMap.put("-.", "N");
        morseMap.put("---", "O");
        morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");
        morseMap.put(".-.", "R");
        morseMap.put("...", "S");
        morseMap.put("-", "T");
        morseMap.put("..-", "U");
        morseMap.put("...-", "V");
        morseMap.put(".--", "W");
        morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");
        morseMap.put("--..", "Z");
        morseMap.put(".----", "1");
        morseMap.put("..---", "2");
        morseMap.put("...--", "3");
        morseMap.put("....-", "4");
        morseMap.put(".....", "5");
        morseMap.put("-....", "6");
        morseMap.put("--...", "7");
        morseMap.put("---..", "8");
        morseMap.put("----.", "9");
        morseMap.put("-----", "0");
        morseMap.put("..--..", "?");
        morseMap.put("-.-.--", "!");
        morseMap.put(".-.-.-", ".");
        morseMap.put("--..--", ",");

        // .... --- .-.. .- HOLA
        // -- . .-. -.-. .- -.. ---   .-.. .. -... .-. . MERCADO LIBRE
        // ... .--. .-. .. -. --. SPRING

        // Dividir el código morse en caracteres, punto de división en espacios (%20)
        String[] palabras = codigo.split("   ");
        // Para cada caracter morse del código
        for (String p : palabras) {

            String[] caracteres = p.split(" ");

            for (String c : caracteres) {

                // Recorrer todos los morseCodes
                /*for (int j = 0; j < morseCodes.length; j++) {

                    // Si el caracter morse es igual al morseCode, agregar símbolo correspondiente al caracter morse
                    if (morseCodes[j].equals(c)) {
                        palabra.append(simbolos[j]);
                        break;
                    }
                }*/

                // Buscar el símbolo correspondiente al código Morse en el mapa
                String simbolo = morseMap.get(c);
                if (simbolo != null) {
                    // Agregar el símbolo al resultado
                    palabra.append(simbolo);
                }
            }

            palabra.append(" ");
        }

        return palabra.toString().trim();
    }

    @GetMapping("palabra/{palabra}")
    public String palabraMorse(@PathVariable String palabra) {

        StringBuilder palabraCreada = new StringBuilder();

        // Definir el mapa de símbolos y códigos Morse
        Map<String, String> palabraMap = new HashMap<>();
        palabraMap.put("A", ".-");
        palabraMap.put("B", "-...");
        palabraMap.put("C", "-.-.");
        palabraMap.put("D", "-..");
        palabraMap.put("E", ".");
        palabraMap.put("F", "..-.");
        palabraMap.put("G", "--.");
        palabraMap.put("H", "....");
        palabraMap.put("I", "..");
        palabraMap.put("J", ".---");
        palabraMap.put("K", "-.-");
        palabraMap.put("L", ".-..");
        palabraMap.put("M", "--");
        palabraMap.put("N", "-.");
        palabraMap.put("O", "---");
        palabraMap.put("P", ".--.");
        palabraMap.put("Q", "--.-");
        palabraMap.put("R", ".-.");
        palabraMap.put("S", "...");
        palabraMap.put("T", "-");
        palabraMap.put("U", "..-");
        palabraMap.put("V", "...-");
        palabraMap.put("W", ".--");
        palabraMap.put("X", "-..-");
        palabraMap.put("Y", "-.--");
        palabraMap.put("Z", "--..");
        palabraMap.put("1", ".----");
        palabraMap.put("2", "..---");
        palabraMap.put("3", "...--");
        palabraMap.put("4", "....-");
        palabraMap.put("5", ".....");
        palabraMap.put("6", "-....");
        palabraMap.put("7", "--...");
        palabraMap.put("8", "---..");
        palabraMap.put("9", "----.");
        palabraMap.put("0", "-----");
        palabraMap.put("?", "..--..");
        palabraMap.put("!", "-.-.--");
        palabraMap.put(".", ".-.-.-");
        palabraMap.put(",", "--..--");

        String[] palabras = palabra.split(" ");
        for (String p : palabras) {

            String[] caracteres = p.split("");
            for (String c : caracteres) {

                String codigoMorse = palabraMap.get(c);
                if (codigoMorse != null) {
                    palabraCreada.append(codigoMorse).append(" ");
                }
            }
            palabraCreada.append("   ");
        }
        return palabraCreada.toString().trim();
    }
}
