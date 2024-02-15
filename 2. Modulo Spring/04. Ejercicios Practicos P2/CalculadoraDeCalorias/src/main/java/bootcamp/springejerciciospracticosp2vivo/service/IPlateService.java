package bootcamp.springejerciciospracticosp2vivo.service;

import bootcamp.springejerciciospracticosp2vivo.dto.CaloriesPerIngredientDto;
import bootcamp.springejerciciospracticosp2vivo.dto.CaloriesPerPlateDto;
import bootcamp.springejerciciospracticosp2vivo.dto.PlateDto;
import bootcamp.springejerciciospracticosp2vivo.dto.PlateTotalCaloriesDto;
import bootcamp.springejerciciospracticosp2vivo.dto.IngredientDto;
import bootcamp.springejerciciospracticosp2vivo.exception.IngredientNotFoundException;
import bootcamp.springejerciciospracticosp2vivo.exception.PlateNotFoundException;
import bootcamp.springejerciciospracticosp2vivo.exception.PlateWithNoValidIngredientsException;

import java.util.List;

public interface IPlateService {

    PlateTotalCaloriesDto getTotalCalories(String name, Double weight) throws IngredientNotFoundException, PlateNotFoundException;

    CaloriesPerIngredientDto getCaloriesPerIngredient(String name) throws PlateNotFoundException, IngredientNotFoundException;

    IngredientDto getMostCaloricalIngredient(String name) throws PlateNotFoundException, IngredientNotFoundException, PlateWithNoValidIngredientsException;

    CaloriesPerPlateDto getCaloriesPerPlate(List<PlateDto> plates) throws IngredientNotFoundException, PlateNotFoundException;
}
