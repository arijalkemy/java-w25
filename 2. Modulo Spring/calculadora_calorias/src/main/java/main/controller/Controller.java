package main.controller;

import main.dto.DishRequestDTO;
import main.dto.DishResponseDTO;
import main.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    IDishService dishService;

    @GetMapping("/getDataByDish")
    public ResponseEntity<DishResponseDTO> getDataByDish(@RequestBody DishRequestDTO dish) throws Exception {
        DishResponseDTO dishResponseDTO = new DishResponseDTO(
                dishService.cantidadTotalCalorias(dish),
                dishService.ingredientesCalorias(dish),
                dishService.comidaCaloriasMaxima(dish));
        return new ResponseEntity<>(dishResponseDTO, HttpStatus.OK);
    }
}
