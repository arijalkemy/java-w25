package main.Controller;

import main.Service.MorseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class codecontroller {

    @GetMapping ("/encode/{palabra}")
    public String devolverMorse(@PathVariable String palabra){
        MorseCode code = new MorseCode();
        return "Texto original: " + palabra + "\nTraduccion en morse: " + code.encode(palabra);
    }

    @GetMapping("/decode/{morse}")
    public String devolverEspanol(@PathVariable String morse){
        MorseCode code = new MorseCode();
        return "Texto original: " + morse + "\nTraduccion en español: " + code.decode(morse);
    }

}
