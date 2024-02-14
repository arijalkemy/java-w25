package main.repository;

import java.util.List;

import main.entity.Dish;

public interface IDishRepository {
    public List<Dish> getDishList();
}
