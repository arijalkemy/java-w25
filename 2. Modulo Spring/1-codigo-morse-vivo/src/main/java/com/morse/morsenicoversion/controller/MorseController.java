package com.morse.morsenicoversion.controller;

import com.morse.morsenicoversion.service.ICovertible;
import com.morse.morsenicoversion.service.impl.ConvertibleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/converter")
public class MorseController {

    private final ICovertible convertible;

    @Autowired
    public MorseController(ConvertibleImpl convertible) {
        this.convertible = convertible;
    }

    @GetMapping("/morse-text/{morse}")
    public String morseToText(@PathVariable String morse) {
        return convertible.morseToText(morse);
    }

    @GetMapping("/text-morse/{text}")
    public String textToMorse(@PathVariable String text) {
        return convertible.textToMorse(text);
    }
}
