package grupo_7.sprint_1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SellerRepositoryImp implements ISellerRepository {

    Mapper mapper;
    private List<Seller> sellers = new ArrayList<>();

    public SellerRepositoryImp(Mapper mapper) throws IOException {
        this.mapper = mapper;
        loadSellers();
    }

    @Override
    public void updateSeller(Seller seller) {
        sellers.remove(seller);
        sellers.add(seller);
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellers;
    }

    public Optional<Seller> findById(Integer userId) {
        return sellers.stream()
                .filter(seller -> seller.getUserId().equals(userId))
                .findFirst();
    }
@Override
    public int cantidadDeSeguidoresRepo(int userId) {
        return sellers.stream()
                .filter(seller -> seller.getUserId() == userId)
                .findFirst()
                .map(seller -> seller.getFollowers().size())
                .orElse(0);
    }

    private void loadSellers() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Seller> mappedSellers;

        try {
            file = ResourceUtils.getFile("classpath:sellers.json");

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
            mappedSellers = objectMapper.readValue(file, new TypeReference<List<Seller>>() {
            });
            sellers = mappedSellers;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(LocalDate.now());
        }
    }
}

