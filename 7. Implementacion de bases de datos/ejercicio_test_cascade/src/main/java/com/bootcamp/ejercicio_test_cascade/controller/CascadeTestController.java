package com.bootcamp.ejercicio_test_cascade.controller;

import com.bootcamp.ejercicio_test_cascade.service.IServiceCascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CascadeTestController {
    @Autowired
    IServiceCascade serviceCascade;

    @PostMapping("/setup")
    public void setup() {
        serviceCascade.SetupDesdePropietario();
    }

}
