package main.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.model.Food;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepository {

    private final List<Food> foodList;

    public FoodRepository() {
        foodList = this.getAllFoods();
    }

    private List<Food> getAllFoods (){

            //byte[] jsonData = Files.readAllBytes(Paths.get("src/food.json"));
            File file = null;
            try {
                file = ResourceUtils.getFile("classpath:food.json");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<Food>> typeRef = new TypeReference<>() {};
            List<Food> food = null;
            try {
                food = objectMapper.readValue(file, typeRef);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return food;

    }

    public Food getByName(String name){
        return foodList.stream().filter((x) -> x.getName().equals(name)).findFirst().orElse(null);
    }
}
