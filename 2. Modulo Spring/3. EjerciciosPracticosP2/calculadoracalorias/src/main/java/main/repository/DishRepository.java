package main.repository;

import main.model.Dish;
import main.model.Food;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;

@Repository
public class DishRepository {

    public List<Dish> getAll(){
        return List.of(
                new Dish("Ensalada", 10.0, List.of(
                        FoodRepository.getByName("Zanahoria"),
                        FoodRepository.getByName("Tomates"),
                        FoodRepository.getByName("Lechuga"))
                ),
                new Dish ("Hamburguesa con papas", 100.0, List.of(
                        FoodRepository.getByName("Hamburguesa"),
                        FoodRepository.getByName("Papas cocidas"))
                ),
                new Dish("Enzalada Premium", 60.0, List.of(
                        FoodRepository.getByName("Zanahoria"),
                        FoodRepository.getByName("Tomates"),
                        FoodRepository.getByName("Lechuga"),
                        FoodRepository.getByName("Mango"),
                        FoodRepository.getByName("Manzana"),
                        FoodRepository.getByName("Mora"))
                )
        );
    }

    public Dish getByName(String name){
        System.out.println(MessageFormat.format("Se pide el nombre de {0}", name));
        return getAll().stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }
}
