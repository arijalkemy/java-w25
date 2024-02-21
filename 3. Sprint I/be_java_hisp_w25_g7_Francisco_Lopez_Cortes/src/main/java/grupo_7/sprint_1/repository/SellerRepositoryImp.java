package grupo_7.sprint_1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Repository
public class SellerRepositoryImp implements ISellerRepository {

    Mapper mapper;
    private List<Seller> sellers = new ArrayList<>();
    @Autowired
    BuyerRepositoryImp buyerRepository;

    public SellerRepositoryImp(Mapper mapper) throws IOException {
        this.mapper = mapper;
        loadSellers();
    }

    @Override
    public Post postPost(Integer sellerId, PostPostDto newPost) {
        Post post = Mapper.convertPostDtoToPost(newPost);
        Optional<Seller> foundSeller = findById(sellerId);
        foundSeller.get().getPosts().add(post);
        updateSeller(foundSeller.get());
        return post;
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

    public int cantidadDeSeguidores(int userId) {
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
    @Override
    public int cantidadDePromoPost(int userId){
        Optional<Seller> foundSeller = findById(userId);
        if (foundSeller.isEmpty()) {
            throw new NotFoundException("No se ecnontro vendedor");
        }
        Seller seller = foundSeller.get();
        long promoPostsCount = seller.getPosts().stream()
                .filter(post -> post != null && post.getHasPromo() != null && post.getHasPromo())
                .count();
        return (int)promoPostsCount;
    }
    @Override
    public List<Post> getPromoPostsBySeller(int userId) {
        Optional<Seller> foundSeller = findById(userId);
        if (foundSeller.isEmpty()) {
            throw new NotFoundException("No se encontró vendedor");
        }
        Seller seller = foundSeller.get();

        return seller.getPosts().stream()
                .filter(Objects::nonNull)
                .filter(post -> post.getHasPromo() != null && post.getHasPromo())
                .toList();
    }
}

