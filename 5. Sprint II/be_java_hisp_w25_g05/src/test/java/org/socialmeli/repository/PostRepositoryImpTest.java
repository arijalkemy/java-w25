package org.socialmeli.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.socialmeli.entity.Post;
import org.socialmeli.entity.Product;
import org.socialmeli.entity.Vendor;
import org.socialmeli.repository.implementation.PostRepositoryImp;
import org.socialmeli.repository.implementation.VendorRepositoryImp;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PostRepositoryImpTest {

    private PostRepositoryImp postRepositoryImp;
    @Mock
    private VendorRepositoryImp vendorRepositoryImp;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        List<Vendor> vendorList = new ArrayList<>();
        Vendor vendor1 = new Vendor();
        vendor1.setUserId(1);
        vendor1.setUserName("Vendor Test 1");
        Vendor vendor2 = new Vendor();
        vendor2.setUserId(2);
        vendor2.setUserName("Vendor Test 2");
        vendorList.add(vendor1);
        vendorList.add(vendor2);

        Mockito.when(vendorRepositoryImp.findAll()).thenReturn(vendorList);

        postRepositoryImp = new PostRepositoryImp(vendorRepositoryImp);
    }

    @Test
    @DisplayName("findAllOk")
    void testFindAll() {
        List<Post> allPosts = postRepositoryImp.findAll();

        assertNotNull(allPosts);
        assertEquals(3, allPosts.size());
    }

    @Test
    @DisplayName("savePostOk")
    void testSave() {
        Product product = new Product(4, "Pantalón", "Ropa", "Levis", "Azul", "N/A");
        Post post = new Post(1, LocalDate.now(), product, 1, 59.99);

        Integer savedPostId = postRepositoryImp.save(post);

        assertNotNull(savedPostId);
    }

    @Test
    @DisplayName("findOnePostOK")
    void testFindOne() {
        Product product = new Product(2, "Zapatos", "Calzado", "Adidas", "Negro", "N/A");
        Post post = new Post(1, LocalDate.of(2024, 2, 15), product, 2, 79.99);

        Integer savedPostId = postRepositoryImp.save(post);

        Post foundPost = postRepositoryImp.findOne(savedPostId);

        assertNotNull(foundPost);
        assertEquals(savedPostId, foundPost.getPostId());
    }

    @Test
    @DisplayName("deletePostOK")
    void testDeleteOne() {
        Product product = new Product(3, "Bolso", "Accesorio", "Puma", "Rojo", "Cuero");
        Post post = new Post(1, LocalDate.now(), product, 1, 49.99);

        Integer savedPostId = postRepositoryImp.save(post);

        postRepositoryImp.deleteOne(savedPostId);

        Post deletedPost = postRepositoryImp.findOne(savedPostId);

        assertNull(deletedPost);
    }

}
