package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PromoResponseDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.*;
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
    public List<PostDTO> getPosts(Integer idUsuario) {
        return null;
    }

    @Override
    public PromoDTO addPromotionPost(PromoDTO promoDTO){
        Post promo = Mapper.mapPromoDTOToPromo(promoDTO);

        Optional<Product> product=productService.getProductById(promo.getProduct().getProductId());
        Optional<User> user = userRepository.getUserById(promoDTO.getUserId());
        if(user.isEmpty()){
            throw new NotFoundException("No hay un usuario con el id especificado");
        }
        if((!(user.get() instanceof Seller))){
            throw new BadRequestException("El usuario no corresponde a un vendedor");
        }
        if(product.isPresent()){
            throw new AlreadyExistException("Ya existe un post para este producto");
        }

        postRepository.addPost(promo);
        productService.addProduct(promoDTO.getProduct());

        return null;
    }

    @Override
    public PromoResponseDTO getPromos(Integer userId) {
        Optional<User> seller = userRepository.getUserById(userId);

        if (seller.isEmpty()){
            throw new NotFoundException("El id de este vendedor no se encuentra registrado");
        }
        Long response = postRepository.filterByIdUsuario(userId).stream().filter(x -> {
            if (x instanceof Promo && ((Promo) x).getHasPromo()){
                return true;
            }
            return false;
        }).count();
        return new PromoResponseDTO(userId, seller.get().getUserName(), response);
    }
}
