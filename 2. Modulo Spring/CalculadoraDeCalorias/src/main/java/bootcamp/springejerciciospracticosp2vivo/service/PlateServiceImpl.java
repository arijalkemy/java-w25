package bootcamp.springejerciciospracticosp2vivo.service;

import bootcamp.springejerciciospracticosp2vivo.dto.*;
import bootcamp.springejerciciospracticosp2vivo.entity.Ingredient;
import bootcamp.springejerciciospracticosp2vivo.entity.Plate;
import bootcamp.springejerciciospracticosp2vivo.exception.IngredientNotFoundException;
import bootcamp.springejerciciospracticosp2vivo.exception.PlateNotFoundException;
import bootcamp.springejerciciospracticosp2vivo.exception.PlateWithNoValidIngredientsException;
import bootcamp.springejerciciospracticosp2vivo.repository.IIngredientRepository;
import bootcamp.springejerciciospracticosp2vivo.repository.IPlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlateServiceImpl implements IPlateService {

    @Autowired
    private IPlateRepository plateRepository;
    @Autowired
    private IIngredientRepository ingredientRepository;

    @Override
    public PlateTotalCaloriesDto getTotalCalories(String name, Double weight) throws IngredientNotFoundException, PlateNotFoundException {
        Plate plate = plateRepository.findByName(name);
        double calories = 0;
        for (String ingredientName : plate.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findByName(ingredientName);
            calories += (weight * ingredient.getCalories()) / 100;
        }

        return PlateTotalCaloriesDto.builder()
                .name(plate.getName())
                .calories(calories)
                .build();
    }

    @Override
    public CaloriesPerIngredientDto getCaloriesPerIngredient(String name) throws PlateNotFoundException, IngredientNotFoundException {
        Plate plate = plateRepository.findByName(name);
        List<Ingredient> ingredients = new ArrayList<>();
        for (String ingredientName : plate.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findByName(ingredientName);
            ingredients.add(ingredient);
        }
        return new CaloriesPerIngredientDto(ingredients);
    }

    @Override
    public IngredientDto getMostCaloricalIngredient(String name) throws PlateNotFoundException, IngredientNotFoundException, PlateWithNoValidIngredientsException {
        Plate plate = plateRepository.findByName(name);
        Ingredient mostCaloricalIngredient = null;
        for (String ingredientName : plate.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findByName(ingredientName);
            if (mostCaloricalIngredient == null) mostCaloricalIngredient = ingredient;
            else if (ingredient.getCalories() > mostCaloricalIngredient.getCalories())
                mostCaloricalIngredient = ingredient;
        }
        if (mostCaloricalIngredient == null) throw new PlateWithNoValidIngredientsException(name);
        return new IngredientDto(mostCaloricalIngredient.getName());
    }

    @Override
    public CaloriesPerPlateDto getCaloriesPerPlate(List<PlateDto> plates) throws IngredientNotFoundException, PlateNotFoundException {
        List<PlateTotalCaloriesDto> plateTotalCaloriesDtos = new ArrayList<>();
        for (PlateDto plateDto : plates) {
            plateTotalCaloriesDtos.add(getTotalCalories(plateDto.getName(), plateDto.getWeight()));
        }
        return new CaloriesPerPlateDto(plateTotalCaloriesDtos);
    }

}
