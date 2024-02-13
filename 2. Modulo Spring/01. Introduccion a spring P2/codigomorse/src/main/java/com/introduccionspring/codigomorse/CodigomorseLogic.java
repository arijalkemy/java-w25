package com.introduccionspring.codigomorse;

import java.util.HashMap;
import java.util.Map;

public class CodigomorseLogic {
    private Map<String, String> traducciones = new HashMap<>();

    private Map<String, String> traducciones2 = new HashMap<>();

    public CodigomorseLogic() {
        traducciones.put("A",".-");
        traducciones.put("B","-...");
        traducciones.put("C","-.-.");
        traducciones.put("D","-..");
        traducciones.put("E",".");
        traducciones.put("F","..-.");
        traducciones.put("G","--.");
        traducciones.put("H","....");
        traducciones.put("I","..");
        traducciones.put("J",".---");
        traducciones.put("K","-.-");
        traducciones.put("L",".-..");
        traducciones.put("M","..");
        traducciones.put("N","-.");
        traducciones.put("O","---");
        traducciones.put("P",".--.");
        traducciones.put("Q","--.-");
        traducciones.put("R",".-.");
        traducciones.put("S","...");
        traducciones.put("T","-");
        traducciones.put("U","..-");
        traducciones.put("V","...-");
        traducciones.put("W",".--");
        traducciones.put("X","-..-");
        traducciones.put("Y","-.--");
        traducciones.put("Z","--..");
        traducciones.put("1",".----");
        traducciones.put("2","..---");
        traducciones.put("3","...--");
        traducciones.put("4","....-");
        traducciones.put("5",".....");
        traducciones.put("6","-....");
        traducciones.put("7","--...");
        traducciones.put("8","---..");
        traducciones.put("9","----.");
        traducciones.put("0","-----");
        traducciones.put("?","..--..");
        traducciones.put("!","-.-.--");
        traducciones.put(".",".-.-.-");
        traducciones.put(",","--..--");
        traducciones.put(" ","  ");

        for (Map.Entry<String, String> entry : this.traducciones.entrySet()) {
            traducciones2.put(entry.getValue(), entry.getKey());
        }
        traducciones2.put(""," ");
    }

    public String converterToMorse(String code){
        StringBuilder result = new StringBuilder();
        for (char character: code.toCharArray()) {
            result.append(traducciones.get(String.valueOf(character))).append(" ");
        }
        return result.toString();
    }

    public String converterFromMorse(String code){
        StringBuilder result = new StringBuilder();
        String[] palabras = code.split(" {3}");

        for (String palabra : palabras){
            String[] letras = palabra.split(" ");
            for (String letra : letras){
                result.append(traducciones2.get(letra));
            }
            result.append(" ");
        }
        return result.toString();
    }


}
