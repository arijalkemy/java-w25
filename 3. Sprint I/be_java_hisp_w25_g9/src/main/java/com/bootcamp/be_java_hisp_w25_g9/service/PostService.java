package com.bootcamp.be_java_hisp_w25_g9.service;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDtoMixIn;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDtoMixin;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PromoPostDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.*;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g9.model.*;
import com.bootcamp.be_java_hisp_w25_g9.model.Post;
import com.bootcamp.be_java_hisp_w25_g9.model.Product;
import com.bootcamp.be_java_hisp_w25_g9.model.Seller;
import com.bootcamp.be_java_hisp_w25_g9.model.User;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IProductRepository;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IProductRepository;
import com.bootcamp.be_java_hisp_w25_g9.service.interfaces.IPostService;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;
    ObjectMapper mapper = new ObjectMapper();

    public PostService(IPostRepository postRepository, IUserRepository userRepository, IProductRepository productRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        mapper.registerModule(new JavaTimeModule());
        mapper.addMixIn(Product.class, ProductDtoMixIn.class);
        mapper.addMixIn(Post.class, PostRequestDtoMixin.class);
        mapper.addMixIn(PromoPost.class, PromoPostDto.class);
    }

    @Override
    public MessageDto createPromoPost(PromoPostDto promoPostDto) {
        PromoPost promoPost = mapper.convertValue(promoPostDto, PromoPost.class);
        createProduct(promoPostDto.userId(), promoPostDto.product());
        postRepository.addPost(promoPost);
        return new MessageDto("Publicacion de promocion creada con exito");
    }

    @Override
    public MessageDto createPost(PostRequestDto postRequestDto) {
        Post post = mapper.convertValue(postRequestDto, Post.class);
        createProduct(postRequestDto.user_id(), postRequestDto.product());
        postRepository.addPost(post);
        return new MessageDto("Publicación creada con éxito");
    }

    public void createProduct(int userId, ProductDto productDto){
        User seller = userRepository.getUserById(userId);
        if (seller == null || !seller.getClass().equals(Seller.class)){
            throw new NotFoundException("El usuario no se encuentra o no es vendedor");
        }
        Product product = mapper.convertValue(productDto, Product.class);
        Product productFromRepository = productRepository.getProductById(product.getProductId());
        if (productFromRepository == null){
            product.setProductId(productRepository.findAll().size());
            productRepository.addProduct(product);
        } else if(!productFromRepository.equals(product)){
            throw new BadRequestException("El identificador del producto no corresponde con el registrado");
        }
        product.setProductId(postRepository.findAll().size());
    }

    @Override
    public FollowedPostsDto getPost(int userId) {
        return new FollowedPostsDto(userId, getPostsByuserId(userId).stream()
                .map(post -> mapper.convertValue(post, PostResponseDto.class))
                .sorted(Comparator.comparing(PostResponseDto::date).reversed()).toList());
    }

//    @Override
//    public FollowedPostsDto getPromoPost(int userId) {
//        return new FollowedPostsDto(
//                userId,
//                getPromoPostByUserId(userId).stream()
//                        .map(post -> mapper.convertValue(post, PostResponseDto.class)).toList()
//        );
//    }
//
//    public List<PromoPost> getPromoPostByUserId(int userId){
//        return getPostsByuserId(userId).stream()
//                .filter(post -> post instanceof PromoPost)
//                .map(post -> (PromoPost)post).toList();
//    }

    public List<Post> getPostsBySellerId(int sellerId){
        if(!userRepository.userExists(sellerId)) throw new NotFoundException("El vendedor no existe");
        List<Post> postsList = postRepository.findAll().stream().filter(post -> post.getUserId() == sellerId).toList();
        if(postsList.isEmpty()) throw new NotFoundException("El vendedor no tiene publicaciones en el momento");
        return postsList;
    }

    public List<PromoPost> getPromoPostBySellerId(int sellerId){
        List<PromoPost> promoPosts = getPostsBySellerId(sellerId).stream()
                .filter(post -> post instanceof PromoPost)
                .map(post -> (PromoPost)post).toList();
        if(promoPosts.isEmpty()) throw new NotFoundException("El vendedor no tiene publicaciones en promocion en el momento ");
        return promoPosts;
    }

    @Override
    public PromoPostCountDto getCountPromoPost(int sellerId) {
        int count = getPromoPostBySellerId(sellerId).size();
        User seller = userRepository.getUserById(sellerId);
        return new PromoPostCountDto(sellerId, seller.getUserName(), count);
    }

    public List<Post> getPostsByuserId(int userId){
        if(!userRepository.userExists(userId)) throw new NotFoundException(MessageFormat.format("El usuario con id {0} no existe",userId));
        List<Seller> followedList = userRepository.getUserById(userId).getFollowed();
        if(followedList.isEmpty()){
            throw new NotFoundException(MessageFormat.format("El usuario {0} no tiene vendedores seguidos", userId));
        }
        List<Post> postsLlist = postRepository.findAll();
        List<Post> lastestPosts = new ArrayList<>();
        for (Seller seller : followedList) {
            lastestPosts.addAll(
                    postsLlist.stream()

                            .filter(post -> {
                                            return compareDates(post.getDate(), LocalDate.now()) &&
                                         post.getUserId() == seller.getUserId() ;
                                    }
                            )
                            .toList());
        }
        if(lastestPosts.isEmpty()){
            throw new NotFoundException(MessageFormat.format("No se encontraron post de los vendedores seguidos del usuario {0}",userId));
        }
        return lastestPosts;
    }

    public boolean compareDates(LocalDate date1, LocalDate date2){
        long compDate = ChronoUnit.DAYS.between(date1, date2);
        double compDateWeeks = compDate/7.0;
        return compDateWeeks >= 0  && compDateWeeks <= 2.0;
    }

    @Override
    public FollowedPostsDto getPost(int userId, String order) {
        FollowedPostsDto followedPost;
        switch (order){
            case "date_asc" -> {
                return new FollowedPostsDto(
                        userId,
                        getPostsByuserId(userId).stream()
                                .map(post -> mapper.convertValue(post, PostResponseDto.class))
                                .sorted(Comparator.comparing(PostResponseDto::date)).toList());
            }
            case "date_desc" -> {
                return new FollowedPostsDto(
                        userId,
                        getPostsByuserId(userId).stream()
                                .map(post -> mapper.convertValue(post, PostResponseDto.class))
                                .sorted(Comparator.comparing(PostResponseDto::date).reversed()).toList());
            }
            default -> throw new BadRequestException(MessageFormat.format("{0} no es valido, recuerde que debe ingresar 'date_asc' o 'date_desc'", order));
        }
    }
}
