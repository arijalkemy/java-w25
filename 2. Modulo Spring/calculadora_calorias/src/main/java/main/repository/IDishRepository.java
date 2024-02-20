package main.repository;

import main.model.Dish;

import java.util.List;

public interface IDishRepository {
    Dish getDishByName(String name);
}
