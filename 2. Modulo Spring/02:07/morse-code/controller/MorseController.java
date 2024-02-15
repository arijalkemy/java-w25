package main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MorseController {

    private String[] arrayMorse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
            ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", ".-.-.-",
            "--..--", "..--..", "-.-.--" };
    private String[] arrayAlphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
            "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", ",",
            "?", "!" };

    @GetMapping("/getMorseAlphabet/{morse}")
    public String getMorseAlphabet(@PathVariable String morse) {
        String translation = "";
        String aux = "";
        int spaces = 0;
        for (int i = 0; i < morse.length(); i++) {
            char value = morse.charAt(i);
            if (value == ' ') {
                for (int j = 0; j < this.arrayMorse.length; j++) {
                    if (this.arrayMorse[j].compareTo(aux) == 0) {
                        translation += this.arrayAlphabet[j];
                    }
                }
                spaces++;
                aux = "";
            } else {
                spaces = 0;
                aux += morse.charAt(i);
            }
            if (spaces == 3) {
                translation += " ";
            }
        }
        for (int j = 0; j < this.arrayMorse.length; j++) {
            if (this.arrayMorse[j].compareTo(aux) == 0) {
                translation += this.arrayAlphabet[j];
            }
        }
        return translation;
    }

    @GetMapping("/getAlphabetMorse/{alphabet}")
    public String getAlphabetMorse(@PathVariable String alphabet) {
        String translation = "";

        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == ' ') {
                translation += " ";
            } else {
                for (int j = 0; j < this.arrayAlphabet.length; j++) {
                    if (this.arrayAlphabet[j].compareTo(Character.toString(alphabet.charAt(i)).toUpperCase()) == 0) {
                        translation += this.arrayMorse[j];
                    }
                }
            }
        }
        return translation;
    }

}
