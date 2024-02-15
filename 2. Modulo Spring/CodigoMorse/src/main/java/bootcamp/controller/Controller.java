package bootcamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
.... --- .-.. .- HOLA
-- . .-. -.-. .- -.. --- .-.. .. -... .-. . MERCADO LIBRE
... .--. .-. .. -. --. SPRING
 */
@RestController
public class Controller {
    private Map<Character, String> diccionarioMorse = loadMorse();


    @GetMapping("/decodificar/{codigo}")
    public String decodificar(@PathVariable String codigo){
        return decodeMorse(separarSimbolos(codigo));
    }

    @GetMapping("/codificar/{frase}")
    public String codificar(@PathVariable String frase){
        return encodeMorse(separarLetras(frase.toUpperCase()));
    }


    private String decodeMorse(List<String[]> list){
        StringBuilder str = new StringBuilder();
        for(String[] array : list){
            for (String s : array){
                str.append(getKey(s));
            }
            str.append(" ");
        }
        return str.toString();
    }

    private List<String[]> separarLetras(String frase){
        List<String[]> lista = new ArrayList<>();
        String[] palabras = frase.split(" ");
        for (String s : palabras){
            lista.add(s.split(""));
        }

        return lista;
    }

    private String encodeMorse(List<String[]> lista){
        StringBuilder str = new StringBuilder();
        for (String[] array : lista){
            for (String s : array){
                str.append(this.diccionarioMorse.get(s.charAt(0)));
                str.append(" ");
            }

            str.append("   ");
        }
        return str.toString().toUpperCase().trim();
    }


    private List<String[]> separarSimbolos(String codigo){
        String[] array = codigo.split(" {3}");
        List<String[]> list = new ArrayList<>();
        for(String s : array){
            list.add(s.split(" "));
        }
        return list;
    }



    private Character getKey(String value){
        for (Map.Entry<Character, String> entry : this.diccionarioMorse.entrySet()){
            if(value.equals(entry.getValue())) return entry.getKey();

        }
        return null;
    }

    private Map<Character,String> loadMorse(){
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
}
