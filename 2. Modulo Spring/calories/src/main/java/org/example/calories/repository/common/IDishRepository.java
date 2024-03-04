package org.example.calories.repository.common;

import org.example.calories.entity.Dish;

public interface IDishRepository {
    public Dish getByName(String name);
}
