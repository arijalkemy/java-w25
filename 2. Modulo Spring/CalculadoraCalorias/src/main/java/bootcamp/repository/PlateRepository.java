package bootcamp.repository;

import bootcamp.entity.Food;
import bootcamp.entity.Plate;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Repository
public class PlateRepository implements IPlateRepository{

    private IFoodRepository foodRepository;

    public List<Plate> loadPlates() {
        List<Food> foodList = foodRepository.loadFood();
        List<Plate> plates = new ArrayList<>();
        plates.add(new Plate("Fideos", List.of(new HashMap<>() {
                                                            {
                                                                put(foodList.get(0), 0.5);
                                                                put(foodList.get(1), 2.0);
                                                                put(foodList.get(2), 1.0);
                                                            }
                                                        }
        )));
        return plates;

    }

    public PlateRepository(FoodRepositoryImp foodRepository) {
        this.foodRepository = foodRepository;
    }

}
