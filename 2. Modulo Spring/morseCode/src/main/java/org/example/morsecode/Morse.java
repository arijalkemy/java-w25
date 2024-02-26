package org.example.morsecode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Morse {
    @GetMapping ("/{codigo}")
    public String traductor(@PathVariable String codigo){
        Map<String, String> dic = new HashMap<>();
        dic.put(".-", "a");
        dic.put("-...", "b");
        dic.put("-.-.","c");
        dic.put("-..","d");
        dic.put(".","e");
        dic.put("..-.","f");
        dic.put("--.","g");
        dic.put("....","h");
        dic.put("..","i");
        dic.put(".---","j");
        dic.put("-.-","k");
        dic.put(".-..","l");
        dic.put("--","m");
        dic.put("-.","n");
        dic.put("---","o");
        dic.put(".--.","p");
        dic.put("--.-","q");
        dic.put(".-.","r");
        dic.put("...","s");
        dic.put("-","t");
        dic.put("..-","u");
        dic.put("...-","v");
        dic.put(".--","w");
        dic.put("-..-","x");
        dic.put("-.--","y");
        dic.put("--..","z");
        dic.put(".----","1");
        dic.put("..---","2");
        dic.put("...--","3");
        dic.put("....-","4");
        dic.put(".....","5");
        dic.put("-....","6");
        dic.put("--...","7");
        dic.put("---..","8");
        dic.put("----.","9");
        dic.put("-----","0");
        dic.put("..--..","?");
        dic.put(".-.-.-",".");
        dic.put("-.-.--","!");
        dic.put("--..--",",");
        String[] l = codigo.split(" ");
        String resp = "";
        for (String i: l){
            if (i.isEmpty()){
                resp += " ";
            }else {
                resp += dic.get(i);
            }
        }
        return resp;
    }
}
