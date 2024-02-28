package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowingPostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.GenericResponseDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.ProductDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w25_g02.entity.Post;
import com.bootcamp.be_java_hisp_w25_g02.entity.Product;
import com.bootcamp.be_java_hisp_w25_g02.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g02.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w25_g02.repository.PostRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    IPostRepository postRepository;
    IUserService userService;

    public PostServiceImpl(PostRepositoryImpl postRepository, UserServiceImpl userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public GenericResponseDTO savePost(PostDTO postDTO) {
        if (!userService.existUser(postDTO.userId())) {
            throw new BadRequestException("El usuario no existe");
        }

        if (this.postRepository.findProductById(postDTO.product().productId()).isPresent()) {
            throw new BadRequestException("Ya existe un Producto con ese ID");
        }

        Post post = mapDtoToPost(postDTO);
        long id = this.postRepository.savePost(post);
        if (!userService.isSeller(postDTO.userId())) {
            userService.makeSeller(postDTO.userId());
        }
        return new GenericResponseDTO("Post creado con exito con el id: " + id);
    }

    private Post mapDtoToPost(PostDTO postDTO) {
        return new Post(0, postDTO.userId(), postDTO.date(), new Product(postDTO.product().productId(), postDTO.product().productName(), postDTO.product().type(), postDTO.product().brand(), postDTO.product().color(), postDTO.product().notes()), postDTO.category(), postDTO.price());
    }

    @Override
    public FollowingPostDTO getPostsOrderedByDate(Integer userId, String order) {
        if (order != null && !order.equalsIgnoreCase("date_asc") && !order.equalsIgnoreCase("date_desc")) {
            throw new BadRequestException("Parametro order no reconocido. Debe tener el valor date_asc o date_desc");
        }
        List<Integer> followedUsers = userService.getFollowedUsersId(userId);
        List<Post> posts = new ArrayList<>();
        for (Integer sellerId : followedUsers) {
            posts.addAll(this.postRepository.findByUserId(sellerId));

        }

        if (posts.isEmpty()) {
            throw new NotFoundException("No hay post de los usuarios seguidos en las ultimas 2 semanas");
        }
        if (order != null) {
            if (order.equalsIgnoreCase("date_asc")) {
                posts = posts.stream().sorted(Comparator.comparing(Post::getPostDate)).toList();
            } else {
                posts = posts.stream().sorted(Comparator.comparing(Post::getPostDate).reversed()).toList();
            }
        }
        return new FollowingPostDTO(userId, posts.stream().map(this::mapPostToDTO).toList());
    }

    private PostDTO mapPostToDTO(Post post) {
        return new PostDTO(post.getUserId(), post.getPostDate(), mapToProductDTO(post.getProduct()), post.getCategory(), post.getPrice());

    }

    private ProductDTO mapToProductDTO(Product product) {
        return new ProductDTO(product.getProductId(), product.getProductName(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }

}
