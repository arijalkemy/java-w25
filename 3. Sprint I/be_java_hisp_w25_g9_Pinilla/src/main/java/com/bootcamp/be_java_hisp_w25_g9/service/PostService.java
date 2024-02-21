package com.bootcamp.be_java_hisp_w25_g9.service;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDtoMixIn;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDtoMixin;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.SellerPromoPostsCountDto;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g9.model.Post;
import com.bootcamp.be_java_hisp_w25_g9.model.Product;
import com.bootcamp.be_java_hisp_w25_g9.model.Seller;
import com.bootcamp.be_java_hisp_w25_g9.model.User;
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
    public SellerPromoPostsCountDto getSellerPromoPosts(int userId) {
        if(!userRepository.userExists(userId))
            throw new NotFoundException(MessageFormat.format("El usuario con id {0} no existe", userId));

        User seller = userRepository.getUserById(userId);
        if (seller.getClass() != Seller.class)
            throw new BadRequestException("El usuario ingresado no es un vendedor");

        List<Post> sellerPosts = postRepository.findAll().stream().filter(post -> post.getUserId() == userId).toList();
        if(sellerPosts.isEmpty())
            throw new NotFoundException("No existe ningún post publicado por este vendedor");

        return new SellerPromoPostsCountDto(
                seller.getUserId(),
                seller.getUserName(),
                (int) sellerPosts.stream().filter(Post::isHasPromo).count()
        );
    }
}
