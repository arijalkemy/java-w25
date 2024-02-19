package main.service;

import main.dto.DishRequestDTO;
import main.dto.DishResponseDTO;
import main.dto.FoodResponseDTO;
import main.model.Dish;
import main.model.Food;
import main.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DishServiceImpl implements IDishService {


    @Autowired
    DishRepository dishRepository;

    @Override
    public double cantidadTotalCalorias(DishRequestDTO dish) {
        Dish selectDish = dishRepository.getByName((dish.getName()));
        if (!selectDish.equals(null)) {
            return selectDish.getFoods().stream()
                    .map(food -> Double.parseDouble(food.getCalories()) / 100)
                    .reduce(0.0, Double::sum) * dish.getWeight();
        } else {
            return 0;
        }
    }

    @Override
    public FoodResponseDTO comidaCaloriasMaxima(DishRequestDTO dish) {
        String name = dish.getName();
        Food maxFood = dishRepository.getByName(name).getFoods().stream().max(Comparator.comparing(Food::getCalories)).orElse(null);
        return new FoodResponseDTO(maxFood.getName(), String.valueOf(Double.parseDouble(maxFood.getCalories()) * (dish.getWeight() / 100)));
    }

    public List<FoodResponseDTO> ingredientesCalorias(DishRequestDTO dish){
        Dish dishFound = dishRepository.getByName(dish.getName());
        return dishFound.getFoods().stream().map(f -> new FoodResponseDTO(f.getName(), String.valueOf(Double.parseDouble(f.getCalories()) * (dish.getWeight()/100)))).toList();
    }
}
