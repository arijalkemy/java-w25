package main.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.model.Food;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepository {

    private  List<Food> foodList = new ArrayList<>();

    public FoodRepository() {
        getAllFoods();
    }

    private void getAllFoods (){

        try {
            //byte[] jsonData = Files.readAllBytes(Paths.get("src/food.json"));
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Food>> typeReference = new TypeReference<>(){};
            this.foodList = mapper.readValue(new File("src/main/resources/food.json"), typeReference);

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public Food getByName(String name){
        return foodList.stream().filter((x) -> x.getName().equals(name)).findFirst().orElse(null);
    }
}
