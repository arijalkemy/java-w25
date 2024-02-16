package bootcamp.introaspringp2vivo.service;

import bootcamp.introaspringp2vivo.exception.NotValidMorseCodeException;
import bootcamp.introaspringp2vivo.exception.NotValidTextException;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class MorseServiceImp implements IMorseService {

    Map<String, Character> morseCodeDictionary = new HashMap<>()
    {{
        put(".-", 'A');
        put("-...", 'B');
        put("-.-.", 'C');
        put("-..", 'D');
        put(".", 'E');
        put("..-.", 'F');
        put("--.", 'G');
        put("....", 'H');
        put("..", 'I');
        put(".---", 'J');
        put("-.-", 'K');
        put(".-..", 'L');
        put("--", 'M');
        put("-.", 'N');
        put("---", 'O');
        put(".--.", 'P');
        put("--.-", 'Q');
        put(".-.", 'R');
        put("...", 'S');
        put("-", 'T');
        put("..-", 'U');
        put("...-", 'V');
        put(".--", 'W');
        put("-..-", 'X');
        put("-.--", 'Y');
        put("--..", 'Z');
    }};

    Map<Character, String> textDictionary = new HashMap<>()
    {{
        put('A', ".-");
        put('B', "-...");
        put('C', "-.-.");
        put('D', "-..");
        put('E', ".");
        put('F', "..-.");
        put('G', "--.");
        put('H', "....");
        put('I', "..");
        put('J', ".---");
        put('K', "-.-");
        put('L', ".-..");
        put('M', "--");
        put('N', "-.");
        put('O', "---");
        put('P', ".--.");
        put('Q', "--.-");
        put('R', ".-.");
        put('S', "...");
        put('T', "-");
        put('U', "..-");
        put('V', "...-");
        put('W', ".--");
        put('X', "-..-");
        put('Y', "-.--");
        put('Z', "--..");
    }};

    @Override
    public String getTranslation(String morseCode) throws NotValidMorseCodeException {
        List<String> wordsInMorse = Arrays.stream(morseCode.split(" {3}")).toList();
        StringBuilder translation = new StringBuilder();
        for (int i = 0; i < wordsInMorse.size(); i++) {
            String wordInMorse = wordsInMorse.get(i);
            List<String> lettersInMorse = Arrays.stream(wordInMorse.split(" ")).toList();
            for (String letterInMorse : lettersInMorse) {
                if (morseCodeDictionary.containsKey(letterInMorse)) translation = new StringBuilder(translation.toString().concat(morseCodeDictionary.get(letterInMorse).toString()));
                else throw new NotValidMorseCodeException(morseCode);
            }
            if (i < wordsInMorse.size() -1) translation.append(" ");
        }
        return translation.toString();
    }

    @Override
    public String getEncryption(String text) throws NotValidTextException {
        List<String> words = Arrays.stream(text.split(" ")).toList();
        StringBuilder encryption = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            char[] word = words.get(i).toCharArray();
            for (int j = 0; j < word.length; j++) {
                Character letter = word[j];
                if (textDictionary.containsKey(letter)) encryption = new StringBuilder(encryption.toString().concat(textDictionary.get(letter)));
                else throw new NotValidTextException(text);
                if (j < word.length -1) encryption.append(" ");
            }
            if (i < words.size() -1) encryption.append("   ");
        }
        return encryption.toString();
    }

}
