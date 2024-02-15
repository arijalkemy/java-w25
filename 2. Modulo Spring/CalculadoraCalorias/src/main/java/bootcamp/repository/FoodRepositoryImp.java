package bootcamp.repository;

import bootcamp.entity.Food;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepositoryImp implements IFoodRepository{
    @Override
    public List<Food> loadFood() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(
                    new ClassPathResource("food.json").getInputStream(),
                    new TypeReference<List<Food>>() {
                    });
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
