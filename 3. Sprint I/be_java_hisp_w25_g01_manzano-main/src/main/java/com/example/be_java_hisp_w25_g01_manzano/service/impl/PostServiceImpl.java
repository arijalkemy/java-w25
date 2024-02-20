package com.example.be_java_hisp_w25_g01_manzano.service.impl;

import com.example.be_java_hisp_w25_g01_manzano.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.request.ProductDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.request.PromoPostDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.response.MessagesDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.response.PostsListDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.response.PromoPostCountDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.response.PromoPostsListDTO;
import com.example.be_java_hisp_w25_g01_manzano.entity.Post;
import com.example.be_java_hisp_w25_g01_manzano.entity.Product;
import com.example.be_java_hisp_w25_g01_manzano.entity.User;
import com.example.be_java_hisp_w25_g01_manzano.exception.BadRequestException;
import com.example.be_java_hisp_w25_g01_manzano.exception.NotFoundException;
import com.example.be_java_hisp_w25_g01_manzano.repository.IPostRepository;
import com.example.be_java_hisp_w25_g01_manzano.repository.IUserRepository;
import com.example.be_java_hisp_w25_g01_manzano.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;


    @Override
    public PostsListDTO getLastPostsFollowedBy(Integer userId){
        List<Post> post = getFollowedPost(userId);

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        //filtrar por ultimas dos semanas
        List<Post> posts = post.stream()
                .filter(p -> p.getDate().isAfter(twoWeeksAgo))
                .toList();

        return convertPostListToPostListDTO(posts, userId);
    }

    @Override
    public PromoPostsListDTO getSalePostsFollowedBy(Integer userId, String order) {
        List<Post> posts = getFollowedPost(userId);

        //filtrar por post promocionales
        List<Post> promoPosts = posts.stream()
                .filter(p -> p.isHas_promo())
                .toList();

        PromoPostsListDTO postsDto= convertPostListToPromoPostListDTO(promoPosts, userId);

        //order posts
        switch (order){
            case("discount_desc"):{
                postsDto.setPostsList(postsDto.getPostsList().stream().sorted(Comparator.comparing(PromoPostDTO::getDiscount).reversed()).toList());
                break;
            }
            case("discount_asc"):{
                postsDto.setPostsList(postsDto.getPostsList().stream().sorted(Comparator.comparing(PromoPostDTO::getDiscount)).toList());
                break;
            }
            case("price_desc"):{
                postsDto.setPostsList(postsDto.getPostsList().stream().sorted(Comparator.comparing(PromoPostDTO::getPrice).reversed()).toList());
                break;
            }
            case("price_asc"):{
                postsDto.setPostsList(postsDto.getPostsList().stream().sorted(Comparator.comparing(PromoPostDTO::getPrice)).toList());
                break;
            }
            case("best_oportunity"):{
                postsDto.setPostsList(postsDto.getPostsList().stream().sorted(Comparator.comparing(p-> (p.getPrice()-p.getPrice()*p.getDiscount()))).toList());
                break;
            }
            default:break;
        }

        return postsDto;
    }

    @Override
    public MessagesDTO createPost(PostDTO postDto){
            return createPost(convertPostDtoToPost(postDto));
    }
    @Override
    public MessagesDTO createPromoPost(PromoPostDTO postDto){
        if(postDto.getDiscount()<=0 || postDto.getDiscount()>1){
            throw new BadRequestException("Invalid discount amount");
        }
        if(!postDto.isHas_promo()){
            throw new BadRequestException("Promotional posts require promo");
        }
        return createPost(convertPromoPostDtoToPost(postDto));
    }

    private List<Post> getFollowedPost(Integer userId)
    {
        //Buscar usuario sino tirar excepcion
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No se encontró el usuario con el id " + userId));

        //Lista de ids que sigue el usuario
        List<Integer> followedList = user.getFollowed();

        //Todos los usuarios
        List<User> allUsers = userRepository.findAll();

        //Todos los usuarios que sigue el user...
        List<User> usersFollowed = allUsers.stream()
                .filter(u -> followedList.contains(u.getUserId()))
                .toList();

        List<Post> post = usersFollowed.stream()
                .flatMap(u -> u.getPosts().stream())
                .toList();
        return post;
    }

    private MessagesDTO createPost(Post post){
        try {
            if(post.getDate().isAfter(LocalDate.now())){
                throw new BadRequestException("Invalid future date");
            }
            Optional<User> userOp = userRepository.findById(post.getUser_id());
            if(!userOp.isPresent()){
                throw new BadRequestException("User Not Found - ID:"+post.getUser_id());
            }
            userRepository.createPost(post);
            return new MessagesDTO("Post created successfully");
        }
        catch (Exception e){
            throw new BadRequestException("Error creating Post - "+e.getMessage());
        }
    }

    @Override
    public PromoPostCountDTO getPromoPostCount(Integer id)
    {
        Optional<User> userOp = userRepository.findById(id);
        if(!userOp.isPresent()){
            throw new BadRequestException("User Not Found - ID:"+id);
        }
        List<Post> userPosts = postRepository.findByUser(id);
        List<Post> userPromoPosts = userPosts.stream()
                .filter(p-> p.isHas_promo())
                .toList();
        return new PromoPostCountDTO(id, userOp.get().getUserName(),userPromoPosts.size());
    }

    private Post convertPostDtoToPost(PostDTO p){
        return new Post(
                postRepository.generateId(),
                p.getUser_id(),
                p.getDate(),
                convertProductDtoToProduct(p.getProduct()),
                p.getCategory(),
                p.getPrice()
        );
    }

    private Post convertPromoPostDtoToPost(PromoPostDTO p){
        return new Post(
                postRepository.generateId(),
                p.getUser_id(),
                p.getDate(),
                convertProductDtoToProduct(p.getProduct()),
                p.getCategory(),
                p.getPrice(),
                p.isHas_promo(),
                p.getDiscount()
        );
    }

    private Product convertProductDtoToProduct(ProductDTO p){
        return new Product(
                p.getProduct_id(),
                p.getProduct_name(),
                p.getType(),
                p.getBrand(),
                p.getColor(),
                p.getNotes()
        );
    }


    private ProductDTO convertProductToProductDto(Product product){
        return new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }
    private PostDTO convertPostToPostDto(Post post){
        ProductDTO productDTO = convertProductToProductDto(post.getProduct());
        return new PostDTO(
                post.getUser_id(),
                post.getDate(),
                productDTO,
                post.getCategory(),
                post.getPrice()
        );
    }

    private PromoPostDTO convertPostToPromoPostDto(Post post){
        ProductDTO productDTO = convertProductToProductDto(post.getProduct());
        return new PromoPostDTO(
                post.getUser_id(),
                post.getDate(),
                productDTO,
                post.getCategory(),
                post.getPrice(),
                post.isHas_promo(),
                post.getDiscount()
        );
    }
    private PostsListDTO convertPostListToPostListDTO(List<Post> posts, Integer userId){
        List<PostDTO> listOfDtos = posts.stream().map(this::convertPostToPostDto).toList();
        return new PostsListDTO(userId, listOfDtos);
    }

    private PromoPostsListDTO convertPostListToPromoPostListDTO(List<Post> posts, Integer userId){
        List<PromoPostDTO> listOfDtos = posts.stream().map(this::convertPostToPromoPostDto).toList();
        return new PromoPostsListDTO(userId, listOfDtos);
    }
}
