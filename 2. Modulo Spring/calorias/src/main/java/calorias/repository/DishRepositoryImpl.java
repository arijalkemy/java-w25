package calorias.repository;

import calorias.model.Dish;
import calorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@Repository
public class DishRepositoryImpl implements DishRepository{

    private ArrayList<Dish> dishesDatabase;

    public DishRepositoryImpl(){
        this.dishesDatabase = loadDataBase();
    }

    @Override
    public ArrayList<Ingredient> getDishIngredients(String dishName){
        Optional<Dish> ingredients = dishesDatabase.stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(dishName)).findAny();
        ArrayList<Ingredient> result = null;
        if (ingredients.isPresent()){
            result = ingredients.get().getIngredientList();
        }
        return result;
    }

    public ArrayList<Dish> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:made_by_me_dishes.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<Dish>> typeRef = new TypeReference<>() {};
        ArrayList<Dish> dishes = null;
        System.out.println(file);
        try {
            dishes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dishes;
    }
}
