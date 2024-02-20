package main.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.model.Dish;
import main.model.Food;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
public class DishRepositoryImpl implements IDishRepository {

    private List<Dish> getAllDishs() {

        return List.of(
                new Dish("Ensalada", 10.0, List.of(
                        getFoodByName("Zanahoria"),
                        getFoodByName("Tomates"),
                        getFoodByName("Lechuga"))
                ),
                new Dish ("Hamburguesa con papas", 100.0, List.of(
                        getFoodByName("Hamburguesa"),
                        getFoodByName("Papas cocidas")
                )),
                new Dish("Enzalada Premium", 60.0, List.of(
                        getFoodByName("Zanahoria"),
                        getFoodByName("Tomates"),
                        getFoodByName("Lechuga"),
                        getFoodByName("Mango"),
                        getFoodByName("Manzana"),
                        getFoodByName("Mora")
                ))
        );
    }

    private List<Food> getAllFoods (){

        try {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Food>> typeReference = new TypeReference<>(){};
            List<Food> foods = mapper.readValue(new File("src/main/resources/food.json"), typeReference);
            return foods;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Food getFoodByName(String name){
        List<Food> foods = getAllFoods();
        return foods.stream().filter((x) -> x.getName().equals(name)).findFirst().orElse(null);
    }

    public Dish getDishByName(String name){
        List<Dish> dishs = getAllDishs();
        return dishs.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }
}
