package main.service;

import main.dto.DishRequestDTO;
import main.dto.FoodResponseDTO;
import main.model.Food;

import java.util.List;

public interface IDishService {

    double cantidadTotalCalorias(DishRequestDTO dish) throws Exception;

    List<FoodResponseDTO> ingredientesCalorias(DishRequestDTO dish);

    FoodResponseDTO comidaCaloriasMaxima(DishRequestDTO dish);
}
