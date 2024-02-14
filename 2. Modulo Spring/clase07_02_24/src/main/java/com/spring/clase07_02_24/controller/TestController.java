package com.spring.clase07_02_24.controller;

import com.spring.clase07_02_24.service.RomanToDecimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    RomanToDecimalService romanToDecimalService;

    @GetMapping("/roman-to-decimal")
    public Integer convertToDecimal(@RequestParam String romanNumber){
        return romanToDecimalService.convertToDecimal(romanNumber);
    }
    @GetMapping("/decimal-to-roman")
    public String convertToRoman(@RequestParam Integer decimalNumber){
        return romanToDecimalService.convertToRoman(decimalNumber);
    }
}
