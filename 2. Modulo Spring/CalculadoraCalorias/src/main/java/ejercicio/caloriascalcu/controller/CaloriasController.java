package ejercicio.caloriascalcu.controller;

import ejercicio.caloriascalcu.dto.PlatoDTO;
import ejercicio.caloriascalcu.entity.Plato;
import ejercicio.caloriascalcu.services.IPlatoServices;
import ejercicio.caloriascalcu.services.IngredienteServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CaloriasController {

    @Autowired
    IPlatoServices platoServices;

    @GetMapping("/getCalorias/{plato}")
    public ResponseEntity<?> getCalorias(@PathVariable String plato) {

        Double caloriasPlatoBuscado = this.platoServices.getPlatoCalorias(plato);

        return ResponseEntity.ok().body(new PlatoDTO(plato, caloriasPlatoBuscado));
    }




}
