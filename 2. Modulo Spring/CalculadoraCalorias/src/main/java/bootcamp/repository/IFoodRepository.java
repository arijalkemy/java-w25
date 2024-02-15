package bootcamp.repository;

import bootcamp.entity.Food;

import java.util.List;

public interface IFoodRepository {
    public List<Food> loadFood();
}
