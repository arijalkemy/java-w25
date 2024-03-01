package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.MessageDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserDataDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowedPostDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.InvalidRequestException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotSellerException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IPostRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.utils.ApiMapper;
import com.bootcamp.be_java_hisp_w25_g14.utils.HelperFunctions;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PostServiceImp implements IPostService{

    private final IPostRepo postRepository;
    private final IUserRepo userRepository;

    public PostServiceImp(IPostRepo postRepository, IUserRepo userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public MessageDto savePost(PostDto postDto) {
        Optional<User> isUserExists = userRepository.findUserById(postDto.getUser_id());

        if (isUserExists.isEmpty()) throw new NotFoundException("The user does not exist");

        if(!isUserExists.get().getIsSeller()) throw new NotSellerException("The user is not a seller");

        /*try{
            LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }catch (DateTimeParseException e) {
            throw new NotValidDateException("the date is not valid");
        }*/

        postRepository.savePost(ApiMapper.convertToPostEntity(postDto));

        return new MessageDto("Post added","The post was added succesfully");

    }

    @Override
    public List<PostDto> getAllPosts() {
        List<PostDto> postDtoList = postRepository.getAllPosts().stream().map(ApiMapper::convertToPostDto).collect(Collectors.toList());

        if (postDtoList.isEmpty()) throw new NotFoundException("There is no posts");

        return postDtoList;
    }

    @Override
    public UserFollowedPostDto getFollowedPostsByUserLastTwoWeeks(Integer id, String sorted) {
        //Check if sorted parameter is wrong
        if(sorted!=null && !(sorted.equals("date_asc") || sorted.equals("date_desc")))
            throw new InvalidRequestException("The order parameter should be either date_asc or date_desc.");

        List<PostDto> postsOfLastTwoWeeks = new ArrayList<>();
        List<UserDataDto> followedUsers = userRepository.getFollowed(id);

        if(followedUsers.isEmpty())
            throw new NotFoundException("User with id: "+id+" does not follow anyone");

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


                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                //LocalDate postDate = LocalDate.parse(post.getDate(), formatter);

                LocalDate postDate = post.getDate();

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
        } else if (sorted != null) {
            return new UserFollowedPostDto(id,HelperFunctions.sortPostsByDateDescending(postsOfLastTwoWeeks));
        }

        //Default sort is in descending order
        return new UserFollowedPostDto(id,HelperFunctions.sortPostsByDateDescending(postsOfLastTwoWeeks));
    }
}
