package com.bootcamp.HolaSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
    @GetMapping
    public String Hola(){
        return "Hola";
    }
}
