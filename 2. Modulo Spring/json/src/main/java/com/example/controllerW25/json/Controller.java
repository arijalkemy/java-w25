package com.example.controllerW25.json;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @GetMapping("/homer")
    public Dad homer() {
        return new Dad("Homer", "Simpson", List.of("Bart", "Lisa", "Maggie"), 40, true);
    }

}
