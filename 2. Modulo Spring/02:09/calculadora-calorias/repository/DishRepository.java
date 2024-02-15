package main.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import main.entity.Dish;
import main.entity.Food;

@Repository
public class DishRepository implements IDishRepository {
    private List<Dish> dishList;
    private FoodRepository foodRepository;

    public DishRepository() {
        this.foodRepository = new FoodRepository();
        List<Food> pizza = new ArrayList<>(
                List.of(foodRepository.getFoodList().get(1), foodRepository.getFoodList().get(42),
                        foodRepository.getFoodList().get(114), foodRepository.getFoodList().get(228)));
        List<Food> noodles = new ArrayList<>(
                List.of(foodRepository.getFoodList().get(303),
                        foodRepository.getFoodList().get(105), foodRepository.getFoodList().get(228)));
        dishList = new ArrayList<>(List.of(new Dish(pizza, "pizza"), new Dish(noodles, "noodles")));
    }

    @Override
    public List<Dish> getDishList() {
        return this.dishList;
    }

}
