package main.controller;

import main.dto.DishRequestDTO;
import main.dto.DishResponseDTO;
import main.repository.DishRepository;
import main.service.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    DishServiceImpl dishServiceImpl;

    @PostMapping("/getDataByDish")
    public ResponseEntity<DishResponseDTO> getDataByDish(@RequestBody DishRequestDTO dish){

        dishServiceImpl.loadListDish();
        DishResponseDTO dishResponseDTO = new DishResponseDTO(
                dishServiceImpl.cantidadTotalCalorias(dish),
                dishServiceImpl.ingredientesCalorias(dish),
                dishServiceImpl.comidaCaloriasMaxima(dish));
        return new ResponseEntity<>(dishResponseDTO, HttpStatus.OK);
    }
}
