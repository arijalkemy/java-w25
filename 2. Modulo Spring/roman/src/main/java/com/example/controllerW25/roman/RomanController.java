package com.example.controllerW25.roman;

import org.springframework.web.bind.annotation.*;

@RestController
public class RomanController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello World! "+name;
    }
    @GetMapping("/convert-integer-to-roman")
    public String convertIntToRoman(@RequestParam int integer) {
        return RomanNumber.toRoman(integer);
    }
}
