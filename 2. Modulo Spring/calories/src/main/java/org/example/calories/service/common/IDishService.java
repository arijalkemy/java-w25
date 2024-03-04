package org.example.calories.service.common;

import org.example.calories.dto.dish.DishDTO;

public interface IDishService {

    public DishDTO getByNameAndWeight(String name, int wight);


}
