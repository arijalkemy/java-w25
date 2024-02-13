package com.mercadolibre.calculadoracalorias.repository;

import com.mercadolibre.calculadoracalorias.entity.Dish;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DishRepoImp implements  IDishesRepo{

    private List<Dish> dishList;

    public DishRepoImp(){
        this.dishList = new ArrayList<>();
    }

    public void addDish(Dish dish){
        this.dishList.add(dish);
    }

    @Override
    public Dish getDishByName(String name) {
        Optional<Dish> dish= this.dishList.stream().filter(d -> d.getName().equalsIgnoreCase(name)).findFirst();
        if (dish.isPresent())
            return  dish.get();
        else
            throw new RuntimeException("Dish no founded");

    }

    public Dish getDishWhitHighCalories() {
        Optional<Dish> dish= this.dishList.stream().sorted((a,b)-> (int) (getTotalCalories(b)-getTotalCalories(a) ) ).limit(dishList.size()-1).findFirst();
        if (dish.isPresent())
            return  dish.get();
        else
            throw new RuntimeException("Dish no founded");
    }


    @Override
    public List<Dish> getAll() {
        return this.dishList;
    }

    private double getTotalCalories(Dish dish){
        return dish.getIngredientsPortion().stream().mapToDouble(i-> i.getQuantitY()* i.getIngredient().getCalories()).sum();
    }


}
