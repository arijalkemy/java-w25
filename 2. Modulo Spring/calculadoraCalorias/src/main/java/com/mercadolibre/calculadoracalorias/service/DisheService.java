package com.mercadolibre.calculadoracalorias.service;

import com.mercadolibre.calculadoracalorias.dto.DishCaloriesDto;
import com.mercadolibre.calculadoracalorias.entity.Dish;
import com.mercadolibre.calculadoracalorias.entity.Ingredient;
import com.mercadolibre.calculadoracalorias.entity.Portion;
import com.mercadolibre.calculadoracalorias.repository.DishRepoImp;
import com.mercadolibre.calculadoracalorias.repository.IngredientRepoImp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DisheService {

    DishRepoImp dishRepo;
    IngredientRepoImp ingredientRepo;

    public DisheService(DishRepoImp dishRepo, IngredientRepoImp ingredientRepo) {
        this.dishRepo = dishRepo;
        this.ingredientRepo = ingredientRepo;
        loadDishes();
    }

    public List<Dish> getAllDishes(){
        return this.dishRepo.getAll();
    }

    public DishCaloriesDto getCaloreisByDish(String dishName){
        DishCaloriesDto dishCaloriesDto = new DishCaloriesDto();
        dishCaloriesDto.setName(dishName);
        try {
            Dish dish = this.dishRepo.getDishByName(dishName);
            dishCaloriesDto.setCalories(dish.getIngredientsPortion().stream().mapToDouble(d-> d.getQuantitY()* d.getIngredient().getCalories()).sum());
        }
        catch (Exception e){
            dishCaloriesDto.setMessage(e.getMessage());
        }
        return dishCaloriesDto;
    }

    public DishCaloriesDto getDishWhithHigherCalories(){
        DishCaloriesDto dishCaloriesDto = new DishCaloriesDto();
        try {
            Dish dish = this.dishRepo.getDishWhitHighCalories();
            dishCaloriesDto.setName(dish.getName());
            dishCaloriesDto.setCalories(dish.getIngredientsPortion().stream().mapToDouble(d-> d.getQuantitY()* d.getIngredient().getCalories()).sum());
        }
        catch (Exception e){
            dishCaloriesDto.setMessage(e.getMessage());
        }
        return dishCaloriesDto;
    }



    public Dish getDish(String dishName){
        try {
            return this.dishRepo.getDishByName(dishName);
        }
        catch (Exception e){
            Dish emptyDish = new Dish();
            emptyDish.setName(dishName);
            return  emptyDish;
        }
    }

    private void loadDishes(){
        this.dishRepo.addDish( new Dish("Pizza", getIngredientReq()));
        this.dishRepo.addDish( new Dish("Ensalada", getIngredientReq()));
        this.dishRepo.addDish( new Dish("Tamal", getIngredientReq()));
    }

    private List<Portion> getIngredientReq(){
        List<Portion> ingredientsPortion = new ArrayList<>();
        getRandomIngredient(new Random().nextInt(4)+1).stream().forEach(c-> {
            ingredientsPortion.add(new Portion(c,new Random().nextInt(3)+1));
        });
        return ingredientsPortion;
    }
    private List<Ingredient> getRandomIngredient(Integer total){
        return  this.ingredientRepo.gerRandomIngredient(total);
    }


}
