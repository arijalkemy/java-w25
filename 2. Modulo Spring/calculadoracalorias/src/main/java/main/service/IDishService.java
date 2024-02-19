package main.service;

import main.dto.DishRequestDTO;
import main.dto.FoodResponseDTO;
import main.model.Food;

import java.util.List;

public interface IDishService {


    public double cantidadTotalCalorias(DishRequestDTO dish);

    public List<FoodResponseDTO> ingredientesCalorias(DishRequestDTO dish);

    public FoodResponseDTO comidaCaloriasMaxima(DishRequestDTO dish);


}
