package main.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.entity.Food;

@Repository
public class FoodRepository implements IFoodRepository {

    private List<Food> loadFood() {
        File file = null;
        List<Food> vehicles = new ArrayList<>();
        try {
            file = ResourceUtils.getFile("classpath:food.json");
            ObjectMapper mapperJSON = new ObjectMapper();
            TypeReference<List<Food>> typeRef = new TypeReference<>() {
            };
            vehicles = mapperJSON.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicles;

    }

    @Override
    public List<Food> getFoodList() {
        return this.loadFood();
    }

}
