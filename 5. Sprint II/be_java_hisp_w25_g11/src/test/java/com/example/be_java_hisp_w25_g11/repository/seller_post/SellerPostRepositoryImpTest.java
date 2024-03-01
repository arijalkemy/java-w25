package com.example.be_java_hisp_w25_g11.repository.seller_post;

import com.example.be_java_hisp_w25_g11.entity.Product;
import com.example.be_java_hisp_w25_g11.entity.Seller;
import com.example.be_java_hisp_w25_g11.entity.SellerPost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class SellerPostRepositoryImpTest {


        private ISellerPostRepository sellerPostRepository;

        @BeforeEach
        void setUp() {
            sellerPostRepository = new SellerPostRepositoryImp();
            sellerPostRepository.create(new SellerPost(1,2, LocalDate.now(),
                    new Product(2,"Test product","Type test",
                            "Brand test","Color test","notas test")
            ,2,5.0,
                    new Seller(1,"Pepito")));
        }

        @Test
        void testGetAllOk() {
            List<SellerPost> sellerPosts = sellerPostRepository.getAll();

            assertEquals(1,sellerPosts.size());
        }

        @Test
        void testCreateAllOk() {
            //Arrange
            List<SellerPost> sellerPosts = List.of(
                    new SellerPost(),
                    new SellerPost(),
                    new SellerPost()
            );
            sellerPosts.get(0).setPostId(1);
            sellerPosts.get(1).setPostId(2);
            sellerPosts.get(2).setPostId(3);
            //Act
            List<SellerPost> result = sellerPostRepository.createAll(sellerPosts);

            //Assert
            assertEquals(sellerPosts.size(), result.size());
            assertEquals(sellerPosts, result);
        }

        @Test
        void testCreateOk() {
            //Arrange
            SellerPost sellerPost = new SellerPost();
            sellerPost.setPostId(1);

            //Act
            sellerPostRepository.create(sellerPost);
            Optional<SellerPost> result = sellerPostRepository.get(sellerPost.getPostId());

            //Assert
            assertNotNull(result.get().getPostId());
            assertEquals(sellerPost.getPostId(), result.get().getPostId());
            assertEquals(sellerPost.getCategory(), result.get().getCategory());
        }

        @Test
        void testGetOk() {
            //Arrange
            SellerPost sellerPost = new SellerPost();
            sellerPost.setPostId(1);
            sellerPostRepository.create(sellerPost);
            //Act
            Optional<SellerPost> retrievedPost = sellerPostRepository.get(sellerPost.getPostId());
            //Assert
            assertTrue(retrievedPost.isPresent());
            assertEquals(sellerPost, retrievedPost.get());
        }

        @Test
        void testUpdateOk() {
            //Arrange
            SellerPost sellerPost = new SellerPost();
            sellerPost.setPostId(1);
            sellerPostRepository.create(sellerPost);
            SellerPost updatedPost = new SellerPost();

            //Act
            updatedPost.setPostId(2);
            boolean result = sellerPostRepository.update(sellerPost.getPostId(), updatedPost);

            //Assert
            assertTrue(result);
            Optional<SellerPost> retrievedPost = sellerPostRepository.get(sellerPost.getPostId());
            assertTrue(retrievedPost.isPresent());
            assertEquals(updatedPost, retrievedPost.get());
        }

        @Test
        void testDeleteOk() {
            //Arrange
            SellerPost sellerPost = new SellerPost();
            sellerPost.setPostId(1);
            sellerPostRepository.create(sellerPost);

            //Act
            boolean result = sellerPostRepository.delete(sellerPost.getPostId());

            //Assert
            assertTrue(result);
            Optional<SellerPost> retrievedPost = sellerPostRepository.get(sellerPost.getPostId());
            assertTrue(retrievedPost.isEmpty());
        }

        @Test
        void testExistingOk() {
            //Arrange
            SellerPost sellerPost = new SellerPost();
            sellerPost.setPostId(1);
            sellerPostRepository.create(sellerPost);

            //Act & Assert
            assertTrue(sellerPostRepository.existing(sellerPost.getPostId()));
            assertFalse(sellerPostRepository.existing(sellerPost.getPostId() + 1));
        }
}
