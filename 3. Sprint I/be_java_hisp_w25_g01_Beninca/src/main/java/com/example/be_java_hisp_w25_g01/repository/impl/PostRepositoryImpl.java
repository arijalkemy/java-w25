package com.example.be_java_hisp_w25_g01.repository.impl;

import com.example.be_java_hisp_w25_g01.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01.dto.request.ProductDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsByPriceDTO;
import com.example.be_java_hisp_w25_g01.entity.Post;
import com.example.be_java_hisp_w25_g01.entity.Product;
import com.example.be_java_hisp_w25_g01.repository.IPostRepository;
import com.example.be_java_hisp_w25_g01.repository.IProductRepository;
import com.example.be_java_hisp_w25_g01.service.impl.PostServiceImpl;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    IProductRepository productRepository;

    private List<Post> listOfPost;
    @Autowired
    public PostRepositoryImpl(IProductRepository productRepository){
        this.productRepository = productRepository;
        loadPost();
    }
    private void loadPost(){
        this.listOfPost =  new ArrayList<>(List.of(
                new Post(1,4, LocalDate.of(2024, Month.FEBRUARY,18), productRepository.findById(1).get(), 100, 1500.50, false, 0.),
                new Post(2,4, LocalDate.of(2024, Month.MAY,01), productRepository.findById(62).get(), 120, 2800.69, false, 0.),
                new Post(3,5, LocalDate.of(2024, Month.JANUARY,29),productRepository.findById(1).get(), 100, 1500.00, false, 0.),
                new Post(4, 5, LocalDate.of(2024, Month.FEBRUARY, 15), productRepository.findById(2).get(),110, 200.41, false, 0.),
                new Post(5, 4, LocalDate.of(2024, Month.FEBRUARY, 12), productRepository.findById(3).get(), 100, 500.00, true, 0.5),
                new Post(6, 4, LocalDate.of(2023, Month.JANUARY, 01), productRepository.findById(4).get(),110, 200000.00, true, 0.5)
                ));
    }

    public List<Post> getAll(){
        return listOfPost;
    };
    public Optional<Post> findById(Integer id){
        return listOfPost.stream()
                .filter(p-> id.equals(p.getPost_id()))
                .findFirst();
    };

    public List<Post> findByUser(Integer id){
        return listOfPost.stream()
                .filter(p-> id.equals(p.getUser_id()))
                .toList();
    };

    public void addPost(Post post){
        listOfPost.add(post);
    }

    public Integer generateId(){
        return listOfPost.get(listOfPost.size()-1).getPost_id()+1;
    }



    //US 0012 - Buscar posts por categoría y rango de precios.
    public List<PostsByPriceDTO> getByCategoryAndPrice (Integer category, Double minPrice, Double maxPrice) {
        List<PostsByPriceDTO> result = new ArrayList<>();

        listOfPost.stream()
                .filter(p -> category.equals(p.getCategory()) &&
                        minPrice <= p.getPrice() &&
                        maxPrice >= p.getPrice())
                .collect(Collectors.groupingBy(Post::getCategory))
                .forEach((cat, posts) -> {
                    List<PostDTO> postDTOs = posts.stream()
                            .map(this::convertToPostsByPriceDto)
                            .collect(Collectors.toList());

                    result.add(new PostsByPriceDTO(postDTOs));
                });

        return result;
    }
    private PostDTO convertToPostsByPriceDto (Post post){
        return new PostDTO(post.getUser_id(),
                post.getDate(),
                convertToProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice()
        );
    }
    private ProductDTO convertToProductDto (Product p) {
        return new ProductDTO(
                p.getProductId(),
                p.getProductName(),
                p.getType(),
                p.getBrand(),
                p.getColor(),
                p.getNotes()
        );
    }
}
