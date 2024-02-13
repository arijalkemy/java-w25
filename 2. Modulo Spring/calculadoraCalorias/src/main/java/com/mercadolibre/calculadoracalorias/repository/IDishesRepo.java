package com.mercadolibre.calculadoracalorias.repository;

import com.mercadolibre.calculadoracalorias.entity.Dish;

import java.util.List;

public interface IDishesRepo {
    Dish getDishByName(String name);
    List<Dish> getAll();
}
