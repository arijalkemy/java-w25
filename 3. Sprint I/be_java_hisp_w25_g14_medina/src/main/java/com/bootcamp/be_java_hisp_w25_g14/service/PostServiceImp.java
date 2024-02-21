package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.*;
import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.BadRequestBodyException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotSellerException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotValidDateException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IPostRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.utils.ApiMapper;
import com.bootcamp.be_java_hisp_w25_g14.utils.HelperFunctions;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
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
    public MessageDto savePromoPost(PromoPostDto postDto) {
        validateAndGetSeller(postDto.getUser_id());
        try{
            LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }catch (DateTimeParseException e) {
            throw new NotValidDateException("the date is not valid");
        }

        if (postDto.getPrice()<=0.0)
            throw new BadRequestBodyException("The price can't be negative or zero");
        postRepository.savePost(ApiMapper.convertToPostEntity(postDto));

        return new MessageDto(" Promo  added","The promo post was added successfully");
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


    @Override
    public CountPromoPostDto getPromoProductsCount(Integer userId) {
        User seller = validateAndGetSeller(userId);
        List<Post> promoPost = validateAndGetPostList(userId);

        return new CountPromoPostDto(
                seller.getUserId(),
                seller.getUserName(),
                promoPost.size()
        );
    }

    @Override
    public ListPromoPostDto getPromoProductsList(Integer userId) {
        User seller = validateAndGetSeller(userId);
        List<PromoPostDto> promoPost = validateAndGetPostList(userId).stream().map(ApiMapper::convertToPromoPostDto).toList();

        return new ListPromoPostDto(
                seller.getUserId(),
                seller.getUserName(),
                promoPost
        );
    }



    @Override
    public BestPromoDto getBestPromo(Integer userId) {
        List<Post> posts = getListPostFollowed(userId);
        //filtrado de post de promocion y obtencion de mayor descuento
        //en base de precio por el descuento
        Optional<Post> bestPromo = posts.stream().filter(Post::getHasPromo)
                .max(Comparator.comparing(post -> post.getPrice()* post.getDiscount()));

        if(bestPromo.isEmpty())
            throw new NotFoundException("There is no Promos");
        return new BestPromoDto(bestPromo.get());
    }

    /*
    Funcion para obtener todos los post de nuestros seguidos
     */
    private List<Post> getListPostFollowed(Integer userId){
        List<Post> followPosts = new ArrayList<>();
        List<UserDataDto> followedUsers = userRepository.getFollowed(userId);
        for(UserDataDto user : followedUsers){
            followPosts.addAll(postRepository.getPostsById(user.getUser_id()));
        }
        if (followPosts.isEmpty())
            throw new NotFoundException("No posts Found");

        return followPosts;
    }

    private List<Post> validateAndGetPostList(Integer sellerId){
        List<Post> promoPost = this.postRepository.getPromoPost(sellerId);
        if (promoPost.isEmpty()) throw new NotFoundException("No Promo founded for that Id");
        return promoPost;
    }
    private User validateAndGetSeller(Integer sellerId){
        Optional<User> seller = userRepository.findUserById(sellerId);
        if (seller.isEmpty()) throw new NotFoundException("The user does not exist");
        if(!seller.get().getIsSeller()) throw new NotSellerException("The user is not a seller");
        return seller.get();
    }
}
