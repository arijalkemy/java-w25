package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoCountDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoPostListResponseDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.SellerPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.AlreadyExistException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.BadRequestException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.NotFoundException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IPostRepository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IUserRepository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Mapper;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    IPostRepository postRepository;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    IUserRepository userRepository;

    @Override
    public PostDTO addPost(PostDTO postDTO) {
        Post post= Mapper.mapPostDtoToPost(postDTO);

        verifyUser(userRepository.getUserById(postDTO.getUserId()));
        verifyPost(productService.getProductById(post.getProduct().getProductId()));

        postRepository.addPost(post);
        productService.addProduct(postDTO.getProduct());

        return postDTO;
    }

    @Override
    public PromoPostDTO addPromoPost(PromoPostDTO promoPostDTO) {
        Post post = Mapper.mapPromoPostDtoToPost(promoPostDTO);
        verifyUser(userRepository.getUserById(promoPostDTO.getUserId()));
        verifyPost(productService.getProductById(post.getProduct().getProductId()));
        if(post.getHasPromo().equals(true) && post.getDiscount() == 0){
            throw new BadRequestException("No puedes tener un producto en promocion con un descuento del 0%");
        }

        postRepository.addPost(post);
        productService.addProduct(promoPostDTO.getProduct());
        return promoPostDTO;
    }

    private void verifyUser(Optional<User> user){
        if(user.isEmpty()){
            throw new NotFoundException("No hay un usuario con el id especificado");
        }
        if((!(user.get() instanceof Seller))){
            throw new BadRequestException("El usuario no corresponde a un vendedor");
        }
    }
    private void verifyPost(Optional<Product> product){
        if(product.isPresent()){
            throw new AlreadyExistException("Ya existe un post para este producto");
        }
    }
    @Override
    public SellerPostDTO getPostPerSeller(Integer id, String orderBy) {
        Optional<User> user = userRepository.getUserById(id);
        if (user.isEmpty()){
            throw new NotFoundException("El id de este usuario no se encuentra registrado");
        }
        LocalDate hourNow = LocalDate.now();
        List<Post> posts = new ArrayList<>();
        user.get().getFollowing().stream()
                .filter(x -> !(postRepository.filterByDateAndIdUsuario(x.getUserId(), hourNow).isEmpty()))
                .forEach(x -> posts.addAll(postRepository.filterByDateAndIdUsuario(x.getUserId(), hourNow)));

        return new SellerPostDTO(id, orderPostList(posts, orderBy).stream().map(Mapper::mapPostToPost2DTO).toList());
    }

    @Override
    public PromoCountDTO getPromoProductsCount(Integer idUsuario) {
        Optional<User> user = userRepository.getUserById(idUsuario);
        verifyUser(user);
        return new PromoCountDTO(user.get().getUserId(),
                user.get().getUserName(),
                postRepository.getPromoPostCount(idUsuario));
    }

    @Override
    public PromoPostListResponseDTO getPromoPostsList(Integer idUsuario, String order) {
        Optional<User> user = userRepository.getUserById(idUsuario);
        verifyUser(user);

        return new PromoPostListResponseDTO(
                user.get().getUserId(),
                user.get().getUserName(),
                Mapper.postListToPromoPostDTOList(orderPostList(postRepository.getPromoPostByIdUsuario(idUsuario),order))
                );
    }

    private List<Post> orderPostList(List<Post> posts, String orderBy){

        return switch (orderBy) {
            case "date_asc" -> OrderBy.orderByDateAsc(posts);
            case "date_desc" -> OrderBy.orderByDateDes(posts);
            case "none" -> posts;
            default ->
                    throw new BadRequestException(
                            "El metodo de ordenamiento debe estar entre date_asc, date_desc o no tener ninguno"
                    );
        };
    }

    @Override
    public List<PostDTO> getPosts(Integer idUsuario) {
        return null;
    }
}
