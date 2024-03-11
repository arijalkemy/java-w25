package com.miniseries.miniseries.controller;

import com.miniseries.miniseries.DTO.MiniserieDTO;
import com.miniseries.miniseries.service.MiniserieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiniserieController {
    @Autowired
    MiniserieService miniserieService;

    @PostMapping("/save")
    public String agregarMiniserie(@RequestBody MiniserieDTO miniserieDTO){
        return miniserieService.agregarminiserie(miniserieDTO);
    }

}
