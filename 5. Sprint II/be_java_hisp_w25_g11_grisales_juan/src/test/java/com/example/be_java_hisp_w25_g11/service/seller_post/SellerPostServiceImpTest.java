package com.example.be_java_hisp_w25_g11.service.seller_post;

import com.example.be_java_hisp_w25_g11.dto.SellerPostDTO;
import com.example.be_java_hisp_w25_g11.dto.request.ProductDTO;
import com.example.be_java_hisp_w25_g11.dto.response.SellerPostsListDTO;
import com.example.be_java_hisp_w25_g11.entity.Buyer;
import com.example.be_java_hisp_w25_g11.entity.Product;
import com.example.be_java_hisp_w25_g11.entity.Seller;
import com.example.be_java_hisp_w25_g11.entity.SellerPost;
import com.example.be_java_hisp_w25_g11.exception.BadRequestException;
import com.example.be_java_hisp_w25_g11.exception.NotFoundException;
import com.example.be_java_hisp_w25_g11.repository.buyer.BuyerRepositoryImp;
import com.example.be_java_hisp_w25_g11.repository.seller.SellerRepositoryImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SellerPostServiceImpTest {

    @Mock
    private SellerRepositoryImp sellerRepository;
    @Mock
    private BuyerRepositoryImp buyerRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private SellerPostServiceImp sellerPostService;

    private SellerPostsListDTO getFollowedSellersLatestPosts(String order) {
        // Arrange
        Integer buyerId = 1;
        Integer sellerId1 = 2, sellerId2 = 3;
        Integer postId1 = 1, postId2 = 2, postId3 = 3, postId4 = 4;
        Set<Integer> followedSellers = new HashSet<>(List.of(sellerId1, sellerId2));

        SellerPost post1 = new SellerPost(
                sellerId1,
                postId1,
                LocalDate.now().minusDays(3),
                new Product(),
                1,
                10.0,
                null
        ), post2 = new SellerPost(
                sellerId1,
                postId2,
                LocalDate.now().minusDays(7),
                new Product(),
                1,
                10.0,
                null
        ), post3 = new SellerPost(
                sellerId2,
                postId3,
                LocalDate.now().minusDays(10),
                new Product(),
                1,
                10.0,
                null
        ), post4 = new SellerPost(
                sellerId2,
                postId4,
                LocalDate.now().minusDays(12),
                new Product(),
                1,
                10.0,
                null
        );

        SellerPostDTO postDto1 = new SellerPostDTO(
                sellerId1,
                postId1,
                post1.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                new ProductDTO(),
                1,
                10.0
        ), postDto2 = new SellerPostDTO(
                sellerId1,
                postId1,
                post2.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                new ProductDTO(),
                1,
                10.0
        ), postDto3 = new SellerPostDTO(
                sellerId2,
                postId2,
                post3.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                new ProductDTO(),
                1,
                10.0
        ), postDto4 = new SellerPostDTO(
                sellerId2,
                postId2,
                post4.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                new ProductDTO(),
                1,
                10.0
        );

        Buyer buyer = new Buyer(1, "Juan", followedSellers);
        Seller seller1 = new Seller(
                sellerId1,
                "Jaime",
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(List.of(post1, post2))
        ), seller2 = new Seller(
                sellerId2,
                "Batman",
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(List.of(post3, post4))
        );

        when(buyerRepository.get(buyerId)).thenReturn(Optional.of(buyer));
        when(sellerRepository.get(buyerId)).thenReturn(Optional.empty());
        when(sellerRepository.get(sellerId1)).thenReturn(Optional.of(seller1));
        when(sellerRepository.get(sellerId2)).thenReturn(Optional.of(seller2));

        lenient().when(modelMapper.map(post1, SellerPostDTO.class)).thenReturn(postDto1);
        lenient().when(modelMapper.map(post2, SellerPostDTO.class)).thenReturn(postDto2);
        lenient().when(modelMapper.map(post3, SellerPostDTO.class)).thenReturn(postDto3);
        lenient().when(modelMapper.map(post4, SellerPostDTO.class)).thenReturn(postDto4);

        // Act
        return sellerPostService.getFollowedSellersLatestPosts(buyerId, order);
    }

    //T-0005. Verificar que el tipo de ordenamiento por fecha exista(US-0009)
    //Resultado: Permite continuar con normalidad.
    @Test
    void testFollowedSellersLatestPostsValidOrder(){
        // Arrange
        Integer sellerId = 1;
        Seller seller = new Seller(sellerId, "seller");
        String orderAsc = "date_asc";
        String orderDesc = "date_desc";
        String noOrder = null;
        when(sellerRepository.get(sellerId)).thenReturn(Optional.of(seller));
        when(buyerRepository.get(sellerId)).thenReturn(Optional.empty());
        // Act & Assert
        Assertions.assertDoesNotThrow(() -> sellerPostService.getFollowedSellersLatestPosts(sellerId, orderAsc));
        Assertions.assertDoesNotThrow(() -> sellerPostService.getFollowedSellersLatestPosts(sellerId, orderDesc));
        Assertions.assertDoesNotThrow(() -> sellerPostService.getFollowedSellersLatestPosts(sellerId, noOrder));
    }

    //T-0005. Verificar que el tipo de ordenamiento por fecha exista(US-0009)
    //Resultado: Notifica la no existencia mediante una excepción.
    @Test
    void testFollowedSellersLatestPostsInvalidOrder() {
        // Arrange
        Integer sellerId = 1;
        Seller seller = new Seller(sellerId, "seller");
        String failOrderAsc = "asc";
        String failOrderDesc = "desc";
        String otherOrder = "empanada";
        when(sellerRepository.get(sellerId)).thenReturn(Optional.of(seller));
        when(buyerRepository.get(sellerId)).thenReturn(Optional.empty());
        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> sellerPostService.getFollowedSellersLatestPosts(sellerId, failOrderAsc));
        Assertions.assertThrows(BadRequestException.class, () -> sellerPostService.getFollowedSellersLatestPosts(sellerId, failOrderDesc));
        Assertions.assertThrows(BadRequestException.class, () -> sellerPostService.getFollowedSellersLatestPosts(sellerId, otherOrder));
    }


    // T-0006: Verificar el correcto ordenamiento ascendente y descendente por fecha
    // Resultado: Devuelve la lista ordenada según el criterio solicitado
    @Test
    void testFollowedSellersLatestPostsOrder() {
        // Arrange
        String orderAsc = "date_asc";
        String orderDesc = "date_desc";
        String orderInvalid = "date_invalid";
        // Arrange & Act
        List<SellerPostDTO> followedSellersPostsAsc = this.getFollowedSellersLatestPosts(orderAsc).getPosts();
        List<SellerPostDTO> followedSellersPostsDesc = this.getFollowedSellersLatestPosts(orderDesc).getPosts();
        // Assert
        assertTrue(
            IntStream.range(0, followedSellersPostsAsc.size() - 1)
            .allMatch(
                i -> followedSellersPostsAsc.get(i)
                .getDate().compareTo(
                    followedSellersPostsAsc.get(i + 1)
                    .getDate()) <= 0
            )
        );
        assertTrue(
            IntStream.range(0, followedSellersPostsDesc.size() - 1)
            .allMatch(
                i -> followedSellersPostsDesc.get(i)
                .getDate().compareTo(
                    followedSellersPostsDesc.get(i + 1)
                    .getDate()) >= 0
            )
        );
        assertThrows(
            BadRequestException.class,
            () -> this.getFollowedSellersLatestPosts(orderInvalid)
        );
    }

    // T-0008: Verificar que la consulta de publicaciones realizadas en las últimas dos
    // semanas de un determinado vendedor sean efectivamente de las últimas dos semanas.
    // Resultado: Permite continuar con normalidad y devuelve la lista de posts de las últimas dos semanas.
    @Test
    void testFollowedSellersLatestPostsOK() {
        // Arrange & Act
        SellerPostsListDTO followedSellersPosts = this.getFollowedSellersLatestPosts(null);
        // Assert
        assertFalse(followedSellersPosts.getPosts()
                .stream()
                .anyMatch(v -> LocalDate.parse(
                        v.getDate(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd")
                ).isBefore(LocalDate.now().minusWeeks(2))));
    }

    // T-0008: Verificar que la consulta de publicaciones realizadas en las últimas dos
    // semanas de un determinado vendedor sean efectivamente de las últimas dos semanas.
    // Resultado: Lanza una excepción al no encontrar un usuario con ese ID.
    @Test
    void testFollowedSellersLatestPostsThrowsNotFound() {
        Integer buyerId = 1;

        when(sellerRepository.get(buyerId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> sellerPostService.getFollowedSellersLatestPosts(buyerId, null));
    }
}