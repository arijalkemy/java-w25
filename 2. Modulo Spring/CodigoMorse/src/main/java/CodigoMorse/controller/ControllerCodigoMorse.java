package CodigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ControllerCodigoMorse {

    @GetMapping("/codificar/{mensaje}")
    public StringBuilder codificar(@PathVariable String mensaje) {
        Map<Character, String> morseCode = generateCodificator();
        StringBuilder result = new StringBuilder();
        mensaje = mensaje.toUpperCase();
        for(int i=0;i<mensaje.length();i++){
            char character = mensaje.charAt(i);
            if(character == ' '){
                result.append("   ");
            }else{
                result.append(morseCode.get(character));
                result.append(" ");
            }
        }
        return result;
    }

    @GetMapping("/decodificar/{mensaje}")
    public StringBuilder decodificar(@PathVariable String mensaje) {
        Map<String, Character> morseCode = generateDecodificator();
        StringBuilder result = new StringBuilder();
        List<String> palabras = Arrays.asList(mensaje.split("   "));
        for(int i=0;i<palabras.size();i++){
            List<String> caracteres = Arrays.asList(palabras.get(i).strip().split(" "));
            for(int j=0;j<caracteres.size();j++){
                System.out.println(caracteres.get(j));
                result.append(morseCode.get(caracteres.get(j)));
            }
            result.append(" ");
        }
        if(result.toString().strip().equals("null")){
            result.replace(0, result.length(), "No se pudo decodificar el mensaje.");
        }
        return result;
    }



    private Map<Character, String> generateCodificator(){
        Map<Character, String> morseCode = new HashMap<>();
        morseCode.put('A', ".-");
        morseCode.put('B', "-...");
        morseCode.put('C', "-.-.");
        morseCode.put('D', "-..");
        morseCode.put('E', ".");
        morseCode.put('F', "..-.");
        morseCode.put('G', "--.");
        morseCode.put('H', "....");
        morseCode.put('I', "..");
        morseCode.put('J', ".---");
        morseCode.put('K', "-.-");
        morseCode.put('L', ".-..");
        morseCode.put('L', ".-..");
        morseCode.put('M', "--");
        morseCode.put('N', "-.");
        morseCode.put('O', "---");
        morseCode.put('P', ".--.");
        morseCode.put('Q', "--.-");
        morseCode.put('R', ".-.");
        morseCode.put('S', "...");
        morseCode.put('T', "-");
        morseCode.put('U', "..-");
        morseCode.put('V', "...-");
        morseCode.put('W', ".--");
        morseCode.put('X', "-..-");
        morseCode.put('Y', "-.--");
        morseCode.put('Z', "--..");
        return morseCode;
    }

    private Map<String, Character> generateDecodificator(){
        Map<String, Character> morseCode = new HashMap<>();
        morseCode.put(   ".-", 'A');
        morseCode.put( "-...", 'B');
        morseCode.put( "-.-.", 'C');
        morseCode.put(  "-..", 'D');
        morseCode.put(    ".", 'E');
        morseCode.put( "..-.", 'F');
        morseCode.put(  "--.", 'G');
        morseCode.put( "....", 'H');
        morseCode.put(   "..", 'I');
        morseCode.put( ".---", 'J');
        morseCode.put(  "-.-", 'K');
        morseCode.put( ".-..", 'L');
        morseCode.put( ".-..", 'L');
        morseCode.put(   "--", 'M');
        morseCode.put(   "-.", 'N');
        morseCode.put(  "---", 'O');
        morseCode.put( ".--.", 'P');
        morseCode.put( "--.-", 'Q');
        morseCode.put(  ".-.", 'R');
        morseCode.put(  "...", 'S');
        morseCode.put(    "-", 'T');
        morseCode.put(  "..-", 'U');
        morseCode.put( "...-", 'V');
        morseCode.put(  ".--", 'W');
        morseCode.put( "-..-", 'X');
        morseCode.put( "-.--", 'Y');
        morseCode.put( "--..", 'Z');
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
