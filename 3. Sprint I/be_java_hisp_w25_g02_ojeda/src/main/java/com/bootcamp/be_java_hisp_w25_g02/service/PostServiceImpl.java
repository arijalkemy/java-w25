package com.bootcamp.be_java_hisp_w25_g02.service;

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

    private Post mapPromoDtoToPost(PromotionPostDTO promoPostDTO){
        return new Post(0, promoPostDTO.user_id(), promoPostDTO.date(),
                new Product(promoPostDTO.product().product_id(), promoPostDTO.product().product_name(), promoPostDTO.product().type(), promoPostDTO.product().brand(), promoPostDTO.product().color(), promoPostDTO.product().notes()),
                promoPostDTO.category(), promoPostDTO.price(),
                promoPostDTO.has_promo(), promoPostDTO.discount());
    }
   
    @Override
    public FollowingPostDTO searchPostsOrderedByDate(Integer userId, String order) {
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

    @Override
    public PromotionPostDTO createNewPromo(PromotionPostDTO promoPostDTO){
        Post newPromo = mapPromoDtoToPost(promoPostDTO);
        this.postRepository.savePost(newPromo);
        return promoPostDTO;
    }

    @Override
    public PromotionAmountDTO getPromotionsAmount(Integer userId){
        List<Post> postList = postRepository.findAll();
        if (userId != null) {
            postList = postList.stream().filter(p -> p.getUser_id().equals(userId)).toList();
            if (postList.isEmpty()) throw new NotFoundException("El usuario no es vendedor!");
        }
        List<Post> promotionsList = postList.stream().filter(Post::getIsPromoActive).toList();
        if (promotionsList.isEmpty()) throw new NotFoundException("El usuario no posee promociones activas");
        return new PromotionAmountDTO(promotionsList.size());
    }

    /*
    @Override
    public PromotionPostDTO getNewestPromotion(){
        List<PromotionPost> promotions = this.promotionRepository.getAllPromotions();
        List<PromotionPost> sortedByDatePromotions = promotions.stream().sorted(Comparator.comparing(PromotionPost::getPostDate)).toList();
        if (sortedByDatePromotions.isEmpty()) throw new NotFoundException("No hay promociones disponibles en este momento");
        PromotionPost newestPromotion = sortedByDatePromotions.get(sortedByDatePromotions.size()-1);
        // PromotionPostDTO newsestPromotionPostDTO =
        return null;
    };
    */

    private PostDTO mapPostToDTO(Post post){
        return new PostDTO(post.getUser_id(), post.getPostDate(), mapToProductDTO(post.getProduct()),post.getCategory(), post.getPrice());
    }

    private PromotionPostDTO mapPostToPromoDTO(Post post){
        return new PromotionPostDTO(post.getUser_id(), post.getPostDate(), mapToProductDTO(post.getProduct()),post.getCategory(), post.getPrice(), post.getIsPromoActive(), post.getDiscount());
    }
    private ProductDTO mapToProductDTO(Product product){
        return new ProductDTO(product.getProduct_id(), product.getProduct_name(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }


    private int compareByDate(Post post1, Post post2) {
        return post1.getPostDate().compareTo(post2.getPostDate());
    }

}
