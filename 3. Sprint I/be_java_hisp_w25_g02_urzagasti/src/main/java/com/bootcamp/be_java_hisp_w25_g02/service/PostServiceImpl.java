package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.*;

import com.bootcamp.be_java_hisp_w25_g02.entity.Post;
import com.bootcamp.be_java_hisp_w25_g02.entity.Product;
import com.bootcamp.be_java_hisp_w25_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w25_g02.repository.PostRepositoryImpl;
import com.bootcamp.be_java_hisp_w25_g02.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g02.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    @Override
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
        int id = this.postRepository.savePost(post);
        return new GenericResponseDTO("Post creado con exito con el id: "+ id);
    }

   
    @Override
    public FollowingPostDTO getPostsOrderedByDate(Integer userId, String order, Boolean filterByPromotion) {
        if (!order.equalsIgnoreCase("date_asc") && !order.equalsIgnoreCase("date_desc") ){
            throw new BadRequestException("Parametro order no reconocido. Debe tener el valor date_asc o date_desc");
        }
        List<Integer> followedUsers = userService.getFollowedUsersId(userId);
        List<Post> posts = new ArrayList<>();
        for(Integer sellerId: followedUsers){
            posts.addAll(this.postRepository.findByUserId(sellerId));

        }
        if(filterByPromotion){
            posts = posts.stream().filter(Post::getHas_promo).toList();
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
    public GenericResponseDTO savePromoPost(PromoPostDTO promoPostDTO) {
        this.userService.verifyUserAsSeller(promoPostDTO.user_id());
        validatePostDTO(promoPostDTO);
        if (promoPostDTO.date().isAfter(LocalDate.now())){
            throw new BadRequestException("La fecha no es valida");
        }
        if (promoPostDTO.discount() < 0){
            throw  new BadRequestException("El descuento no puede ser menor o igual a 0");
        }
        Integer id = this.postRepository.savePost(mapDTOToPromoPost(promoPostDTO));
        return new GenericResponseDTO("El post fue publicado con exito con id: " + id);
    }

    @Override
    public PromoPostCountDTO getPromoPostCount(Integer userId) {
        UserDTO seller = userService.getUserById(userId);
        List<Post> posts = postRepository.findPromoPost(userId);
        if (posts.isEmpty()){
            throw new NotFoundException("El usuario no tiene posts en promocion");
        }
        return new PromoPostCountDTO(userId, seller.user_name(), posts.size());
    }

    @Override
    public GenericResponseDTO updatePromotionDiscount(Integer post_id, double discount) {
        if (discount <= 0){
            throw new BadRequestException("El descuento no puede ser menor o igual a 0");
        }
        Optional<Post> post = postRepository.findById(post_id);
        if (post.isEmpty()){
            throw new BadRequestException("No existen posts con ese id");
        }
        post.get().setHas_promo(true);
        post.get().setDiscount(discount);
        return new GenericResponseDTO("descuento actualizado con exito");
    }

    @Override
    public GenericResponseDTO updateEndPromotion(Integer post_id) {
        Optional<Post> post = postRepository.findById(post_id);
        if (post.isEmpty()){
            throw new BadRequestException("No existen post con ese id");
        }
        if (post.get().getHas_promo()){
            post.get().setHas_promo(false);
            post.get().setDiscount(0.0);
        }else {
            throw new BadRequestException("El post no tiene promocion");
        }
        return new GenericResponseDTO("Promocion finalizada con exito");

    }
    private void validatePostDTO(PromoPostDTO postDTO){

        if (postDTO == null || postDTO.price() == null || postDTO.has_promo() == null || postDTO.user_id() == null || postDTO.date() == null || postDTO.category() == null || postDTO.discount() == null){
            throw new BadRequestException("uno o más parametros fueron null");
        }
        if (postDTO.price() <= 0 || postDTO.category() < 0){
            throw new BadRequestException("El post tiene datos incorrectos");
        }
        if (postDTO.has_promo() && postDTO.discount() <= 0){
            throw new BadRequestException("El descuento no puede ser menor o igual a cero");
        }
        if (!postDTO.has_promo() && postDTO.discount() > 0){
            throw new BadRequestException("El articulo no tiene promocion pero si un descuento, verificar campos");
        }
        validateProductDTO(postDTO.product());
    }
    private void validateProductDTO(ProductDTO productDTO){
        if (productDTO == null || productDTO.type() == null|| productDTO.product_name() == null || productDTO.product_id() == null || productDTO.brand() == null || productDTO.notes() == null || productDTO.color() == null){
            throw new BadRequestException("Uno o más parametros de producto fueron null");
        }
        if ( productDTO.product_name().isBlank() || productDTO.color().isBlank() || productDTO.brand().isBlank() || productDTO.notes().isBlank() || productDTO.type().isBlank() )
        {
            throw new BadRequestException("Producto tiene valores vacios");
        }
    }
    private PromotionPostDTO mapPostToDTO(Post post){
        return new PromotionPostDTO(post.getUser_id(), post.getPostDate(), mapToProductDTO(post.getProduct()),post.getCategory(), post.getPrice(), post.getPrice() - post.getPrice() * post.getDiscount(), post.getDiscount(), post.getHas_promo());

    }
    private ProductDTO mapToProductDTO(Product product){
        return new ProductDTO(product.getProduct_id(), product.getProduct_name(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }

    private Post mapDTOToPromoPost(PromoPostDTO postDTO ){
        return new Post( 0, postDTO.user_id(), postDTO.date(), new Product(postDTO.product().product_id(), postDTO.product().product_name(), postDTO.product().type(), postDTO.product().brand(), postDTO.product().color(), postDTO.product().notes()), postDTO.category(), postDTO.price(), postDTO.has_promo(), postDTO.discount());
    }

    private Post mapDtoToPost(PostDTO postDTO){
        return new Post(0, postDTO.user_id(), postDTO.date(), new Product(postDTO.product().product_id(), postDTO.product().product_name(), postDTO.product().type(), postDTO.product().brand(), postDTO.product().color(), postDTO.product().notes()), postDTO.category(), postDTO.price());
    }

}
