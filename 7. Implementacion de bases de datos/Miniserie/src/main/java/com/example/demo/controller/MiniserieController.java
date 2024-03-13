package com.example.demo.controller;

import com.example.demo.service.MiniserieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiniserieController {

    MiniserieService miniserieService;

    MiniserieController(MiniserieService miniserieService) {
        this.miniserieService = miniserieService;
    }

    @PostMapping("/save")
    public String agregarMiniserie(
            @RequestBody MiniserieDTO miniserieDTO
    ) {
        return miniserieService.agregarMiniserie(miniserieDTO);
    }

}
