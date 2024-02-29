package com.mercadolibre.be_java_hisp_w25_g15.repository.impl;

import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.ProductDto;
import com.mercadolibre.be_java_hisp_w25_g15.model.Post;
import com.mercadolibre.be_java_hisp_w25_g15.model.Product;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IPostRepository;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class PostRepositoryTest {
    PostRepository postRepository = new PostRepository();
    @Test
    void findAllPostsBySellerIdBetweenDateRange() {

        //Arrange
        Integer sellerIdParam = 1;
        LocalDate startDateParam = LocalDate.now().minusWeeks(2);
        LocalDate endDateParam = LocalDate.now();
        List<Post> postListExpected = List.of(
                postRepository.getPosts().get(0),
                postRepository.getPosts().get(3)
        );

        //Act
        List<Post> postListResult = this.postRepository.findAllPostsBySellerIdBetweenDateRange(sellerIdParam, startDateParam, endDateParam );

        //Assert
        assertEquals(postListExpected, postListResult);
    }

    @Test
    void addPost() {
        //Arrange
        Post postParam = new Post(
                1,
                LocalDate.now().minusDays(1),
                new Product(1, "Mouse", "Electronico", "Logitech", "Negro", "N/A"),
                1,
                300.0
        );
        //Act
        Post post = postRepository.addPost(postParam);

        //Assert
        Assertions.assertEquals(postParam, post);
    }
}