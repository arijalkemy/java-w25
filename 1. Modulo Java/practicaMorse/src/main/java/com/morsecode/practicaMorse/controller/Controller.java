package com.morsecode.practicaMorse.controller;

import com.morsecode.practicaMorse.model.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/decode/{code}")
    public String decode(String code) {
        return Morse.decode(code);
    }

    @GetMapping("/encode/{text}")
    public String encode(String text) {
        return Morse.encode(text);
    }

}
