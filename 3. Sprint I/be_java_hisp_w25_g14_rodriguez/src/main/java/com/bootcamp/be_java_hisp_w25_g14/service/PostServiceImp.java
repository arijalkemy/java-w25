package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.*;
import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotSellerException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotValidDateException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IPostRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.utils.ApiMapper;
import com.bootcamp.be_java_hisp_w25_g14.utils.HelperFunctions;
import com.bootcamp.be_java_hisp_w25_g14.repository.UserRepoImp;
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
    public MessageDto savePromoPost(PromoPostDto promoPostDto) {

        /**
        * Esta función toma como base la función de savePost ya que hace las mismas validaciones
         * lo único que cambia es el guardado
        * */
        Optional<User> isUserExists = userRepository.findUserById(promoPostDto.getUser_id());

        if (isUserExists.isEmpty()) throw new NotFoundException("The user does not exist");

        if(!isUserExists.get().getIsSeller()) throw new NotSellerException("The user is not a seller");

        try{
            LocalDate.parse(promoPostDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }catch (DateTimeParseException e) {
            throw new NotValidDateException("the date is not valid");
        }

        /**
         * Esta es la diferencia más importante ya que antes de hacer el guardado
         * se hace uso de un método de la clase ApiMapper que nos permite convertir
         * la clase promoPostDto a la entity Post
         * */
        postRepository.savePost(ApiMapper.convertToPostEntity(promoPostDto));

        return new MessageDto("Post added","The post was added succesfully");

    }
    @Override
    /**
    * Metodo definido para obtener la cantidad de post en promoción de determinado usuario
    * */
    public UserPromoPostCountDto getQtyUserPromoPost(Integer userId) {

        //Primero se valida que exista el usuario

        Optional<User> isUserExists = userRepository.findUserById(userId);
        if (isUserExists.isEmpty()) throw new NotFoundException("The user does not exist");
        if(!isUserExists.get().getIsSeller()) throw new NotSellerException("The user is not a seller");

        //Validado el usuario podemos obtener la lista de post que tiene

        List<Post> listPost = this.postRepository.getAllPosts().stream()
                .filter(post -> post.getUserId().equals(userId) && post.getHas_promo().equals(true))
                .toList();

        /**
        * Es importante aclarar que en el filtro del stream se agrego una validación de getHas_promo
         * porque la entity de Post se modificó para que tuviera todos los campos, incluyendo los
         * de post con promoción pero setteando sus valores para dichos atributos como
         * false para el caso de has_promo y null para el campo "discount"
        * */
        if (listPost.isEmpty()) {
            throw new NotSellerException("This seller has no discounts");
        }
        else {
            //Aquí regresamos un objeto que contenga los campos necesarios para la respuesta
            return new UserPromoPostCountDto(
                    userId,
                    isUserExists.get().getUserName(),
                    listPost.size()
            );
        }
    }

    @Override
    public List<Post> getPromoPostList(Integer userId){
        /**
         * Esta función es muy parecida a la anterior ya que toma la misma base y la misma lógica
         * lo único que la hace diferente es el tipo de valor que retorna, en este caso
         * se retorna la lista de post que han cumplido con los criterios de filtrado
         * del stream que nos garantiza que dichas publicaciones tengan promoción
        * */

        Optional<User> isUserExists = userRepository.findUserById(userId);
        if (isUserExists.isEmpty()) throw new NotFoundException("The user does not exist");
        if(!isUserExists.get().getIsSeller()) throw new NotSellerException("The user is not a seller");

        List<Post> listPost = this.postRepository.getAllPosts().stream()
                .filter(post -> post.getUserId().equals(userId) && post.getHas_promo().equals(true))
                .toList();
        if (listPost.isEmpty()) {
            throw new NotSellerException("This seller has no discounts");
        }
        else {
            return listPost;
        }
    }
}
