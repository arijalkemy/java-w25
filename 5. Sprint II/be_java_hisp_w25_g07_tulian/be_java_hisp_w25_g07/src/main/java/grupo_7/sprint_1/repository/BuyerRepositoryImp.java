package grupo_7.sprint_1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.exception.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BuyerRepositoryImp implements IBuyerRepository {

    private List<Buyer> buyerList = new ArrayList<>();

    public BuyerRepositoryImp() throws IOException {
        loadBuyers();
    }

    @Override
    public Buyer findBuyerById(Integer id) {
        return buyerList.stream()
                .filter(buyer -> buyer.getUserId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateBuyer(Buyer buyer) {
        buyerList.remove(buyer);
        buyerList.add(buyer);
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
            buyerList = mappedBuyers;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(LocalDate.now());
        }
    }
}
