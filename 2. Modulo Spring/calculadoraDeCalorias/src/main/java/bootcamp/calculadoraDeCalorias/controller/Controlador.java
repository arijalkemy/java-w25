package bootcamp.calculadoraDeCalorias.controller;

import bootcamp.calculadoraDeCalorias.dto.IngredienteDTO;
import bootcamp.calculadoraDeCalorias.entity.Ingrediente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
    @GetMapping ("/masCalorias/{nombre}/{gramos}")
    public ResponseEntity<IngredienteDTO> masCalorias(@PathVariable String nombre,
                                                      @PathVariable double gramos){
        return new ResponseEntity<IngredienteDTO>(new IngredienteDTO(), HttpStatus.OK);

    }
}
