package main.service;

import main.dto.DishRequestDTO;
import main.dto.FoodResponseDTO;
import main.model.Dish;
import main.model.Food;
import main.repository.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DishServiceImpl implements IDishService {

    @Autowired
    IDishRepository dishRepository;

    @Override
    public double cantidadTotalCalorias(DishRequestDTO dish) throws Exception {
        Dish selectDish = dishRepository.getDishByName((dish.getName()));
        if (selectDish != null) {
            return selectDish.getFoods().stream()
                    .map(food -> food.getCalories() / 100)
                    .reduce(0.0, Double::sum) * dish.getWeight();
        } else {
            throw new Exception("No se encontro el plato ingresado");
        }
    }

    @Override
    public FoodResponseDTO comidaCaloriasMaxima(DishRequestDTO dish) {
        String name = dish.getName();
        Food maxFood = dishRepository.getDishByName(name).getFoods().stream().max(Comparator.comparing(Food::getCalories)).orElse(null);
        return new FoodResponseDTO(maxFood.getName(), maxFood.getCalories() * (dish.getWeight() / 100));
    }

    public List<FoodResponseDTO> ingredientesCalorias(DishRequestDTO dish){
        Dish dishFound = dishRepository.getDishByName(dish.getName());
        return dishFound.getFoods().stream().map(f -> new FoodResponseDTO(f.getName(), f.getCalories() * (dish.getWeight()/100))).toList();
    }
}
