package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.SavePromoDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.*;

import com.bootcamp.be_java_hisp_w25_g02.entity.Post;
import com.bootcamp.be_java_hisp_w25_g02.entity.Product;
import com.bootcamp.be_java_hisp_w25_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w25_g02.repository.PostRepositoryImpl;
import com.bootcamp.be_java_hisp_w25_g02.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g02.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService{

    IPostRepository postRepository;
    IUserService userService;
    public PostServiceImpl(PostRepositoryImpl postRepository, UserServiceImpl userService){
        this.postRepository = postRepository;
        this.userService =userService;
    }

    public GenericResponseDTO savePost(PostDTO postDTO){
        if (!userService.existUser(postDTO.user_id())){
            throw new BadRequestException("El usuario no existe");
        }
        if (!userService.isSeller(postDTO.user_id())){
            throw new BadRequestException("El usuario no es vendedor");
        }
        if (this.postRepository.findProductById(postDTO.product().product_id()).isPresent()){
            throw new BadRequestException("Ya existe un Producto con ese ID");
        }

        Post post = mapDtoToPost(postDTO);
        long id = this.postRepository.savePost(post);
        return new GenericResponseDTO("Post creado con exito con el id: "+ id);
    }
  
    private Post mapDtoToPost(PostDTO postDTO){
        return new Post(0, postDTO.user_id(), postDTO.date(), new Product(postDTO.product().product_id(), postDTO.product().product_name(), postDTO.product().type(), postDTO.product().brand(), postDTO.product().color(), postDTO.product().notes()), postDTO.category(), postDTO.price());
    }
   
    @Override
    public FollowingPostDTO getPostsOrderedByDate(Integer userId, String order) {
        if (!order.equalsIgnoreCase("date_asc") && !order.equalsIgnoreCase("date_desc") ){
            throw new BadRequestException("Parametro order no reconocido. Debe tener el valor date_asc o date_desc");
        }
        List<Integer> followedUsers = userService.getFollowedUsersId(userId);
        List<Post> posts = new ArrayList<>();
        for(Integer sellerId: followedUsers){
            posts.addAll(this.postRepository.findByUserId(sellerId));

        }

        if (posts.isEmpty()){
            throw new NotFoundException("No hay post de los usuarios seguidos en las ultimas 2 semanas");
        }
        if( order.equalsIgnoreCase("date_asc")){
            posts = posts.stream().sorted(Comparator.comparing(Post::getPostDate)).toList();
        }else {
            posts =posts.stream().sorted(Comparator.comparing(Post::getPostDate).reversed()).toList();
        }
        return new FollowingPostDTO(userId, posts.stream().map(this::mapPostToDTO).toList());
    }
    private PostDTO mapPostToDTO(Post post){
        return new PostDTO(post.getUserId(), post.getPostDate(), mapToProductDTO(post.getProduct()),post.getCategory(), post.getPrice());

    }
    private ProductDTO mapToProductDTO(Product product){
        return new ProductDTO(product.getProduct_id(), product.getProduct_name(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }

    @Override
    public GenericResponseDTO savePromoPost(SavePromoDTO savePromoPost ){
        if (!userService.existUser(savePromoPost.user_id())){
            throw new BadRequestException("El usuario no existe");
        }
        Post post = mapToPost(savePromoPost);
        long id = this.postRepository.savePost(post);
        return new GenericResponseDTO("El post fue registrado con exito");
    }

    @Override
    public PromoCountDTO getPromoCount(Integer userId) {
        UserDTO userDTO = this.userService.getById(userId);
        Integer count = this.postRepository.findPromoCount(userId);
        return new PromoCountDTO(userDTO.user_id(), userDTO.user_name(), count);
    }

    private Post mapToPost(SavePromoDTO savePromoDTO){
        return new Post(0, savePromoDTO.user_id(), savePromoDTO.date(),new Product(savePromoDTO.product().product_id(), savePromoDTO.product().product_name(), savePromoDTO.product().type(), savePromoDTO.product().brand(), savePromoDTO.product().color(), savePromoDTO.product().notes()), savePromoDTO.category(), savePromoDTO.price(),savePromoDTO.has_promo(),savePromoDTO.discount());
    }

    @Override
    public  GenericResponseDTO endPromo(Integer postId){
        Optional<Post> postOptional= this.postRepository.findById(postId);
        if (postOptional.isEmpty()){
            throw new NotFoundException("No se encontro el posteo con el id " + postId);
        }
        Post post = postOptional.get();
        if (!post.getHasPromo()){
            throw new BadRequestException("Su producto no tiene promoción");
        }
        post.setHasPromo(false);
        post.setDiscount(0.0);
        return new GenericResponseDTO("Operación realizada con exito, su producto ya no tiene promoción");
    }


}
