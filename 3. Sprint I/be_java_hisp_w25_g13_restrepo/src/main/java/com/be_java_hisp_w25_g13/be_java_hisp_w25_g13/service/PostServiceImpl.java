package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.*;
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

        Optional<Product> product=productService.getProductById(post.getProduct().getProductId());
        Optional<User> user = userRepository.getUserById(postDTO.getUserId());

        if(user.isEmpty()){
            throw new NotFoundException("No hay un usuario con el id especificado");
        }
        if((!(user.get() instanceof Seller))){
            throw new BadRequestException("El usuario no corresponde a un vendedor");
        }
        if(product.isPresent()){
            throw new AlreadyExistException("Ya existe un post para este producto");
        }

        postRepository.addPost(post);
        productService.addProduct(postDTO.getProduct());

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
    public PostPromDTO addPostProm(PostPromDTO postPromDTO) {
        Post post= Mapper.mapPostPromDtoToPost(postPromDTO);

        Optional<Product> product=productService.getProductById(post.getProduct().getProductId());
        Optional<User> user = userRepository.getUserById(postPromDTO.getUserId());

        if(user.isEmpty()){
            throw new NotFoundException("No hay un usuario con el id especificado");
        }
        if((!(user.get() instanceof Seller))){
            throw new BadRequestException("El usuario no corresponde a un vendedor");
        }
        if(product.isPresent()){
            throw new AlreadyExistException("Ya existe un post para este producto");
        }

        postRepository.addPost(post);
        productService.addProduct(postPromDTO.getProduct());

        return postPromDTO;
    }
    @Override
    public PostPromCountDTO cantPostPromSeller(Integer id) {
        Optional<User> user = userRepository.getUserById(id);
        if (user.isEmpty()){
            throw new NotFoundException("El id de este usuario no se encuentra registrado");
        }
        if((!(user.get() instanceof Seller))){
            throw new BadRequestException("El usuario no corresponde a un vendedor");
        }

        long cantPostProm= postRepository.filterPostPromByIdUsuario(user.get().getUserId()).stream().count();
        if (Long.valueOf(cantPostProm).equals(0L)) {
            throw new NotFoundException("El usuario no ha publicado promociones");
        }
        return new PostPromCountDTO(user.get().getUserId(),user.get().getUserName(),cantPostProm);
    }
    @Override
    public PostPromListDTO listProdPromSeller(Integer id) {
        Optional<User> user = userRepository.getUserById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("El id de este usuario no se encuentra registrado");
        }
        if ((!(user.get() instanceof Seller))) {
            throw new BadRequestException("El usuario no corresponde a un vendedor");
        }

        List<Post> listPostProm= postRepository.filterPostPromByIdUsuario(user.get().getUserId());
        if (listPostProm.isEmpty()) {
            throw new NotFoundException("El usuario no tiene promociones");
        }
        List<PostPromResponseDTO> listPostPromResponseDTO = listPostProm.stream().map(Mapper::mapPostToPostPromResponseDTO).toList();
        return new PostPromListDTO(user.get().getUserId(),user.get().getUserName(),listPostPromResponseDTO);

    }
    @Override
    public List<PostDTO> getPosts(Integer idUsuario) {
        return null;
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
}
