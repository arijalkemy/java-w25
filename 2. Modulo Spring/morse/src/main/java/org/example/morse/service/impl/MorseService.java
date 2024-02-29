package org.example.morse.service.impl;

import org.example.morse.dto.ResponseDto;
import org.example.morse.service.IMorseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService implements IMorseService {

    private Map<String, String> dict;

    public MorseService(){
        this.loadData();
    }

    @Override
    public ResponseDto convertMorseToWords(String data) {
        StringBuilder letter = new StringBuilder();
        StringBuilder word = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        int contSpaces = 0;
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) != ' '){
                if(contSpaces != 0){
                    word.append(dict.get("M"+letter));
                    if(contSpaces == 1)
                        letter = new StringBuilder();
                    if(contSpaces == 3){
                        sentence.append(word).append(" ");
                        letter = new StringBuilder();
                        word = new StringBuilder();
                    }
                    contSpaces = 0;
                }
                letter.append(data.charAt(i));
            }
            else
                contSpaces++;
        }
        if(!letter.isEmpty())
            word.append(dict.get("M"+letter));
        if(!word.isEmpty())
            sentence.append(word);
        return new ResponseDto(sentence.toString());
    }

    @Override
    public ResponseDto convertWordsToMorse(String data) {
        StringBuilder word = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == ' '){
                sentence.append(word).append("   ");
                word = new StringBuilder();
            }else{
                word.append(dict.get("W"+data.charAt(i)));
                if(data.length() != (i+1))
                    word.append(" ");
            }
        }
        if(!word.isEmpty())
            sentence.append(word);
        return new ResponseDto(sentence.toString());
    }

    public void loadData(){
        dict =  new HashMap<>();
        dict.put("M.-", "A");
        dict.put("M-...", "B");
        dict.put("M-.-.", "C");
        dict.put("M-..", "D");
        dict.put("M.", "E");
        dict.put("M..-.", "F");
        dict.put("M--.", "G");
        dict.put("M....", "H");
        dict.put("M..", "I");
        dict.put("M.---", "J");
        dict.put("M-.-", "K");
        dict.put("M.-..", "L");
        dict.put("M--", "M");
        dict.put("M-.", "N");
        dict.put("M---", "O");
        dict.put("M.--.", "P");
        dict.put("M--.-", "Q");
        dict.put("M.-.", "R");
        dict.put("M...", "S");
        dict.put("M-", "T");
        dict.put("M..-", "U");
        dict.put("M...-", "V");
        dict.put("M.--", "W");
        dict.put("M-..-", "Y");
        dict.put("M-.--", "Y");
        dict.put("M--..", "Z");

        dict.put("WA",".-");
        dict.put("WB","-...");
        dict.put("WC","-.-.");
        dict.put("WD","-..");
        dict.put("WE",".");
        dict.put("WF","..-.");
        dict.put("WG","--.");
        dict.put("WH","....");
        dict.put("WI","..");
        dict.put("WJ",".---");
        dict.put("WK","-.-");
        dict.put("WL",".-..");
        dict.put("WM","--");
        dict.put("WN","-.");
        dict.put("WO","---");
        dict.put("WP",".--.");
        dict.put("WQ","--.-");
        dict.put("WR",".-.");
        dict.put("WS","...");
        dict.put("WT","-");
        dict.put("WU","..-");
        dict.put("WV","...-");
        dict.put("WW", ".--");
        dict.put("WX","-..-");
        dict.put("WY","-.--");
        dict.put("WZ","--..");

    }


}
