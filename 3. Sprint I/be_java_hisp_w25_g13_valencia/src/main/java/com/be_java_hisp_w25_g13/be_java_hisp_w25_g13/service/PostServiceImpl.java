package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.NumberPromoPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostPromosDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostResponseDTO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    IPostRepository postRepository;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    IUserRepository userRepository;

    @Override
    public PostResponseDTO addPost(PostDTO postDTO) {
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

        productService.addProduct(postDTO.getProduct());

        return Mapper.mapPostToPost2DTO(postRepository.addPost(post));
    }

    @Override
    public List<PostDTO> getPosts(Integer idUsuario) {
        return null;
    }

    @Override
    public PostResponseDTO addPromoPost(PostDTO postDTO) {
        Post post=Mapper.mapPostDtoToPost(postDTO);

        Optional<Product> product=productService.getProductById(post.getProduct().getProductId());
        Optional <User> user=userRepository.getUserById(postDTO.getUserId());

        if(user.isEmpty()){
            throw new NotFoundException("No hay un usuario con el id especificado");
        }
        if((!(user.get() instanceof Seller))){
            throw new BadRequestException("El usuario no corresponde a un vendedor");
        }
        if(product.isPresent()){
            throw new AlreadyExistException("Ya existe un post para este producto");
        }

        productService.addProduct(postDTO.getProduct());

        return Mapper.mapPostToPost2DTO(postRepository.addPost(post));

    }

    @Override
    public NumberPromoPostDTO getCountPromoProducts(Integer idUsuario) {
        Optional<User> user=userRepository.getUserById(idUsuario);

        if(user.isEmpty()){
            throw new NotFoundException("No hay un usuario con el id especificado");
        }
        if((!(user.get() instanceof Seller))){
            throw new BadRequestException("El usuario no corresponde a un vendedor");
        }

        List<Post> productsPromo=postRepository.filterByHasPromo();

        return new NumberPromoPostDTO(
                idUsuario,
                user.get().getUserName(),
                productsPromo.size()
        );
    }

    @Override
    public PostPromosDTO getPromoPosts(Integer idUsuario) {
        Optional<User> user=userRepository.getUserById(idUsuario);

        if(user.isEmpty()){
            throw new NotFoundException("No hay un usuario con el id especificado");
        }
        if((!(user.get() instanceof Seller))){
            throw new BadRequestException("El usuario no corresponde a un vendedor");
        }

        List<PostResponseDTO> listPosts = postRepository.filterByHasPromo()
                .stream()
                .map(Mapper::mapPostToPost2DTO)
                .collect(Collectors.toList());

        return new PostPromosDTO(
                idUsuario,
                user.get().getUserName(),
                listPosts
        );
    }
}
