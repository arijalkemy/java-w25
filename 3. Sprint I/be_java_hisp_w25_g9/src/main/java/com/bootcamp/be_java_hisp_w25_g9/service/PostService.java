package com.bootcamp.be_java_hisp_w25_g9.service;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDtoMixIn;
import com.bootcamp.be_java_hisp_w25_g9.dto.PromoPostDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDtoMixin;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PromoPostRequestDtoMixin;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.*;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g9.model.*;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IProductRepository;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w25_g9.service.interfaces.IPostService;
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
        mapper.addMixIn(PromoPost.class, PromoPostRequestDtoMixin.class);
    }

    @Override
    public MessageDto createPost(PostRequestDto postRequestDto) {
        User seller = userRepository.getUserById(postRequestDto.user_id());
        if (seller == null || !seller.getClass().equals(Seller.class)){
            throw new NotFoundException("El usuario no se encuentra o no es vendedor");
        }
        Product product = mapper.convertValue(postRequestDto.product(), Product.class);
        Product productFromRepository = productRepository.getProductById(product.getProductId());
        if (productFromRepository == null){
            product.setProductId(productRepository.findAll().size());
            productRepository.addProduct(product);
        } else if(!productFromRepository.equals(product)){
            throw new BadRequestException("El identificador del producto no corresponde con el registrado");
        }
        Post post = mapper.convertValue(postRequestDto, Post.class);
        post.setId(postRepository.findAll().size());
        postRepository.addPost(post);
        return new MessageDto("Publicación creada con éxito");
    }
    //US 10 Individual
    @Override
    public MessageDto createPromoPost(PromoPostRequestDto promoPostRequestDto) {
        User seller = userRepository.getUserById(promoPostRequestDto.user_id());

        if (seller == null || !(seller instanceof Seller)){
            throw new NotFoundException("El usuario no se encuentra o no es vendedor");
        }

        Product product = mapper.convertValue(promoPostRequestDto.product(), Product.class);
        Product productFromRepository = productRepository.getProductById(product.getProductId());
        if (productFromRepository == null){
            //product.setProductId(productRepository.findAll().size());
            productRepository.addProduct(product);
        } else if(!productFromRepository.equals(product)){
            throw new BadRequestException("El identificador del producto no corresponde con el registrado");
        }

        PromoPost promoPost = mapper.convertValue(promoPostRequestDto, PromoPost.class);
        promoPost.setId(postRepository.findAll().size());
        postRepository.addPost(promoPost);
        return new MessageDto("Publicación con promoción creada con éxito");
    }

    @Override
    public FollowedPostsDto getPost(int userId) {
        return new FollowedPostsDto(userId, getPostsByuserId(userId).stream()
                .sorted(Comparator.comparing(PostResponseDto::date).reversed()).toList());
    }

    public List<PostResponseDto> getPostsByuserId(int userId){
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
        return lastestPosts.stream().map(post -> mapper.convertValue(post, PostResponseDto.class)).toList();
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
                                .sorted(Comparator.comparing(PostResponseDto::date)).toList());
            }
            case "date_desc" -> {
                return new FollowedPostsDto(
                        userId,
                        getPostsByuserId(userId).stream()
                                .sorted(Comparator.comparing(PostResponseDto::date).reversed()).toList());
            }
            default -> throw new BadRequestException(MessageFormat.format("{0} no es valido, recuerde que debe ingresar 'date_asc' o 'date_desc'", order));
        }
    }

    @Override
    public PromoProductsCountDto getPromoProductsCountBySeller(int userId) {
        if(!userRepository.userExists(userId))
            throw new BadRequestException("El vendedor no existe");

        int promoPostCount = postRepository.findAll().stream().filter(p ->  p instanceof PromoPost && ((PromoPost) p).isHasPromo()).toList().size();

        return new PromoProductsCountDto(userId,userRepository.getUserById(userId).getUserName(),promoPostCount);
    }
    @Override
    public PromoPostResponseDto getPromoPostBySeller(int userId) {
        if(!userRepository.userExists(userId))
            throw new BadRequestException("El vendedor no existe");

        List<PromoPostDto> promoPostList = postRepository.findAll().stream()
                .filter(p -> p instanceof PromoPost && ((PromoPost) p).isHasPromo()&&p.getUserId()==userId)
                .map(p->mapper.convertValue(p, PromoPostDto.class)).toList();

        return new PromoPostResponseDto(userId,userRepository.getUserById(userId).getUserName(),promoPostList);
    }

    //Bonus
    @Override
    public List<PromoPostDto> getPostByType(String type,boolean promo) {
        return postRepository.findAll().stream().filter(p -> p instanceof PromoPost && p.getProduct().getType().toLowerCase()
                .equals(type.toLowerCase())&& ((PromoPost)p).isHasPromo()).map(p->mapper.convertValue(p,PromoPostDto.class)).toList();
    }
    @Override
    public List<PostResponseDto> getPostByType(String type) {
        return postRepository.findAll().stream().filter(p -> p.getProduct().getType().toLowerCase()
                .equals(type.toLowerCase())).map(p->mapper.convertValue(p,PostResponseDto.class)).toList();
    }
}
