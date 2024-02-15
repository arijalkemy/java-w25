package bootcamp.service;

import bootcamp.dto.FoodDTO;
import bootcamp.entity.Food;

import java.util.List;

public interface IFoodService {

    public List<FoodDTO> findAll();
    public FoodDTO findFoodByName(String name) throws Exception;
}
