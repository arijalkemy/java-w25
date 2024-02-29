package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserDataDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowedPostDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.Product;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.InvalidRequestException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IPostRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.utils.ApiMapper;
import com.bootcamp.be_java_hisp_w25_g14.utils.HelperFunctions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    IUserRepo userRepo;
    @Mock
    IPostRepo postRepo;
    @InjectMocks
    PostServiceImp postServiceImp;

    /* T - 0005 CASO FELIZ:
   Verificar que el tipo de ordenamiento
   por fecha exista (US-0009) date_asc , date_desc
    */
    @Test
    @DisplayName("T0005 - Caso feliz")
    void dateSortingOk(){
        /* Arrange */
        Integer id = 1;
        String sorted = "date_asc";

        //Create mock list of vendors the user follows
        List<UserDataDto> followedUsers = List.of(
                new UserDataDto(2,"jacob"),
                new UserDataDto(3,"hector")
        );

        //Create 2 mock lists with posts
        List<Post> postsUser1 = generateMockPosts(followedUsers.get(0).getUser_id());
        List<Post> postsUser2 = generateMockPosts(followedUsers.get(1).getUser_id());

        //Merge both lists into one
        List<PostDto> postsOfLastTwoWeeks = new java.util.ArrayList<>();
        postsOfLastTwoWeeks.addAll(postsUser1.stream().map(ApiMapper::convertToPostDto)
                .filter(this::postIsWithinLastTwoWeeksFilter).toList());
        postsOfLastTwoWeeks.addAll(postsUser2.stream().map(ApiMapper::convertToPostDto)
                .filter(this::postIsWithinLastTwoWeeksFilter).toList());

        //Create expectedResult object
        UserFollowedPostDto expectedResult = new UserFollowedPostDto(
                id,
                HelperFunctions.sortPostsByDateAscending(postsOfLastTwoWeeks)
        );

        when(userRepo.getFollowed(id)).thenReturn(followedUsers);
        when(postRepo.getPostsById(followedUsers.get(0).getUser_id()))
                .thenReturn(postsUser1);
        when(postRepo.getPostsById(followedUsers.get(1).getUser_id()))
                .thenReturn(postsUser2);
        /* Act */
        UserFollowedPostDto actual = this.postServiceImp.getFollowedPostsByUserLastTwoWeeks(id,sorted);

        /* Assert */
        assertEquals(expectedResult,actual);
    }

    /* T - 0005 CASO TRISTE (PARAMETRO INVALIDO):
        Verificar que el tipo de ordenamiento
        por fecha exista (US-0009) date_asc , date_desc
    */
    @Test
    @DisplayName("T0005 - InvalidParameter")
    void dateSortingInvalidParameterTest(){
        //Arrange
        Integer id = 1;
        String sorted = "date_ascending";
        //Act & Assert
        assertThrows(InvalidRequestException.class, ()->{
            this.postServiceImp.getFollowedPostsByUserLastTwoWeeks(id,sorted);
        });

    }

    @Test
    @DisplayName("T0005 - No followed users")
    void dateSortingEmptyFollowedListTestNotFoundException(){
        //Arrange
        Integer id = 15;
        String sorted = "date_asc";
        //Act & Assert
        when(userRepo.getFollowed(id)).thenReturn(List.of());

        assertThrows(NotFoundException.class, ()->{
            this.postServiceImp.getFollowedPostsByUserLastTwoWeeks(id,sorted);
        });
    }

    @Test
    @DisplayName("T0005 - No posts within last two weeks")
    void dateSortingNoPostsWithinLastTwoWeeksNotFoundException(){
        /* Arrange */
        Integer id = 1;
        String sorted = "date_asc";

        List<UserDataDto> followedUsers = List.of(
                new UserDataDto(2,"jacob"),
                new UserDataDto(3,"hector")
        );

        //Create 2 mock lists with posts
        List<Post> postsUser1 = generateMockPosts(4);

        when(userRepo.getFollowed(id)).thenReturn(followedUsers);
        when(postRepo.getPostsById(followedUsers.get(0).getUser_id()))
                .thenReturn(postsUser1);

        /* Act & Assert */

        assertThrows(NotFoundException.class, ()->{
            this.postServiceImp.getFollowedPostsByUserLastTwoWeeks(id,sorted);
        });
    }

    /* T - 0006 CASO FELIZ ASCENDENTE:
       Verificar el correcto ordenamiento ascendente
       y descendente por fecha. (US-0009)
    */
    @Test
    @DisplayName("T0006 - Caso feliz Orden Ascendente")
    void getFollowedPostsByUserLastWeeksOrderAscendingOk(){
        /* Arrange */
        Integer id = 1;
        String sorted = "date_asc";

        //Create mock list of vendors the user follows
        List<UserDataDto> followedUsers = List.of(
                new UserDataDto(2,"jacob"),
                new UserDataDto(3,"hector")
        );

        //Create 2 mock lists with posts
        List<Post> postsUser1 = generateMockPosts(followedUsers.get(0).getUser_id());
        List<Post> postsUser2 = generateMockPosts(followedUsers.get(1).getUser_id());

        //Merge both lists into one
        List<PostDto> postsOfLastTwoWeeks = new java.util.ArrayList<>();
        postsOfLastTwoWeeks.addAll(postsUser1.stream().map(ApiMapper::convertToPostDto)
                .filter(this::postIsWithinLastTwoWeeksFilter).toList());
        postsOfLastTwoWeeks.addAll(postsUser2.stream().map(ApiMapper::convertToPostDto)
                .filter(this::postIsWithinLastTwoWeeksFilter).toList());


        //Create expectedResult object
        UserFollowedPostDto expectedResult = new UserFollowedPostDto(
                id,
                HelperFunctions.sortPostsByDateAscending(postsOfLastTwoWeeks)
        );

        when(userRepo.getFollowed(id)).thenReturn(followedUsers);
        when(postRepo.getPostsById(followedUsers.get(0).getUser_id()))
                .thenReturn(postsUser1);
        when(postRepo.getPostsById(followedUsers.get(1).getUser_id()))
                .thenReturn(postsUser2);

        /* Act */
        UserFollowedPostDto actual = this.postServiceImp.getFollowedPostsByUserLastTwoWeeks(id,sorted);

        /* Assert */
        assertEquals(expectedResult,actual);

    }

    /* T - 0006 CASO FELIZ DESCENDIENTE:
       Verificar el correcto ordenamiento ascendente
       y descendente por fecha. (US-0009)
    */
    @Test
    @DisplayName("T0006 - Caso feliz Orden Descendiente")
    void getFollowedPostsByUserLastWeeksOrderDescendingOk(){
        /* Arrange */
        Integer id = 1;
        String sorted = "date_desc";

        //Create mock list of vendors the user follows
        List<UserDataDto> followedUsers = List.of(
                new UserDataDto(2,"jacob"),
                new UserDataDto(3,"hector")
        );

        //Create 2 mock lists with posts
        List<Post> postsUser1 = generateMockPosts(followedUsers.get(0).getUser_id());
        List<Post> postsUser2 = generateMockPosts(followedUsers.get(1).getUser_id());

        //Merge both lists into one
        List<PostDto> postsOfLastTwoWeeks = new java.util.ArrayList<>();
        postsOfLastTwoWeeks.addAll(postsUser1.stream().map(ApiMapper::convertToPostDto)
                .filter(this::postIsWithinLastTwoWeeksFilter).toList());
        postsOfLastTwoWeeks.addAll(postsUser2.stream().map(ApiMapper::convertToPostDto)
                .filter(this::postIsWithinLastTwoWeeksFilter).toList());


        //Create expectedResult object
        UserFollowedPostDto expectedResult = new UserFollowedPostDto(
                id,
                HelperFunctions.sortPostsByDateDescending(postsOfLastTwoWeeks)
        );

        when(userRepo.getFollowed(id)).thenReturn(followedUsers);
        when(postRepo.getPostsById(followedUsers.get(0).getUser_id()))
                .thenReturn(postsUser1);
        when(postRepo.getPostsById(followedUsers.get(1).getUser_id()))
                .thenReturn(postsUser2);

        /* Act */
        UserFollowedPostDto actual = this.postServiceImp.getFollowedPostsByUserLastTwoWeeks(id,sorted);

        /* Assert */
        assertEquals(expectedResult,actual);

    }


    /*
     * T0008
     *
     * */

    @Test
    @DisplayName("T0008 - validate that posts are from 15 days ago")
    public void validatePostSellerIsOnDateRangeOk() {
        /* Arrange */
        Integer id = 1;
        String sorted = "date_asc";

        //Create mock list of vendors the user follows
        List<UserDataDto> followedUsers = List.of(
                new UserDataDto(2,"jacob"),
                new UserDataDto(3,"hector")
        );

        //Create 2 mock lists with posts
        List<Post> postsUser1 = generateMockPosts(followedUsers.get(0).getUser_id());
        List<Post> postsUser2 = generateMockPosts(followedUsers.get(1).getUser_id());

        //Merge both lists into one
        List<PostDto> postsOfLastTwoWeeks = new java.util.ArrayList<>();
        postsOfLastTwoWeeks.addAll(postsUser1.stream().map(ApiMapper::convertToPostDto)
                .filter(this::postIsWithinLastTwoWeeksFilter).toList());
        postsOfLastTwoWeeks.addAll(postsUser2.stream().map(ApiMapper::convertToPostDto)
                .filter(this::postIsWithinLastTwoWeeksFilter).toList());

        //Create expectedResult object
        UserFollowedPostDto expectedResult = new UserFollowedPostDto(
                id,
                HelperFunctions.sortPostsByDateAscending(postsOfLastTwoWeeks)
        );

        when(userRepo.getFollowed(id)).thenReturn(followedUsers);
        when(postRepo.getPostsById(followedUsers.get(0).getUser_id()))
                .thenReturn(postsUser1);
        when(postRepo.getPostsById(followedUsers.get(1).getUser_id()))
                .thenReturn(postsUser2);
        /* Act */
        UserFollowedPostDto actual = this.postServiceImp.getFollowedPostsByUserLastTwoWeeks(id,sorted);



        /* Assert */
        //assertEquals(expectedResult,actual);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //LocalDate postDate = LocalDate.parse(post.getDate(), formatter);
        LocalDate today = LocalDate.now();

        assertTrue(actual.getPosts().stream().allMatch(postDto -> {
            LocalDate postDate = LocalDate.parse(postDto.getDate(), formatter);

            return postDate.isBefore(today.plusDays(1)) && postDate.isAfter(today.minusDays(15));
        }));

    }


    @Test
    @DisplayName("T0008 - validate if posts are empty throws NotFoundException")
    public void validatePostSellerIsOnDateRangeNotFoundException() {
        /* Arrange */
        Integer id = 1;
        String sorted = "date_asc";

        //Create mock list of vendors the user follows
        List<UserDataDto> followedUsers = List.of(
                new UserDataDto(2,"jacob"),
                new UserDataDto(3,"hector")
        );

        //Create 2 mock lists with posts
        List<Post> postsUser1 = generateMockPosts(followedUsers.get(0).getUser_id());
        List<Post> postsUser2 = generateMockPosts(followedUsers.get(1).getUser_id());

        when(userRepo.getFollowed(id)).thenReturn(followedUsers);
        when(postRepo.getPostsById(followedUsers.get(0).getUser_id()))
                .thenReturn(new ArrayList<>());


        assertThrows(NotFoundException.class,() ->postServiceImp.getFollowedPostsByUserLastTwoWeeks(id,sorted));

    }



    private List<Post> generateMockPosts(Integer id){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if(id==2){
            return List.of(
                    new Post(2,2,LocalDate.parse("15-02-2024", formatter), new Product(2,"ASUS ROG","Gamer","Asus","Negro","nueva"),10,15000.0),
                    new Post(4,2,LocalDate.parse("01-02-2024", formatter), new Product(4,"Teclado Gamer","Gamer","HyperX","Negro","Elite Alloy"),10,2300.0)
            );
        }else if(id==3){
            return List.of(
                    new Post(3, 3, LocalDate.parse("11-02-2024", formatter), new Product(3, "Silla gamer", "Gamer", "Racer", "Negro y azul", "special edition"), 100, 1500.0),
                    new Post(5, 3, LocalDate.parse("01-01-2024", formatter), new Product(56, "Mouse", "Office", "Logitech", "Negro", "G203"), 40, 200.0),
                    new Post(6, 3, LocalDate.parse("18-02-2024", formatter), new Product(12, "Termo", "Office", "Yeti", "Gris", "Large"), 40, 1200.0)
            );
        }else{
            return List.of(
                    new Post(2,2,LocalDate.parse("30-01-2024", formatter), new Product(2,"ASUS ROG","Gamer","Asus","Negro","nueva"),10,15000.0),
                    new Post(4,2,LocalDate.parse("20-01-2024", formatter), new Product(4,"Teclado Gamer","Gamer","HyperX","Negro","Elite Alloy"),10,2300.0)
            );
        }

    }

    private boolean postIsWithinLastTwoWeeksFilter(PostDto postDto){
        LocalDate today = LocalDate.now();

                /*
                Especificamos que nuestras fechas están en formato dd-mm-yyyy para parsear
                 */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate postDate = LocalDate.parse(postDto.getDate(), formatter);

        return postDate.isBefore(today.plusDays(1)) && postDate.isAfter(today.minusDays(15));
    }

}
