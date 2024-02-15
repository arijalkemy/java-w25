package main.repository;

import java.util.List;

import main.entity.Food;

public interface IFoodRepository {
    public List<Food> getFoodList();
}