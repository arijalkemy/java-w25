package grupo_7.sprint_1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.repository.inter.ISellerRepository;
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

    private List<Seller> sellers = new ArrayList<>();

    public SellerRepositoryImp() throws IOException {
        loadSellers();
    }

    @Override
    public void update(Seller seller) {
        sellers.remove(seller);
        sellers.add(seller);
    }

    @Override
    public Integer countSellerPromos(Integer sellerId) {
        return sellers.stream()
                .filter(seller -> seller.getUserId().equals(sellerId))
                .flatMap(seller -> seller.getPosts().stream())
                .filter(post -> post.getHasPromo().equals(true))
                .mapToInt(post -> 1)
                .sum();
    }

    public Optional<Seller> findById(Integer sellerId) {
        return sellers.stream()
                .filter(seller -> seller.getUserId().equals(sellerId))
                .findFirst();
    }

    public Integer countFollowers(Integer userId) {
        return sellers.stream()
                .filter(seller -> seller.getUserId().equals(userId))
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

    @Override
    public List<Seller> getAll() {
        return sellers;
    }
}

