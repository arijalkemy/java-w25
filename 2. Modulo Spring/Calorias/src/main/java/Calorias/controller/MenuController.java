package Calorias.controller;

import Calorias.dto.DtoPlato;
import Calorias.service.IPlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private IPlatoService recetasService;

    public MenuController(IPlatoService recetasService) {
        this.recetasService = recetasService;
    }

    @GetMapping("/platoCalorias/{nombre}")
    public ResponseEntity<DtoPlato> caloriasPlato(@PathVariable String nombre){
        return new ResponseEntity<DtoPlato>(recetasService.addDtoPlato(nombre), HttpStatus.OK);
    }
}
