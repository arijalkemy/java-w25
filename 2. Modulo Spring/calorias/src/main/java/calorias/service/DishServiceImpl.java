package calorias.service;

import calorias.dto.DishResponseDTO;
import calorias.model.Dish;
import calorias.model.Ingredient;
import calorias.repository.DishRepository;
import calorias.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    private DishResponseDTO dishResponseDTO;
    private Dish dish;
    private String dishName;
    private final IngredientRepository ingredientRepository;
    private final DishRepository dishRepository;

    // Inversion of Control (dependency injection via Constructor) here.
    public DishServiceImpl(
            IngredientRepository ingredientRepository,
            DishRepository dishRepository
    ){
        this.ingredientRepository = ingredientRepository;
        this.dishRepository = dishRepository;
        this.dishResponseDTO = new DishResponseDTO();
    }


    @Override
    public double getCaloriesTotal(Dish dish) {
        ArrayList<Ingredient> ingredientList = dish.getIngredientList();
        // double caloriesTotal = 0;
        System.out.println("Calling getCaloriesTotal");
        double caloriesTotal = ingredientList.stream()
                .mapToDouble(ingredient -> {
                    int caloriesPer100g = ingredientRepository.findCaloriesForIngredient(ingredient.getName()).getCalories();
                    return ingredient.getCalories() * ingredient.getGrams() * 1.0 / 100;
                }).sum();
        System.out.println("Calories Total is: " + caloriesTotal);
        return caloriesTotal;
    }

    @Override
    public String getMostCaloricIngredient(Dish dish) {
        // Duplicación de código con getCaloriesTotal ?? -- si hay tiempo, revisar.
        ArrayList<Ingredient> ingredientList = dish.getIngredientList();
        System.out.println("Calling getMostCaloricIngredient");
        Comparator<Ingredient> getMax =  new Comparator<Ingredient>() {
            public int compare(Ingredient i1, Ingredient i2) {
                double diff = i1.getCalories() - i2.getCalories();
                return (int)diff;
            }
        };
        Optional<Ingredient> mostCaloric = ingredientList.stream().max(getMax);
        String ans = null;
        if (mostCaloric.isPresent()){
            ans = mostCaloric.get().getName();
            System.out.println("Most caloric ingredient is: " + ans);
        }
        return ans;
    }

    public Dish createDishObject(String dishName) {
        ArrayList<Ingredient> ingredientsList = dishRepository.getDishIngredients(dishName);
        Dish newDish = new Dish();
        newDish.setName(dishName);
        newDish.setIngredientList(ingredientsList);
        addCaloriesValue(newDish);
        return newDish;
    }

    public void addCaloriesValue(Dish dish) {
        dish.ingredientList.forEach(ing -> {
                int caloriesPer100g = ingredientRepository.findCaloriesForIngredient(ing.getName()).getCalories();
                double caloriesTotal = caloriesPer100g * 1.0 * ing.getGrams()/ 100;
                System.out.println("Calories for " + ing.getGrams() + " of " + ing.getName() + " are " + caloriesTotal);
                ing.setCalories(caloriesTotal);
        });
    }

    @Override
    public DishResponseDTO getDishResponseDTO(String dishName) {
        Dish newDish = createDishObject(dishName);
        double caloriesTotal = getCaloriesTotal(newDish);
        String mostCaloricIngredient = getMostCaloricIngredient(newDish);
        this.dishResponseDTO.setName(newDish.name);
        this.dishResponseDTO.setIngredients(newDish.ingredientList);
        this.dishResponseDTO.setCaloriesTotal(caloriesTotal);
        this.dishResponseDTO.setMostCaloricIngredient(mostCaloricIngredient);
        return this.dishResponseDTO;
    }
}
