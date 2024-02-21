package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PostsByUserDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoPostsCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Product;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04.exception.BadRequestException;
import com.breakingbytes.be_java_hisp_w25_g04.exception.NotFoundException;
import com.breakingbytes.be_java_hisp_w25_g04.repository.*;
import com.breakingbytes.be_java_hisp_w25_g04.utils.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements  IPostService{

    IPostRepository postRepository;
    ISellerRepository sellerRepository;
    IProductRepository productRepository;
    IUserRepository userRepository;
    Mapper mapper;

    public PostServiceImpl(PostRepositoryImpl postRepository,
                           SellerRepositoryImpl sellerRepository,
                           ProductRepositoryImpl productRepository,
                           UserRepositoryImpl userRepository,
                           Mapper mapper){
        this.postRepository = postRepository;
        this.sellerRepository = sellerRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    // Ejercicio 0005
    @Override
    public void addPost(com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO postDTO) {
        Optional<Seller> seller = sellerRepository.findById(postDTO.getUserId());
        if (seller.isEmpty()) throw new NotFoundException("No se ha encontrado un vendedor con ese ID");

        Optional<Product> product = productRepository.findAll().stream()
                .filter(p -> p.getId() == postDTO.getProduct().getId())
                .findFirst();
        if (product.isPresent()) throw new BadRequestException("Ya existe un producto con ese ID");

        Post post = mapper.modelMapper().map(postDTO, Post.class);
        post.setSeller(seller.get());

        postRepository.addPost(post);
        productRepository.addProduct(post.getProduct());
    }

    // Ejercicio 0006
    @Override
    public LastPostsDTO getPostOfVendorsFollowedByUser(int id, String order) {
        Optional<User> opt = this.userRepository.findById(id);
        if (opt.isEmpty()) throw new NotFoundException("No se encuentra el id buscado");
        User user = opt.get();
        List<Post> lastPosts = postRepository.findAll().stream()
                .filter(p -> p.getDate().isBefore(LocalDate.now().minusWeeks(2)))
                .toList();
        lastPosts = lastPosts.stream().filter(p -> p.getSeller().isAFollower(user)).toList();
        if(lastPosts.isEmpty()) throw new NotFoundException("No hay publicaciones que cumplan con el requisito");
        List<PostDTO> postsDTO = lastPosts.stream().map(p -> mapper.modelMapper().map(p, PostDTO.class)).toList();
        switch (order){
            case "date_asc" -> postsDTO = postsDTO.stream().sorted(Comparator.comparing(PostDTO::getDate)).collect(Collectors.toList());
            case "date_desc" -> postsDTO = postsDTO.stream().sorted(Comparator.comparing(PostDTO::getDate).reversed()).collect(Collectors.toList());
            //default case is already satisfied
        };
        return new LastPostsDTO(user.getId(), postsDTO);
    }

    // Ejercicio 0010
    @Override
    public void addPostWithPromotion(com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO postDTO) {
        postDTO.setHas_promo(true);
        this.addPost(postDTO);
    }

    // ejercicio 0011
    @Override
    public PromoPostsCountDTO getAmountPromoPost(int userId) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        if(seller.isEmpty()) throw new NotFoundException("No se encontró el usuario solicitado");
        List<Post> promoPosts = postRepository.findPostByUser(userId).stream().filter((Post::isHas_promo)).toList();
        return new PromoPostsCountDTO(seller.get().getUser().getId(), seller.get().getUser().getName(), promoPosts.size());
    }

    // ejercicio 0012

    @Override
    public PostsByUserDTO getPromoPostsByUser(int userId, String order) {
        if(userId == -1) throw new BadRequestException("Debe ingresar un user ID");
        Optional<Seller> seller = sellerRepository.findById(userId);
        if(seller.isEmpty()) throw new NotFoundException("No se encontró el usuario solicitado");
        List<Post> promoPosts =  postRepository.findPostByUser(userId).stream().filter((Post::isHas_promo)).toList();
        List<PostDTO> promoPostsDTO = promoPosts.stream().map(p -> mapper.modelMapper().map(p, PostDTO.class)).toList();
        switch (order){
            case "prod_name_asc" -> promoPostsDTO = promoPostsDTO.stream().sorted(Comparator.comparing(PostDTO::getCategory)).collect(Collectors.toList());
            case "prod_name_desc" -> promoPostsDTO = promoPostsDTO.stream().sorted(Comparator.comparing(PostDTO::getCategory).reversed()).collect(Collectors.toList());
            //default case is already satisfied
        };
        return new PostsByUserDTO(seller.get().getUser().getId(), seller.get().getUser().getName(), promoPostsDTO);
    }
}
