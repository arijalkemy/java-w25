package com.example.calorias.repository;

import com.example.calorias.entity.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Data
public class DishRepositoryImp {
    private List<Dish> dishes;

    public DishRepositoryImp() {
        this.dishes = loadDishes();
    }


    private List<Dish> loadDishes(){


    }

    public List<Dish> findAll(){

        return this.dishes;
    }

    public String getName(){
        return
    }
}


