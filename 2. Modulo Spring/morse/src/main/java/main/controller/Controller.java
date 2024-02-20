package main.controller;

import main.model.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/decode/{code}")
    public String decode(@PathVariable String code) {
        return Morse.decode(code);
    }

    @GetMapping("/encode/{text}")
    public String encode(@PathVariable String text) {
        return Morse.encode(text);
    }
}
