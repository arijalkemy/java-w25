package bootcamp.service;

import bootcamp.dto.FoodDTO;
import bootcamp.entity.Food;
import bootcamp.repository.FoodRepositoryImp;
import bootcamp.repository.IFoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImp implements IFoodService{

    private IFoodRepository foodRepository;

    public FoodServiceImp(FoodRepositoryImp foodRepository){
        this.foodRepository = foodRepository;

    }
    @Override
    public List<FoodDTO> findAll() {
       return foodRepository.loadFood().stream().map(FoodDTO::new).toList();
    }

    @Override
    public FoodDTO findFoodByName(String name) throws Exception {
        Optional<Food> optFood = foodRepository.loadFood().stream()
                .filter(food -> food.getName().equalsIgnoreCase(name)).findFirst();
        if (optFood.isPresent()) throw  new Exception(("No encontrado"));

        return new FoodDTO(optFood.get());

    }
}
