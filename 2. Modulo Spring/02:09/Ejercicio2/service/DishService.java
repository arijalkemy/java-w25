package main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.FoodDTO;
import main.entity.Dish;
import main.entity.Food;
import main.repository.DishRepository;

@Service
public class DishService implements IDishService {
    @Autowired
    private DishRepository dishRepository;

    // 1
    @Override
    public Integer getTotalCalories(String dish, Integer calories) {
        Integer total = 0;
        for (Dish dishSelected : dishRepository.getDishList()) {
            if (dishSelected.getName().equals(dish)) {
                for (Food food : dishSelected.getFoodList()) {
                    total += food.getCalories();
                }
                break;
            }
        }
        if (total > 0) {
            total = (total * calories) / 100;
            return total;
        }
        return 0;
    }

    // 2
    @Override
    public List<FoodDTO> getFoodList(String dish, Integer calories) {
        List<FoodDTO> foodList = new ArrayList<>();
        for (Dish dishSelected : dishRepository.getDishList()) {
            if (dishSelected.getName().equals(dish)) {
                for (Food foodSelected : dishSelected.getFoodList()) {
                    foodList.add(new FoodDTO(foodSelected, (foodSelected.getCalories() * calories) / 100));
                }
                break;
            }
        }
        return foodList;
    }

    // 3
    @Override
    public FoodDTO getMostCaloricFood(String dish, Integer calories) {
        Food food = new Food();
        Integer caloriesSelected = 0;
        for (Dish dishSelected : dishRepository.getDishList()) {
            if (dishSelected.getName().equals(dish)) {
                for (Food foodSelected : dishSelected.getFoodList()) {
                    if (foodSelected.getCalories() > caloriesSelected) {
                        caloriesSelected = foodSelected.getCalories();
                        food = foodSelected;
                    }
                }
                break;
            }
        }
        return new FoodDTO(food, (caloriesSelected * calories) / 100);
    }
}
