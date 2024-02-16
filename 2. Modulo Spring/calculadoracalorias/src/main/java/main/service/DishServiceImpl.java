package main.service;

import main.dto.DishRequestDTO;
import main.dto.DishResponseDTO;
import main.dto.FoodResponseDTO;
import main.model.Dish;
import main.model.Food;
import main.repository.DishRepository;
import main.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DishServiceImpl implements IDishService {


    @Autowired
    DishRepository dishRepository;

    @Autowired
    FoodRepository foodRepository;

    @Override
    public double cantidadTotalCalorias(DishRequestDTO dish) {
        Food food2 = foodRepository.getByName("Tomate");
        Dish selectDish = dishRepository.getByName((dish.getName()));
        if (selectDish != null) {
            return selectDish.getFoods().stream()
                    .map(food -> Double.parseDouble(String.valueOf(food.getCalories())) / 100)
                    .reduce(0.0, Double::sum) * dish.getWeight();
        } else {
            return 0;
        }
    }

    @Override
    public FoodResponseDTO comidaCaloriasMaxima(DishRequestDTO dish) {
        String name = dish.getName();
        Food maxFood = dishRepository.getByName(name).getFoods().stream().max(Comparator.comparing(Food::getCalories)).orElse(null);
        double calories =  maxFood.getCalories()*((double) dish.getWeight() /100);
        return new FoodResponseDTO(maxFood.getName(), calories);
    }

    public List<FoodResponseDTO> ingredientesCalorias(DishRequestDTO dish){
        Dish dishFound = dishRepository.getByName(dish.getName());
        return dishFound.getFoods().stream().map(food -> {
            double calories =  food.getCalories()*((double) dish.getWeight() /100);
            return new FoodResponseDTO(food.getName(), calories);
        }).toList();
    }

    public void loadListDish(){
        dishRepository.addDish(new Dish("Ensalada", 10.0, List.of(
                foodRepository.getByName("Zanahoria"),
                foodRepository.getByName("Tomates"),
                foodRepository.getByName("Lechuga"))
        ));
        dishRepository.addDish(new Dish ("Hamburguesa con papas", 100.0, List.of(
                foodRepository.getByName("Hamburguesa"),
                foodRepository.getByName("Papas cocidas")
        )));
        dishRepository.addDish(new Dish("Enzalada Premium", 60.0, List.of(
                foodRepository.getByName("Zanahoria"),
                foodRepository.getByName("Tomates"),
                foodRepository.getByName("Lechuga"),
                foodRepository.getByName("Mango"),
                foodRepository.getByName("Manzana"),
                foodRepository.getByName("Mora")
        )));
    }
}
