package com.grupo08.socialmeli.service;

import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.dto.response.*;
import com.grupo08.socialmeli.entity.*;
import com.grupo08.socialmeli.exception.BadRequestException;
import com.grupo08.socialmeli.exception.NotFoundException;
import com.grupo08.socialmeli.repository.BuyerRepositoryImpl;
import com.grupo08.socialmeli.repository.IPostRepository;
import com.grupo08.socialmeli.repository.SellerRepositoryImpl;
import com.grupo08.socialmeli.utils.TestData;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImplTest {

    @Mock
    SellerRepositoryImpl sellerRepository;

    @Mock
    BuyerRepositoryImpl buyerRepository;

    @Mock
    IPostRepository postRepository;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("T0001_Ok")
    public void testFollowSuccess() {
        int existingBuyerId = 1; // ID de comprador existente
        int existingSellerId = 2; // ID de vendedor existente

        // Configura el mock para que devuelva objetos válidos
        Buyer mockBuyer = new Buyer(existingBuyerId, "Fabian", new ArrayList<>()); // Asume que Buyer y Seller son clases que existen
        Seller mockSeller = new Seller(existingSellerId, "Juan", new ArrayList<>(), new ArrayList<>());

        when(buyerRepository.findById(existingBuyerId)).thenReturn(Optional.of(mockBuyer));
        when(sellerRepository.findById(existingSellerId)).thenReturn(Optional.of(mockSeller));

        // Ejecuta el método a probar
        FollowDto result = userService.follow(1, 2);

        // Verifica que el resultado es el esperado
        assertNotNull(result);
        assertEquals(existingSellerId, result.getUserId());
        assertEquals(mockSeller.getName(), result.getUserName());

        // Verifica que el método findById fue llamado con los ID correctos
        verify(buyerRepository).findById(existingBuyerId);
        verify(sellerRepository).findById(existingSellerId);

        // Verifica que se añadió el vendedor a seguir al comprador y viceversa
        assertTrue(mockBuyer.getFollowing().contains(mockSeller));
        assertTrue(mockSeller.getFollowers().contains(mockBuyer));
    }

    @Test
    @DisplayName("T0001_buyer_not_found")
    void followBuyerNotFound() {

        int nonExistentBuyerId = 123;
        int existingSellerId = 3;

        // Configura el mock para que devuelva un Optional vacío
        when(buyerRepository.findById(nonExistentBuyerId)).thenReturn(Optional.empty());
        when(sellerRepository.findById(existingSellerId)).thenReturn(Optional.of(new Seller())); // Asume que Seller es una clase que existe

        // Ejecuta el método a probar
        assertThrows(NotFoundException.class, () ->
                userService.follow(nonExistentBuyerId, existingSellerId));

        // Verifica que el método findById fue llamado con el ID correcto
        verify(buyerRepository).findById(nonExistentBuyerId);
        verify(sellerRepository).findById(existingSellerId);
    }

    @Test
    @DisplayName("T0001_seller_already_followed")
    void followSellerAlreadyFollowed() {

        int existingBuyerId = 1; // ID de comprador existente
        int existingSellerId = 2; // ID de vendedor existente

        // Configura el mock para que devuelva objetos válidos
        Buyer mockBuyer = new Buyer(existingBuyerId, "Fabian", new ArrayList<>(
                List.of(new Seller(existingSellerId, "Juan", List.of(), List.of())))); // Asume que Buyer y Seller son clases que existen
        Seller mockSeller = new Seller(existingSellerId, "Juan", new ArrayList<>(),
                new ArrayList<>(List.of(new User(existingBuyerId, "Fabian"))));

        when(buyerRepository.findById(existingBuyerId)).thenReturn(Optional.of(mockBuyer));
        when(sellerRepository.findById(existingSellerId)).thenReturn(Optional.of(mockSeller));

        assertThrows(BadRequestException.class, () -> userService.follow(existingBuyerId, existingSellerId));

        verify(buyerRepository).findById(existingBuyerId);
        verify(sellerRepository).findById(existingSellerId);

    }

    @Test
    @DisplayName("T0001_seller_not_found")
    void followSellerNotFound() {

        int existentBuyerId = 1;
        int nonExistentSellerId = 124;

        when(buyerRepository.findById(existentBuyerId)).thenReturn(Optional.of(new Buyer()));
        when(sellerRepository.findById(nonExistentSellerId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () ->
                userService.follow(existentBuyerId, nonExistentSellerId));

        verify(buyerRepository).findById(existentBuyerId);
        verify(sellerRepository).findById(nonExistentSellerId);
    }

    @Test
    @DisplayName("T0006 Get users sorted by name asc")
    void getFollowersByIdAsc() {
        // Arrange
        FollowingPostDto expectedFollowingPost = new FollowingPostDto(
                1,
                List.of(
                        new PostDto(
                                1,
                                LocalDate.of(2024, 2, 21),
                                new Product(
                                        12,
                                        "Silla Gamer",
                                        "Gamer",
                                        "Racer",
                                        "Blue & Green",
                                        "Cheap edition"
                                ),
                                1,
                                350000.0
                        ),
                        new PostDto(
                                1,
                                LocalDate.of(2024, 2, 22),
                                new Product(
                                        1,
                                        "Silla Gamer",
                                        "Gamer",
                                        "Racer",
                                        "Blue & Green",
                                        "Cheap edition"
                                ),
                                1,
                                350000.0
                        )
                )
        );


        Post post1 = new Post(
                1,
                LocalDate.of(2024, 2, 22),
                new Product(
                        1,
                        "Silla Gamer",
                        "Gamer",
                        "Racer",
                        "Blue & Green",
                        "Cheap edition"
                ),
                1,
                350000.0
        );

        Post post2 = new Post(
                1,
                LocalDate.of(2024, 2, 21),
                new Product(
                        12,
                        "Silla Gamer",
                        "Gamer",
                        "Racer",
                        "Blue & Green",
                        "Cheap edition"
                ),
                1,
                350000.0
        );

        Seller seller = new Seller(
                1, "Andres Seller Mock", List.of(post1, post2), List.of(
                new Buyer(
                        1, "Andres Buyer Mock", List.of()
                )
        )
        );

        Buyer buyer1 = new Buyer(
                1, "Andres Buyer Mock", List.of(seller)
        );

        when(postRepository.getByIdUser(1L)).thenReturn(List.of(post1, post2));
        when(buyerRepository.findById(1)).thenReturn(Optional.of(buyer1));

        FollowingPostDto actualFollowingPostDto = userService.postSortDate(1, "date_asc");
        assertEquals(expectedFollowingPost, actualFollowingPostDto);
    }


    @Test
    @DisplayName("T-0006 Get users sorted by name desc")
    void getFollowersByIdDesc() {
        // Arrange
        FollowingPostDto expectedFollowingPost = new FollowingPostDto(
                1,
                List.of(
                        new PostDto(
                                1,
                                LocalDate.of(2024, 2, 22),
                                new Product(
                                        1,
                                        "Silla Gamer",
                                        "Gamer",
                                        "Racer",
                                        "Blue & Green",
                                        "Cheap edition"
                                ),
                                1,
                                350000.0
                        ),
                        new PostDto(
                                1,
                                LocalDate.of(2024, 2, 21),
                                new Product(
                                        12,
                                        "Silla Gamer",
                                        "Gamer",
                                        "Racer",
                                        "Blue & Green",
                                        "Cheap edition"
                                ),
                                1,
                                350000.0
                        )
                )
        );


        Post post1 = new Post(
                1,
                LocalDate.of(2024, 2, 22),
                new Product(
                        1,
                        "Silla Gamer",
                        "Gamer",
                        "Racer",
                        "Blue & Green",
                        "Cheap edition"
                ),
                1,
                350000.0
        );

        Post post2 = new Post(
                1,
                LocalDate.of(2024, 2, 21),
                new Product(
                        12,
                        "Silla Gamer",
                        "Gamer",
                        "Racer",
                        "Blue & Green",
                        "Cheap edition"
                ),
                1,
                350000.0
        );

        Seller seller = new Seller(
                1, "Andres Seller Mock", List.of(post1, post2), List.of(
                new Buyer(
                        1, "Andres Buyer Mock", List.of()
                )
        )
        );

        Buyer buyer1 = new Buyer(
                1, "Andres Buyer Mock", List.of(seller)
        );

        when(postRepository.getByIdUser(1L)).thenReturn(List.of(post1, post2));
        when(buyerRepository.findById(1)).thenReturn(Optional.of(buyer1));

        FollowingPostDto actualFollowingPostDto = userService.postSortDate(1, "date_desc");
        assertEquals(expectedFollowingPost, actualFollowingPostDto);
    }


    @Test
    @DisplayName("Camino feliz T-0003 asc")
    void getFollowers() {
        //Arrange
        Integer userId = 1;
        String order = "name_asc";

        List<User> followers = new ArrayList<>(List.of(new User(2, "Fabian"), new User(3, "Stiven")));

        Seller seller = new Seller(1, "Fabian Rodriguez", new ArrayList<>(), followers);
        Optional<Seller> optionalSeller = Optional.of(seller);

        when(sellerRepository.findById(userId)).thenReturn(optionalSeller);

        //Act
        FollowersDto result = userService.getFollowers(userId, order);

        //Assert
        assertEquals(userId, result.getUserId());
        assertEquals("Fabian Rodriguez", result.getUserName());
        assertEquals(seller.getFollowers().size(), result.getFollowers().size());
        assertEquals(seller.getFollowers().get(0).getId(), result.getFollowers().get(0).getUserId());
    }

    @Test
    @DisplayName("Camino feliz T-0003 desc")
    void getFollowersDesc() {
        //Arrange
        Integer userId = 1;
        String order = "name_desc";

        List<User> followers = new ArrayList<>(List.of(new User(3, "Stiven"), new User(2, "Fabian")));

        Seller seller = new Seller(1, "Fabian Rodriguez", new ArrayList<>(), followers);
        Optional<Seller> optionalSeller = Optional.of(seller);

        when(sellerRepository.findById(userId)).thenReturn(optionalSeller);

        //Act
        FollowersDto result = userService.getFollowers(userId, order);

        //Assert
        assertEquals(userId, result.getUserId());
        assertEquals("Fabian Rodriguez", result.getUserName());
        assertEquals(seller.getFollowers().size(), result.getFollowers().size());
        assertEquals(seller.getFollowers().get(0).getId(), result.getFollowers().get(0).getUserId());
    }

    @Test
    @DisplayName("Camino error usuario no existe T-0003")
    void getFollowersFail() {
        //Arrange
        int userId = 1;
        String order = "test";

        List<User> followers = new ArrayList<>(List.of(new User(3, "Stiven"), new User(2, "Fabian")));

        Seller seller = new Seller(1, "Fabian Rodriguez", new ArrayList<>(), followers);
        Optional<Seller> optionalSeller = Optional.of(seller);

        when(sellerRepository.findById(userId)).thenReturn(optionalSeller);


        //Act && Assert
        assertThrows(BadRequestException.class, () -> userService.getFollowers(userId, order));

    }

    @Test
    @DisplayName("Camino error orden invalido T-0003")
    void getFollowersFailOrder() {
        //Arrange
        int userId = 1;
        String order = "name_desc";

        Optional<Seller> optionalSeller = Optional.empty();

        when(sellerRepository.findById(userId)).thenReturn(optionalSeller);

        //Act && Assert
        assertThrows(NotFoundException.class, () -> userService.getFollowers(userId, order));

    }

    @Test
    @DisplayName("T0002_OK")
    void unfollowOk() {
        int existingBuyerId = 1;
        int existingSellerId = 2;

        Buyer mockBuyer = new Buyer(existingBuyerId, "Juan", new ArrayList<>(
                List.of(new Seller(existingSellerId, "Andrés", new ArrayList<>(), new ArrayList<>()))
        ));
        Seller mockSeller = new Seller(existingSellerId, "Andrés", new ArrayList<>(), new ArrayList<>(
                List.of(new Buyer(existingBuyerId, "Juan", new ArrayList<>()))
        ));

        when(buyerRepository.findById(existingBuyerId)).thenReturn(Optional.of(mockBuyer));
        when(sellerRepository.findById(existingSellerId)).thenReturn(Optional.of(mockSeller));

        userService.unfollow(existingBuyerId, existingSellerId);

        assertFalse(mockBuyer.getFollowing().contains(mockSeller));
        assertFalse(mockSeller.getFollowers().contains(mockBuyer));
    }

    @Test
    @DisplayName("T0002_buyer_not_found")
    void unfollow_buyer_notfound() {
        int nonExistingBuyerId = 12;
        int existingSellerId = 2;

        when(buyerRepository.findById(nonExistingBuyerId)).thenReturn(Optional.empty());
        when(sellerRepository.findById(existingSellerId)).thenReturn(Optional.of(new Seller()));

        assertThrows(NotFoundException.class, () -> userService.unfollow(nonExistingBuyerId, existingSellerId));

        verify(buyerRepository).findById(nonExistingBuyerId);
        verify(sellerRepository).findById(existingSellerId);
    }

    @Test
    @DisplayName("T0002_seller_not_found")
    void unfollow_seller_notfound() {
        int existingBuyerId = 12;
        int nonExistingSellerId = 2;

        when(buyerRepository.findById(existingBuyerId)).thenReturn(Optional.of(new Buyer()));
        when(sellerRepository.findById(nonExistingSellerId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> userService.unfollow(existingBuyerId, nonExistingSellerId));

        verify(buyerRepository).findById(existingBuyerId);
        verify(sellerRepository).findById(nonExistingSellerId);
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayName("FEATURE: vendedores seguidos por un comprador")
    class FollowedSellersByBuyer {

        @Test
        @Order(1)
        @DisplayName("No existe usuario/comprador: NotFoundException")
        void getFollowedSellersNotFoundUser() {
            //ARRANGE
            int id = 1000;
            String expectedMessage = "El usuario con el id:" + id + " no se encontró";
            when(buyerRepository.findById(id)).thenReturn(Optional.empty());

            //ACT & ASSERT
            Exception exception =
                    assertThrows(NotFoundException.class,
                            () -> userService.getFollowedSellers(id, null));

            assertEquals(expectedMessage, exception.getMessage());
        }

        //pending BadRequestException

        @Test
        @Order(2)
        @DisplayName("Existe comprador: ok (seguidos sin ordenar)")
        void getFollowedSellersOk() {
            //ARRANGE
            int id = 1000;
            String name = "TestMan";
            Optional<Buyer> user = Optional.of(
                    TestData.getBuyerWithFollowedSellers(id, name));
            when(buyerRepository.findById(id)).thenReturn(user);

            //ACT
            FollowedDTO followedDTO = userService.getFollowedSellers(id, null);

            //ASSERT
            assertNotNull(followedDTO);
            assertNotNull(followedDTO.getFollowed());
            assertEquals(name, followedDTO.getUserName());
            assertEquals(id, followedDTO.getUserId());
        }

        @Test
        @Order(3)
        @DisplayName("Existe comprador: ok (seguidos ordenados asc)")
        void getFollowedSellersSortedByAsc() {
            //ARRANGE
            int id = 1000;
            String name = "TestMan";
            String order = "name_asc";
            Optional<Buyer> user = Optional.of(
                    TestData.getBuyerWithFollowedSellers(id, name));
            when(buyerRepository.findById(id)).thenReturn(user);

            //ACT
            FollowedDTO followedDTO = userService.getFollowedSellers(id, order);

            //ASSERT
            assertNotNull(followedDTO);
            assertNotNull(followedDTO.getFollowed());
            assertTrue(TestData.isFollowedSellersSorted(
                    followedDTO.getFollowed(), order));

        }

        @Test
        @Order(4)
        @DisplayName("Existe comprador: ok (seguidos ordenados desc)")
        void getFollowedSellersSortedByDesc() {
            //ARRANGE
            int id = 1000;
            String name = "TestMan";
            String order = "name_desc";
            Optional<Buyer> user = Optional.of(
                    TestData.getBuyerWithFollowedSellers(id, name));
            when(buyerRepository.findById(id)).thenReturn(user);

            //ACT
            FollowedDTO followedDTO = userService.getFollowedSellers(id, order);

            //ASSERT
            assertNotNull(followedDTO);
            assertNotNull(followedDTO.getFollowed());
            assertTrue(TestData.isFollowedSellersSorted(
                    followedDTO.getFollowed(), order));

        }

        @Test
        @Order(5)
        @DisplayName("Valor de parámetro incorrecto: BadRequestException")
        void getFollowedSellersBadRequestParam() {
            //ARRANGE
            String expectedMessage = "El valor del parámetro order no es correcto";
            int id = 1000;
            String name = "TestMan";
            String order = "name_WRONG";
            Optional<Buyer> user = Optional.of(
                    TestData.getBuyerWithFollowedSellers(id, name));
            when(buyerRepository.findById(id)).thenReturn(user);

            //ACT & ASSERT
            Exception exception =
                    assertThrows(BadRequestException.class,
                            () -> userService.getFollowedSellers(id, order));

            assertEquals(expectedMessage, exception.getMessage());
        }

    }


    @Test
    void testGetFollowedSellers() {
    }

    @Test
    @DisplayName("T0007| followersCount ok case")
    void countSellerFollowersOkTest() {
        //ARRANGE
        int sellerId = 1;
        when(sellerRepository.findById(sellerId)).thenReturn(Optional.of(new Seller(1, "Brayan", new ArrayList<>(), List.of(new User(1, "follower")))));
        //ACT
        FollowersCountDto countDto = userService.countSellerFollowers(sellerId);
        //ASSERT
        assertEquals(1L, countDto.getFollowersCount());
    }

    @Test
    @DisplayName("T0007| followersCount throwError case")
    void countSellerFollowersThrowErrorTest() {
        //ARRANGE
        when(sellerRepository.findById(anyInt())).thenReturn(Optional.empty());
        //ACT & ASSERT
        assertThrows(NotFoundException.class, () -> userService.countSellerFollowers(anyInt()));
    }

    @Test
    void testPostSortDate() {
        // Arrange, Act and Assert
        assertThrows(BadRequestException.class, () -> userService.postSortDate(1, "Order"));
    }

    @Test
    void testPostSortWeeks() {
        // Arrange
        ArrayList<Seller> following = new ArrayList<>();
        Seller vendedor = new Seller();
        List<Post> posts = new ArrayList<>();
        vendedor.setId(1);
        // Objeto 1
        Post post1 = new Post(1, LocalDate.of(2024, 2, 28), null, 1, 10.0);
        posts.add(post1);

        // Objeto 2
        Post post2 = new Post(1, LocalDate.of(2024, 2, 27), null, 1, 10.0);
        posts.add(post2);

        // Objeto 3
        Post post3 = new Post(1, LocalDate.of(2024, 2, 25), null, 1, 10.0);
        posts.add(post3);

        // Objeto 4
        Post post4 = new Post(1, LocalDate.of(2024, 2, 29), null, 1, 10.0);
        posts.add(post4);
        vendedor.setPosts(posts);
        following.add(vendedor);
        Optional<Buyer> ofResult = Optional.of(new Buyer(1, "Name", following));
        when(buyerRepository.findById(anyInt())).thenReturn(ofResult);
        when(postRepository.getByIdUser(anyLong())).thenReturn(posts);
        // Act
        FollowingPostDto actualPostSortWeeksResult = userService.postSortWeeks(1);

        // Assert
        verify(buyerRepository).findById(eq(1));
        assertEquals(4, actualPostSortWeeksResult.getPost().size());
    }
}