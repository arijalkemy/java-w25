package main.controller;

import main.dto.DishRequestDTO;
import main.dto.DishResponseDTO;
import main.model.Dish;
import main.repository.DishRepository;
import main.service.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {

    @Autowired
    DishServiceImpl dishServiceImpl;

    @GetMapping("/getDataByDish")
    public ResponseEntity<DishResponseDTO> getDataByDish(@RequestBody DishRequestDTO dish){

        DishResponseDTO dishResponseDTO = new DishResponseDTO(
                dishServiceImpl.cantidadTotalCalorias(dish),
                dishServiceImpl.ingredientesCalorias(dish),
                dishServiceImpl.comidaCaloriasMaxima(dish));
        return new ResponseEntity<>(dishResponseDTO, HttpStatus.OK);
    }

    @GetMapping("getDataByDish/{name}/{weight}")
    public ResponseEntity<DishResponseDTO> getDataByDish(@PathVariable String name, @PathVariable double weight){
        DishRequestDTO dish = new DishRequestDTO(name, weight);
        DishResponseDTO dishResponseDTO = new DishResponseDTO(
                dishServiceImpl.cantidadTotalCalorias(dish),
                dishServiceImpl.ingredientesCalorias(dish),
                dishServiceImpl.comidaCaloriasMaxima(dish));
        return new ResponseEntity<>(dishResponseDTO, HttpStatus.OK);

    }

    @GetMapping("/getDataByDishes")
    public ResponseEntity<List<DishResponseDTO>> getDataWithDishes(@RequestBody List<DishRequestDTO> dishes){
        List<DishResponseDTO> listDishes = dishes.stream().map(
                dish -> new DishResponseDTO(
                dishServiceImpl.cantidadTotalCalorias(dish),
                dishServiceImpl.ingredientesCalorias(dish),
                dishServiceImpl.comidaCaloriasMaxima(dish))
            ).toList();

        return new ResponseEntity<>(listDishes,HttpStatus.OK);
    }
}
