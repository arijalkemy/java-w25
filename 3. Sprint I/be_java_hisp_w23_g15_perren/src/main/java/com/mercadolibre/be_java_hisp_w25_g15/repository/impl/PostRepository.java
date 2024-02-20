package com.mercadolibre.be_java_hisp_w25_g15.repository.impl;

import com.mercadolibre.be_java_hisp_w25_g15.model.Post;
import com.mercadolibre.be_java_hisp_w25_g15.model.Product;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IPostRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostRepository implements IPostRepository {
    final List<Post> posts = new ArrayList<>(
            List.of(
                    new Post(
                            1,
                            LocalDate.of(2024, 2, 14),
                            new Product(1, "Mouse", "Electronico", "Logitech", "Negro", "N/A"),
                            1,
                            300.0
                    ),
                    new Post(
                            1,
                            LocalDate.of(2024, 2, 18),
                            new Product(2, "Celular", "Movil", "Apple", "Negro", "Nuevo"),
                            2,
                            5000
                    ),
                    new Post(
                            2,
                            LocalDate.of(2024, 2, 6),
                            new Product(3, "Carro", "Automatico", "Chevrolet", "Azul", "Usado"),
                            3,
                            50000
                    ),
                    new Post(
                            1,
                            LocalDate.of(2024, 2, 13),
                            new Product(1, "Teclado", "Inalámbrico", "Logitech", "Blanco", "N/A"),
                            1,
                            600.0
                    ),
                    new Post(2, LocalDate.of(2024,2,19),
                            new Product(5, "Mouse", "Inalámbrico", "Razer", "Negro", "N/A"),
                            1,
                            300.0,
                            true,
                            0.50)

            )
    );
    @Override
    public List<Post> findAllPostsBySellerIdBetweenDateRange(int sellerId, LocalDate startDate, LocalDate endDate){
        return posts.stream()
                .filter(post ->
                        post.getUserId() == sellerId
                        && post.getDate().isBefore(endDate)
                        && post.getDate().isAfter(startDate))
                .toList();
    }
    
    @Override
    public Post addPost(Post post){
        posts.add(post);
        return post;
    }

    @Override
    public int countPromoPostsBySellerId(int id) {
        return (int) posts.stream().filter(post -> post.getUserId() == id && post.getHasPromo()).count();
    }

    @Override
    public List<Post> findPromoPostsBySellerId(int userId) {
        return posts.stream().filter(post -> post.getHasPromo() && post.getUserId() == userId).toList();
    }

}
