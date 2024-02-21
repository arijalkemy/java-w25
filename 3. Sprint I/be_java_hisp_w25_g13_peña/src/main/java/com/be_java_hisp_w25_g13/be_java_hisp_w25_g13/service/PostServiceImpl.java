package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoPostNumberDTO;
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

import javax.swing.text.html.Option;
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

    private Post createPost(PostDTO postDTO) {
        Post post= Mapper.mapPostDtoToPost(postDTO);

        Optional<User> user = userRepository.getUserById(postDTO.getUserId());

        if(user.isEmpty()){
            throw new NotFoundException("No hay un usuario con el id especificado");
        }
        if((!(user.get() instanceof Seller))){
            throw new BadRequestException("El usuario no corresponde a un vendedor");
        }

        return post;
    }
    @Override
    public PostDTO addPost(PostDTO postDTO) {
        Post post = createPost(postDTO);

        productService.addProduct(postDTO.getProduct());
        postRepository.addPost(post);

        return postDTO;
    }
    @Override
    public PromoPostDTO addPromoPost(PromoPostDTO postDTO) {
        Post post = createPost(postDTO);
        if (postDTO.getHasPromo()) {
            if (postDTO.getDiscount() == null || postDTO.getDiscount().equals(0.0)) {
                throw new BadRequestException("Los Post con promoción deben tener un procentaje de descuento");
            }
            post.setHasPromo(true);
            post.setDiscount(postDTO.getDiscount());
        }

        productService.addProduct(postDTO.getProduct());
        postRepository.addPost(post);

        return postDTO;
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
    public PromoPostNumberDTO getPromoPostPerSeller(Integer sellerId) {
        Optional<User> user = userRepository.getUserById(sellerId);
        if (user.isEmpty()){
            throw new NotFoundException("El id de este usuario no se encuentra registrado");
        }
        List<Post> promoPostList = postRepository.getPromoPosts();

        int count = promoPostList.stream()
            .filter(post -> post.getUserId().equals(user.get().getUserId())).toList().size();

        return new PromoPostNumberDTO(user.get().getUserId(), user.get().getUserName(), count);
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
    public List<PostDTO> getPosts(Integer userId) {
        return null;
    }
}
