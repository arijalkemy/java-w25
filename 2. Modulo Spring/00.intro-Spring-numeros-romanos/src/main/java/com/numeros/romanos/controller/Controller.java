package com.numeros.romanos.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String sayHello(){
        return "holaaa sea ud bienvenidiriguillo" ;
    }

}
