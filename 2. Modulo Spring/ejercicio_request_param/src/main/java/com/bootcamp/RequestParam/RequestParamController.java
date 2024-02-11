package com.bootcamp.RequestParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {
    @GetMapping
    public String oneParam(@RequestParam String name){
        return name;
    }
    @GetMapping("/two") //si o si tiene que ser otro path
    public String twoParams(@RequestParam String name, @RequestParam String lastname){
        return "hola" + name + lastname;

    }
}
