package main.repository;

import main.model.Dish;
import main.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishRepository {

    private final FoodRepository foodRepository;
    private final List<Dish> dishList;

    public DishRepository(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
        this.dishList = this.loadDishList();
    }

    private List<Dish> loadDishList() {
        return
        List.of(
                new Dish("Ensalada", 10.0, List.of(
                        foodRepository.getByName("Zanahoria"),
                        foodRepository.getByName("Tomates"),
                        foodRepository.getByName("Lechuga"))
                ),
                new Dish("Hamburguesa con papas", 100.0, List.of(
                        foodRepository.getByName("Hamburguesa"),
                        foodRepository.getByName("Papas cocidas")
                )),
                new Dish("Enzalada Premium", 60.0, List.of(
                        foodRepository.getByName("Zanahoria"),
                        foodRepository.getByName("Tomates"),
                        foodRepository.getByName("Lechuga"),
                        foodRepository.getByName("Mango"),
                        foodRepository.getByName("Manzana"),
                        foodRepository.getByName("Mora")
                )

                )
        );
    }


    public List<Dish> getAll(){
        return dishList;
    }

    public Dish getByName(String name){
        return dishList.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }
}
