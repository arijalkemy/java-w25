package org.calculadoracalorias.controller;

import org.calculadoracalorias.entity.Ingrediente;
import org.calculadoracalorias.entity.Plato;
import org.calculadoracalorias.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    MenuService menuService;

    @GetMapping("/getIngredientes")
    public List<Ingrediente> getIngredientes() {
        return menuService.getAllIngredientes();
    }

    @PostMapping("/receta")
    public List<Ingrediente> getReceta(@RequestBody Plato p) {
        menuService.getReceta(p);

    }
}
