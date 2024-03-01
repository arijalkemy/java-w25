package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Utilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PostRepositoryImplTest {

    PostRepositoryImpl postRepository;

    ProductRepositoryImpl productRepository;

    UserRepositoryImpl userRepository;

    @BeforeEach
    void setUp(){
        postRepository = new PostRepositoryImpl();
        productRepository = new ProductRepositoryImpl();
        userRepository = new UserRepositoryImpl();
        productRepository.addProduct(
                Utilities.generateProduct(1, "Arepa")
        );
        productRepository.addProduct(
                Utilities.generateProduct(2, "Papas")
        );
        productRepository.addProduct(
                Utilities.generateProduct(3, "Pan")
        );

        userRepository.getUserById(1).get().getFollowing().add(
                (Seller) userRepository.getUserById(21).get()
        );

        postRepository.addPost(
                Utilities.generatePost(21, 0, LocalDate.parse("2024-02-19"), 1, "Arepa")
        );
        postRepository.addPost(
                Utilities.generatePost(21, 1, LocalDate.parse("2024-02-26"), 2, "Papas")
        );

        postRepository.addPost(
                Utilities.generatePost(21, 2, LocalDate.parse("2024-02-01"), 3, "Pan")
        );

        postRepository.addPost(
                Utilities.generatePost(21, 3, LocalDate.parse("2024-02-28"), 4, "Azucar")
        );
    }

    @Test
    void filterByUserIdAndBetweenDate() {
        //Arrange
        List<Post> expectedListPost = Utilities.generateListPosts();

        //Act
        List<Post> posts = postRepository.filterByUserIdAndBetweenDate(1, LocalDate.parse("2024-02-15"), LocalDate.parse("2024-02-29"));

        //Assert
        assertThat(expectedListPost).isEqualTo(posts);

    }
}