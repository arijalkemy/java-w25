package main.repository;

import main.model.Dish;
import main.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository {

    private List<Dish> dishList = new ArrayList<>();

    public void addDish(Dish dish){
        this.dishList.add(dish);
    }
    public List<Dish> getAll(){
        return dishList;
    }

    public Dish getByName(String name){
        if (dishList.isEmpty()) return null;
        return dishList.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }
}
