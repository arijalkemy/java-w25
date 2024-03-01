package com.example.be_java_hisp_w25_g01.service.impl;

import com.example.be_java_hisp_w25_g01.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01.dto.request.ProductDTO;
import com.example.be_java_hisp_w25_g01.dto.response.MessagesDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsListDTO;
import com.example.be_java_hisp_w25_g01.entity.Post;
import com.example.be_java_hisp_w25_g01.entity.Product;
import com.example.be_java_hisp_w25_g01.entity.User;
import com.example.be_java_hisp_w25_g01.exception.BadRequestException;
import com.example.be_java_hisp_w25_g01.exception.NotFoundException;
import com.example.be_java_hisp_w25_g01.repository.IPostRepository;
import com.example.be_java_hisp_w25_g01.repository.IProductRepository;
import com.example.be_java_hisp_w25_g01.repository.IUserRepository;
import com.example.be_java_hisp_w25_g01.service.IPostService;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PostsListDTO getLastPostsFollowedBy(Integer userId, String order){

        //Buscar usuario sino tirar excepcion
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No se encontró el usuario con el id " + userId));

        //Todos los usuarios que sigue el user...
        List<User> usersFollowed = userRepository.findAllByIdIn(user.getFollowed());

        //Todos los posts de los usuarios que sigue
        List<Post> post = usersFollowed.stream()
                .flatMap(u -> postRepository.findAllPostById(u.getPosts()).stream())
                .toList();

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        //filtrar por ultimas dos semanas
        List<Post> posts = post.stream()
                .filter(p -> p.getDate().isAfter(twoWeeksAgo))
                .toList();
        PostsListDTO postsListDTOS = convertPostListToPostListDTO(posts, userId);

        //validar si va ordenado o no
        if (order != null){
            if ("date_asc".equalsIgnoreCase(order)) {
                postsListDTOS.setPostsList(postsListDTOS.getPostsList().stream()
                        .sorted(Comparator.comparing(PostDTO::getDate)).toList());
            } else if ("date_desc".equalsIgnoreCase(order)) {
                postsListDTOS.setPostsList(postsListDTOS.getPostsList().stream()
                        .sorted(Comparator.comparing(PostDTO::getDate).reversed()).toList());
            }
            else {throw new BadRequestException("Bad order request.");}
        }
        return postsListDTOS;
    }

    @Override
    public MessagesDTO followUser(int userId) {
        return null;
    }

    @Override
    public MessagesDTO createPost(PostDTO postDto){
        if(postDto.getDate().isAfter(LocalDate.now())){
            throw new BadRequestException("Invalid future date");
        }
        Optional<User> userOp = userRepository.findById(postDto.getUser_id());
        if(userOp.isEmpty()){
            throw new BadRequestException("User Not Found - ID: "+postDto.getUser_id());
        }
        Optional<Product> productOp = productRepository.findById(postDto.getProduct().getProduct_id());
        if(productOp.isEmpty()){
            throw new BadRequestException("Product Not Found - ID: "+postDto.getProduct().getProduct_id());
        }
        Post post = convertPostDtoToPost(postDto);
        userRepository.createPost(post);
        postRepository.addPost(post);

        return new MessagesDTO("Post created successfully");
    }

    private Post convertPostDtoToPost(PostDTO p){
        return new Post(
                postRepository.generateId(),
                p.getUser_id(),
                p.getDate(),
                p.getProduct().getProduct_id(),
                p.getCategory(),
                p.getPrice()
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
        ProductDTO productDTO = convertProductToProductDto(productRepository.findById(post.getProduct()).get());
        return new PostDTO(post.getUser_id(),
                post.getPost_id(),
                post.getDate(),
                productDTO,
                post.getCategory(),
                post.getPrice());
    }
    private PostsListDTO convertPostListToPostListDTO(List<Post> posts, Integer userId){
        List<PostDTO> listOfDtos = posts.stream().map(this::convertPostToPostDto).toList();
        return new PostsListDTO(userId, listOfDtos);
    }
}
