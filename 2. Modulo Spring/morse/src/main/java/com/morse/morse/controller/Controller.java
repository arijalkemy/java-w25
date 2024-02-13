package com.morse.morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class Controller {
    @GetMapping("{mensaje}")
    public String getMessage(String mensaje) {
        return "asd";
    }
}
