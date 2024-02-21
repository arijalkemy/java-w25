package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.*;
import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.InvalidRequestException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotSellerException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotValidDateException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IPostRepo;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import com.bootcamp.be_java_hisp_w25_g14.utils.ApiMapper;
import com.bootcamp.be_java_hisp_w25_g14.utils.HelperFunctions;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleToLongFunction;
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
    public MessageDto savePost(PostDto postDto, boolean isPromo) {
        Optional<User> isUserExists = userRepository.findUserById(postDto.getUser_id());

        if (isUserExists.isEmpty()) throw new NotFoundException("The user does not exist");

        if(!isUserExists.get().getIsSeller()) throw new NotSellerException("The user is not a seller");

        try{
            LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }catch (DateTimeParseException e) {
            throw new NotValidDateException("the date is not valid");
        }

        if(!isPromo){
            postDto.setDiscount(0.0);
            postDto.setHas_promo(false);
        }

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


                /*
                Si la fecha del post está entre hoy y los últimos 15 días, lo mostramos
                 */
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

    /*
        Trabajo Individual
        -Obtener la cantidad de productos en descuento por vendedor
         */
    @Override
    public PromoProductsAmountDto getAmountOfPromoProductsById(Integer id) {

        /* Revisar si existe el usuario */
        Optional<User> isUserExists = userRepository.findUserById(id);
        if (isUserExists.isEmpty()) throw new NotFoundException("The user does not exist");

        /* Revisar si existen posts */
        List<Post> userPosts = postRepository.getPostsById(id);
        if(userPosts.isEmpty()) throw new NotFoundException("There are no posts by this vendor");

        /* Usamos un stream y lambda para contar los productos con descuento */
        Integer promoProductsCount = Math.toIntExact(userPosts.stream().filter(Post::isHasPromo).count());

        /* Devolvemos el DTO */
        return new PromoProductsAmountDto(id,isUserExists.get().getUserName(),promoProductsCount);
    }

    /*
    Trabajo Individual
    -Obtener el mayor descuento en precio total
     */
    @Override
    public LargestPostDiscountDto getLargestPostDiscount() {
        /* Obtenemos todos los posts */
        List<Post> allPosts = postRepository.getAllPosts();
        if(allPosts.isEmpty())throw new NotFoundException("There are currently no posts.");

        /* Este objeto es el que devolveremos */
        LargestPostDiscountDto largestPostDiscountDto = new LargestPostDiscountDto();

        /* Ponemos un valor inicial para poder comparar */
        largestPostDiscountDto.setTotal_discount(0.0);

        /* Iteramos la lista de posts */
        allPosts.forEach(post -> {
            /* Comprobamos que exista el usuario */
            Optional<User> user = userRepository.findUserById(post.getUserId());
            if(user.isEmpty()) throw new NotFoundException("The user with this id does not exist");

            /* Si el post no tiene descuento lo saltamos */
            if(!post.isHasPromo()) return;

            /* Obtenemos los valores necesarios para comparar y en su caso guardarlos */
            Double discountPercentage = post.getDiscount();
            Double price = post.getPrice();
            String userName = user.get().getUserName();
            Integer postId = post.getPostId();

            /* Calculamos el descuento total */
            Double totalDiscount = discountPercentage * price;

            /* Comparamos con el valor máximo actual y actualizamos si es necesario */
            if(totalDiscount > largestPostDiscountDto.getTotal_discount()){
                largestPostDiscountDto.setPost_id(postId);
                largestPostDiscountDto.setDiscount_percentage(discountPercentage);
                largestPostDiscountDto.setPrice(price);
                largestPostDiscountDto.setTotal_discount(totalDiscount);
                largestPostDiscountDto.setUser_name(userName);
            }

        });

        /* Revisamos si no existe un post con descuento */
        if(largestPostDiscountDto.getPost_id() == null) throw new NotFoundException("There are no posts with a discount");

        return largestPostDiscountDto;
    }

    /*
    Trabajo individual
    -Obtener los productos en un rango de precios
     */
    @Override
    public PostsBetweenPriceRangeDto getPostsInRange(String from, String to) {
        /* Convertimos los string en double */
        try{
            Double fromDouble = Double.valueOf(from);
            Double toDouble = Double.valueOf(to);

            /* Revisamos que el rango sea válido */
            if(fromDouble>toDouble) throw new InvalidRequestException("From should not be larger than to");
            if(fromDouble < 0 ) throw new InvalidRequestException("Range should be positive");

            /* Obtenemos todos los posts */
            List<Post> postList = postRepository.getAllPosts();
            if(postList.isEmpty()) throw new NotFoundException("There are no posts currently.");

            /* Filtramos la lista */
            List<Post> filteredList = postList.stream()
                    .filter(post -> {
                        /* Obtenemos el precio del post, si tiene descuento lo aplicamos */
                        Double price = post.getPrice();
                        if(post.isHasPromo()){
                            price = price - (price*post.getDiscount());
                        }

                        /* Lo agregamos a la lista si está dentro del rango */
                        return price>=fromDouble && price<=toDouble;
                    })
                    .toList();

            if(filteredList.isEmpty()) throw new NotFoundException("There are no products within the price range");

            /* Devolvemos el DTO agregando el rango de precios en string y convertimos la lista en lista de DTO */
            return new PostsBetweenPriceRangeDto(
                    MessageFormat.format("{0} - {1}",fromDouble,toDouble),

                    filteredList.stream().map(ApiMapper::convertToPostDto).toList()
            );
        }catch (NumberFormatException ex){
            throw new InvalidRequestException("Ranges should be numeric");
        }

    }
}
