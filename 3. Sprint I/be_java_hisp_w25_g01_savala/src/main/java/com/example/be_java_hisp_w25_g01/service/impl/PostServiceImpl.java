package com.example.be_java_hisp_w25_g01.service.impl;

import com.example.be_java_hisp_w25_g01.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01.dto.request.PostWithoutDiscountDTO;
import com.example.be_java_hisp_w25_g01.dto.request.ProductDTO;
import com.example.be_java_hisp_w25_g01.dto.response.DiscountPostsDTO;
import com.example.be_java_hisp_w25_g01.dto.response.MessagesDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsListDTO;
import com.example.be_java_hisp_w25_g01.entity.Post;
import com.example.be_java_hisp_w25_g01.entity.Product;
import com.example.be_java_hisp_w25_g01.entity.User;
import com.example.be_java_hisp_w25_g01.exception.BadRequestException;
import com.example.be_java_hisp_w25_g01.exception.NotFoundException;
import com.example.be_java_hisp_w25_g01.repository.IPostRepository;
import com.example.be_java_hisp_w25_g01.repository.IUserRepository;
import com.example.be_java_hisp_w25_g01.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        //Todos los posts de los usuarios que sigue por ultimas dos semanas
        List<Post> post = usersFollowed.stream()
                .flatMap(u -> u.getPosts().stream())
                .toList();

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        //filtrar por ultimas dos semanas
        List<Post> posts = post.stream()
                .filter(p -> p.getDate().isAfter(twoWeeksAgo))
                .toList();

        return convertPostListToPostListDTO(posts, userId);
    }

    @Override
    public MessagesDTO followUser(int userId) {
        return null;
    }

    @Override
    public MessagesDTO createPost(PostDTO postDto){
        try {
            if(postDto.getDate().isAfter(LocalDate.now())){
                throw new BadRequestException("Invalid future date");
            }
            Optional<User> userOp = userRepository.findById(postDto.getUser_id());
            if(!userOp.isPresent()){
                throw new BadRequestException("User Not Found - ID:"+postDto.getUser_id());
            }
            if(postDto.getHas_promo() && postDto.getDiscount() == 0d){
                throw new BadRequestException("Discount should not be 0");
            }
            userRepository.createPost(convertPostDtoToPost(postDto));
            return new MessagesDTO("Post created successfully");
        }
        catch (Exception e){
            throw new BadRequestException("Error creating Post - "+e.getMessage());
        }
    }

    @Override
    public MessagesDTO createPost(PostWithoutDiscountDTO postDto) {
        try {
            if(postDto.getDate().isAfter(LocalDate.now())){
                throw new BadRequestException("Invalid future date");
            }
            Optional<User> userOp = userRepository.findById(postDto.getUser_id());
            if(!userOp.isPresent()){
                throw new BadRequestException("User Not Found - ID:"+postDto.getUser_id());
            }
            userRepository.createPost(convertPostWithoutDiscountDtoToPost(postDto));
            return new MessagesDTO("Post created successfully");
        }
        catch (Exception e){
            throw new BadRequestException("Error creating Post - " + e.getMessage());
        }
    }

    @Override
    public DiscountPostsDTO getCountOfDiscountById(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No se encontró el usuario con el id " + userId));

        List<Post> postsOfUser = postRepository.findByUser(userId);

        Integer count = Math.toIntExact(postsOfUser.stream()
                .filter(Post::getHas_promo)
                .count());
        return new DiscountPostsDTO(userId, user.getUserName(), count);
    }

    private Post convertPostWithoutDiscountDtoToPost(PostWithoutDiscountDTO p){
        return new Post(
                postRepository.generateId(),
                p.getUser_id(),
                p.getDate(),
                convertProductDtoToProduct(p.getProduct()),
                p.getCategory(),
                p.getPrice()
        );
    }
    private Post convertPostDtoToPost(PostDTO p){
        return new Post(
                postRepository.generateId(),
                p.getUser_id(),
                p.getDate(),
                convertProductDtoToProduct(p.getProduct()),
                p.getCategory(),
                p.getPrice(),
                p.getHas_promo(),
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
                post.getPrice(),
                post.getHas_promo(),
                post.getDiscount()
        );
    }
    private PostsListDTO convertPostListToPostListDTO(List<Post> posts, Integer userId){
        List<PostDTO> listOfDtos = posts.stream().map(this::convertPostToPostDto).toList();
        return new PostsListDTO(userId, listOfDtos);
    }
}
