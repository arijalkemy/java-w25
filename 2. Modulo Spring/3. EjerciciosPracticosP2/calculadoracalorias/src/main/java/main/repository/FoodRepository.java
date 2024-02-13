package main.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.model.Food;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepository {

    private static List<Food> foodList;

    FoodRepository(){
        foodList = getAllFoods();
    }
    private List<Food> getAllFoods (){

        try {
            //byte[] jsonData = Files.readAllBytes(Paths.get("src/food.json"));
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Food>> typeReference = new TypeReference<>(){};
            List<Food> foods = mapper.readValue(new File("src/main/resources/food.json"), typeReference);
            return foods;

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public static Food getByName(String name){
        return foodList.stream().filter((x) -> x.getName().equals(name)).findFirst().orElse(null);
    }
}
