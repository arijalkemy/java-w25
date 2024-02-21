package com.bootcamp.be_java_hisp_w25_g14_Lozano.service;

import com.bootcamp.be_java_hisp_w25_g14_Lozano.dto.*;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.entity.User;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.exceptions.NotSellerException;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.exceptions.NotValidDateException;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.repository.IPostRepo;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.utils.ApiMapper;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.utils.HelperFunctions;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PostServiceImp implements IPostService{

    private IPostRepo postRepository;
    private IUserRepo userRepository;

    public PostServiceImp(IPostRepo postRepository, IUserRepo userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PostDto>  listProductPostCount(Integer userId) {
        Optional<User> optionalUser = userRepository.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (!user.getIsSeller())
                throw new FollowException("The user is not a seller");

            List<Post> products = this.postRepository.getPostsById(user.getUserId()).stream()
                    .filter(post -> post.getHasPromo().equals(true)).toList();

            return products.stream().map(ApiMapper::convertToPostDto).toList();
        } else {
            throw new NotFoundException("Post not found");
        }

    }

    /* 11. Obtener la cantidad de productos en promoción de un determinado vendedor */
    @Override
    public ProductPromoCountDto getProductPostCount(Integer userId) {
        Optional<User> optionalUser = userRepository.findUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (!user.getIsSeller())
                throw new FollowException("The user is not a seller");

            List<Post> products = this.postRepository.getPostsById(user.getUserId());

            Integer productsCount = (int) products.stream()
                    .filter(Post::getHasPromo).count();
            return new ProductPromoCountDto(userId, user.getUserName(), productsCount);
        } else {
            throw new NotFoundException("Post not found");
        }

    }


    @Override
    public MessageDto savePost(PostDto postDto) {
        Optional<User> isUserExists = userRepository.findUserById(postDto.getUser_id());

        if (isUserExists.isEmpty()) throw new NotFoundException("The user does not exist");

        if(!isUserExists.get().getIsSeller()) throw new NotSellerException("The user is not a seller");

        try{
            LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }catch (DateTimeParseException e) {
            throw new NotValidDateException("the date is not valid");
        }

        postRepository.savePost(ApiMapper.convertToPostEntity(postDto));

        return new MessageDto("Post added","The post was added succesfully");

    }

    @Override
    public List<PostDto> getAllPosts() {
        List<PostDto> postDtoList = postRepository.getAllPosts().stream().map(post -> ApiMapper.convertToPostDto(post)).collect(Collectors.toList());

        if (postDtoList.isEmpty()) throw new NotFoundException("There is no posts");

        return postDtoList;
    }

    @Override
    public UserFollowedPostDto getFollowedPostsByUserLastTwoWeeks(Integer id, String sorted) {
        List<PostDto> postsOfLastTwoWeeks = new ArrayList<>();
        List<UserDataDto> followedUsers = userRepository.getFollowed(id);

        for(UserDataDto user : followedUsers){
            List<Post> userPosts = postRepository.getPostsById(user.getUser_id());

            /*
            Filtramos todos los posts del usuario para sólo aceptar posts de
            las últimas dos semanas
             */
            userPosts = userPosts.stream().filter(post -> {
                LocalDate today = LocalDate.now();

                /*
                Especificamos que nuestras fechas están en formato dd-mm-yyyy para parsear
                 */
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate postDate = LocalDate.parse(post.getDate(), formatter);

                return today.minusWeeks(2).isBefore(postDate);
            }).toList();

            postsOfLastTwoWeeks.addAll(userPosts.stream().map(ApiMapper::convertToPostDto).toList());
        }

        if(postsOfLastTwoWeeks.isEmpty()) throw new NotFoundException("There are no posts within the last two weeks");


        /*
        Sorteamos la lista si el usuario lo especifica (ascendente o descendente)
         */
        if(sorted!=null && sorted.equals("date_asc")){
            return new UserFollowedPostDto(id,HelperFunctions.sortPostsByDateAscending(postsOfLastTwoWeeks));
        } else if (sorted!=null && sorted.equals("date_desc")) {
            return new UserFollowedPostDto(id,HelperFunctions.sortPostsByDateDescending(postsOfLastTwoWeeks));
        }

        return new UserFollowedPostDto(id,HelperFunctions.sortPostsByDateDescending(postsOfLastTwoWeeks));
    }
}
