package com.example.elasticDemo.controller;

import com.example.elasticDemo.services.ClothesServiceImpl;
import com.example.elasticDemo.services.IClothesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClothesController {
    private IClothesService service;

    public ClothesController(ClothesServiceImpl clothesService){
        this.service = clothesService;
    }


}
