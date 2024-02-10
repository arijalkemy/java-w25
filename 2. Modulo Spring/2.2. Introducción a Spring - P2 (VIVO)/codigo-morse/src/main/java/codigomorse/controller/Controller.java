package codigomorse.controller;

import codigomorse.model.MorseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class Controller {

    @GetMapping("/decode/{morseCode}")
    public String decodeMorseCode(@PathVariable String morseCode) {
        return ("<h1>Código Morse</h1><p><strong>Decodificar: </strong>" + morseCode + "</p><p><strong>Resultado: </strong>" + MorseCode.decode(morseCode) + "</p>");
    }

    @GetMapping("/encode/{text}")
    public String encodeText(@PathVariable String text) {
        return ("<h1>Código Morse</h1><p><strong>Codificar: </strong>" + text + "</p><p><strong>Resultado: </strong>" + MorseCode.encode(text) + "</p>");
    }
}
