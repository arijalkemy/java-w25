package com.mercadolibre.be_java_hisp_w25_g15.repository.impl;

import com.mercadolibre.be_java_hisp_w25_g15.model.Post;
import com.mercadolibre.be_java_hisp_w25_g15.model.Product;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IPostRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostRepository implements IPostRepository {
    final List<Post> posts = new ArrayList<>(
            List.of(
                    new Post(
                            1,
                            LocalDate.now().minusDays(1),
                            new Product(1, "Mouse", "Electronico", "Logitech", "Negro", "N/A"),
                            1,
                            300.0
                    ),
                    new Post(
                            1,
                            LocalDate.now().minusDays(14),
                            new Product(2, "Celular", "Movil", "Apple", "Negro", "Nuevo"),
                            2,
                            5000.0
                    ),
                    new Post(
                            2,
                            LocalDate.now().minusDays(5),
                            new Product(3, "Carro", "Automatico", "Chevrolet", "Azul", "Usado"),
                            3,
                            50000.0
                    ),
                    new Post(
                            1,
                            LocalDate.now().minusDays(13),
                            new Product(1, "Teclado", "Inalámbrico", "Logitech", "Blanco", "N/A"),
                            1,
                            600.0
                    )
            )
    );
    @Override
    public List<Post> findAllPostsBySellerIdBetweenDateRange(Integer sellerId, LocalDate startDate, LocalDate endDate){
        return posts.stream()
                .filter(post ->
                        Objects.equals(post.getUserId(), sellerId)
                        && post.getDate().isBefore(endDate)
                        && post.getDate().isAfter(startDate))
                .toList();
    }
    
    @Override
    public Post addPost(Post post){
        post.setPostIdAuto();
        posts.add(post);
        return post;
    }

}
