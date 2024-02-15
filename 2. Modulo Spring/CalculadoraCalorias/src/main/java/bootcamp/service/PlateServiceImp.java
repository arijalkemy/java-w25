package bootcamp.service;

import bootcamp.dto.PlateDTO;
import bootcamp.entity.Food;
import bootcamp.entity.Plate;
import bootcamp.repository.IPlateRepository;
import bootcamp.repository.PlateRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlateServiceImp implements IPlateService{

    private IPlateRepository plateRepository;

    public PlateServiceImp(PlateRepository plateRepository){
        this.plateRepository = plateRepository;
    }
    @Override
    public Plate findPlateByName(String name) {
        Optional<Plate> optPlate =plateRepository.loadPlates().stream()
                .filter(plate -> plate.getName().equalsIgnoreCase(name)).findFirst();
        if (!optPlate.isPresent()) throw  new RuntimeException();

        return optPlate.get();



    }

    public PlateDTO cookPlate(Plate plate){
        PlateDTO plateDTO = new PlateDTO();
        double totalCals = 0.0;
        String nameFoodMostCaloric = "";
        double maxFoodCaloric = 0.0;
        List<Food> ingredientes = new ArrayList<>();
        for (HashMap<Food,Double> map : plate.getIngredients()){
            for (Map.Entry<Food, Double> i : map.entrySet()) {

                if(maxFoodCaloric < i.getKey().getCalories()){
                    maxFoodCaloric = i.getKey().getCalories();
                    nameFoodMostCaloric = i.getKey().getName();
                }
                totalCals += (i.getValue() * i.getKey().getCalories());
                ingredientes.add(i.getKey());

            }
        }
        plateDTO.setIngredients(ingredientes);
        plateDTO.setCaloriasTotales(totalCals);
        plateDTO.setIngredienteMasCalorico(nameFoodMostCaloric);
        return plateDTO;
    }
}
