package com.introduccionspring.codigomorse.controller;

import com.introduccionspring.codigomorse.CodigomorseLogic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class CodigomorseController {
    private CodigomorseLogic codigomorseLogic = new CodigomorseLogic();

    @GetMapping("/tomorse/{code}")
    public String converterToMorse(@PathVariable("code") String code){
        return codigomorseLogic.converterToMorse(code.toUpperCase());
    }

    @GetMapping("/frommorse/{code}")
    public String converterFromMorse(@PathVariable("code") String code){
        return codigomorseLogic.converterFromMorse(code);
    }
}
