package com.spring.clase07_02_24.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RomanToDecimalService {
    public Integer convertToDecimal(String romanNumber){
        HashMap<Character, Integer> mapaValores = new HashMap<>();
        mapaValores.put('I', 1);
        mapaValores.put('V', 5);
        mapaValores.put('X', 10);
        mapaValores.put('L', 50);
        mapaValores.put('C', 100);
        mapaValores.put('D', 500);
        mapaValores.put('M', 1000);

        int numero = 0;
        int valorAnterior = 0;

        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            char caracter = romanNumber.charAt(i);
            int valor = mapaValores.get(caracter);

            if (valor >= valorAnterior) {
                numero += valor;
            } else {
                numero -= valor;
            }

            valorAnterior = valor;
        }

        return numero;
    }
    public String convertToRoman(int numero) {
        LinkedHashMap<Integer, String> mapaValores = new LinkedHashMap<>();
        mapaValores.put(1000, "M");
        mapaValores.put(900, "CM");
        mapaValores.put(500, "D");
        mapaValores.put(400, "CD");
        mapaValores.put(100, "C");
        mapaValores.put(90, "XC");
        mapaValores.put(50, "L");
        mapaValores.put(40, "XL");
        mapaValores.put(10, "X");
        mapaValores.put(9, "IX");
        mapaValores.put(5, "V");
        mapaValores.put(4, "IV");
        mapaValores.put(1, "I");

        StringBuilder resultado = new StringBuilder();

        for (Map.Entry<Integer, String> entry : mapaValores.entrySet()) {
            int valor = entry.getKey();
            String letra = entry.getValue();

            while (numero >= valor) {
                resultado.append(letra);
                numero -= valor;
            }
        }

        return resultado.toString();
    }
}
