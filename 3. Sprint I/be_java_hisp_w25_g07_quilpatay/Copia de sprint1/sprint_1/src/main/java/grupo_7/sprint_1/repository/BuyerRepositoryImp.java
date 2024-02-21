package grupo_7.sprint_1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.repository.inter.IBuyerRepository;
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
public class BuyerRepositoryImp implements IBuyerRepository {

    private List<Buyer> buyers = new ArrayList<>();

    public BuyerRepositoryImp() throws IOException {
        loadBuyers();
    }

    @Override
    public Optional<Buyer> findById(Integer id) {
        return buyers.stream()
                .filter(buyer -> buyer.getUserId().equals(id))
                .findFirst();
    }

    @Override
    public void update(Buyer buyer) {
        buyers.remove(buyer);
        buyers.add(buyer);
    }

    private void loadBuyers() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Buyer> mappedBuyers;

        try {
            file = ResourceUtils.getFile("classpath:buyers.json");

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
            mappedBuyers = objectMapper.readValue(file, new TypeReference<List<Buyer>>() {
            });
            buyers = mappedBuyers;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(LocalDate.now());
        }
    }
}
