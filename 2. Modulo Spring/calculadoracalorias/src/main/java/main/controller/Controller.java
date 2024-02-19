package main.controller;

import main.dto.DishRequestDTO;
import main.dto.DishResponseDTO;
import main.repository.DishRepository;
import main.service.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    DishServiceImpl dishServiceImpl;

    @GetMapping("/getDataByDish/{name}/{weight}")
    public ResponseEntity<DishResponseDTO> getDataByDish(@PathVariable String name, @PathVariable String weight){
        DishRequestDTO dish = new DishRequestDTO(name,  Double.parseDouble(weight));
        DishResponseDTO dishResponseDTO = new DishResponseDTO(
                dishServiceImpl.cantidadTotalCalorias(dish),
                dishServiceImpl.ingredientesCalorias(dish),
                dishServiceImpl.comidaCaloriasMaxima(dish));
        return new ResponseEntity<>(dishResponseDTO, HttpStatus.OK);
    }
}
