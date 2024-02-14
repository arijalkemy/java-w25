package com.introSpring.codigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("convert/")
public class Controller {

    @GetMapping("/morse/{phrase}")
    public String getMorsePhrase(@PathVariable String phrase){

        return "";
    }
}
