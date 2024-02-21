package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.*;
import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.*;
import com.bootcamp.be_java_hisp_w25_g14.repository.IPostRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.utils.ApiMapper;
import com.bootcamp.be_java_hisp_w25_g14.utils.HelperFunctions;
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
    public MessageDto savePostDiscount(PostFullDto postFullDto) {

        Optional<User> isUserExists = userRepository.findUserById(postFullDto.getUser_id());

        if (isUserExists.isEmpty()) throw new NotFoundException("The user does not exist");

        if(!isUserExists.get().getIsSeller()) throw new NotSellerException("The user is not a seller");

        try{
            LocalDate.parse(postFullDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }catch (DateTimeParseException e) {
            throw new NotValidDateException("the date is not valid");
        }


        if (postFullDto.getIsOnDiscount().equals(true)){

            try{
                LocalDate.parse(postFullDto.getDiscountUntil(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }catch (DateTimeParseException e) {
                throw new NotValidDateException("the end date of discount is not valid");
            }

            if (LocalDate.parse(postFullDto.getDiscountUntil(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    .isBefore(LocalDate.parse(postFullDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")))) throw new NotValidDateException("the end date of discount before than the publication date");

        }



        Post postToSave = ApiMapper.convertToPostEntity(postFullDto);



        postRepository.savePost(postToSave);

        return new MessageDto("Post added","The post was added succesfully");


    }

    @Override
    public List<PostDto> getAllPosts() {
        List<PostDto> postDtoList = postRepository.getAllPosts().stream().map(post -> ApiMapper.convertToPostDto(post)).collect(Collectors.toList());

        if (postDtoList.isEmpty()) throw new NotFoundException("There is no posts");

        return postDtoList;
    }

    @Override
    public List<PostFullDto> getAllPostsFull() {
        List<PostFullDto> postFullDtoList = postRepository.getAllPosts().stream().map(post -> ApiMapper.convertToPostFullDto(post)).collect(Collectors.toList());
        if (postFullDtoList.isEmpty()) throw new NotFoundException("There is no posts");

        return postFullDtoList;
    }

    @Override
    public List<PostFullDto> getPostOnDiscountBySeller(Integer id) {
        List<PostFullDto> postFullDtoList = postRepository.getPostsOnDiscountByVendor(id).stream().map(post -> ApiMapper.convertToPostFullDto(post)).collect(Collectors.toList());

        if (postFullDtoList.isEmpty()) throw new NotFoundException("There is no posts for this user");

        return postFullDtoList;
    }

    @Override
    public PostOnDiscountCountDto postOnDiscountCountBySeller(Integer id) {
        Optional<User> optionalUser = userRepository.findUserById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (!user.getIsSeller())
                throw new FollowException("The user is not a seller");
            int postsOnDiscount = postRepository.getPostsOnDiscountByVendor(id).size();
            return new PostOnDiscountCountDto (id, user.getUserName(), postsOnDiscount);
        } else {
            throw new NotFoundException("User not found");
        }
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

                return postDate.isBefore(today.plusDays(1)) && postDate.isAfter(today.minusDays(15));
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
