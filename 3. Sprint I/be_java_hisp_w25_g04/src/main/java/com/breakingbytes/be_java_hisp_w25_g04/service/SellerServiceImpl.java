package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Product;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04.exception.BadRequestException;
import com.breakingbytes.be_java_hisp_w25_g04.exception.NotFoundException;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IPostRepository;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IProductRepository;
import com.breakingbytes.be_java_hisp_w25_g04.repository.ISellerRepository;

import com.breakingbytes.be_java_hisp_w25_g04.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements ISellerService{
    ISellerRepository sellerRepository;
    Mapper mapper;
    IPostRepository postRepository;
    IProductRepository productRepository;

    public SellerServiceImpl(ISellerRepository sellerRepository, Mapper mapper, IPostRepository postRepository, IProductRepository productRepository) {
        this.sellerRepository = sellerRepository;
        this.mapper = mapper;
        this.postRepository = postRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void addPost(PostDTO postDTO) {
        Post post = mapper.modelMapper().map(postDTO, Post.class);
        Optional<Seller> seller = sellerRepository.findById(postDTO.getUserId());
        if (seller.isEmpty()) throw new NotFoundException("No se ha encontrado un vendedor con ese ID");
        Optional<Product> product = productRepository.findAll().stream()
                .filter(p -> p.getId() == postDTO.getProduct().getId())
                .findFirst();
        if (product.isPresent()) throw new BadRequestException("Ya existe un producto con ese ID");
        sellerRepository.addPost(post, seller.get());
    }

    @Override
    public List<PostDTO> findAllPosts() {
        return postRepository.findAll()
                .stream().map(p -> mapper.modelMapper().map(p, PostDTO.class)).toList();
    }

    public Boolean quitFollower(String sellerId, String userId) {
        Integer sellerIdInt = Integer.valueOf(sellerId),
                userIdInt = Integer.valueOf(userId);

        Optional<Seller> sellerOpt = sellerRepository.findById(sellerIdInt);
        if(sellerOpt.isEmpty()) {
            throw new NotFoundException("No se ha encontrado vendedor con id: " + sellerId);
        }

        Seller seller = sellerOpt.get();
        List<User> sellerFollowers = seller.getFollowers();
        Optional<User> userUnfollowedOpt = sellerFollowers
                                                .stream()
                                                .filter(u -> u.getId() == userIdInt)
                                                .findFirst();
        if(userUnfollowedOpt.isEmpty()) {
            throw new NotFoundException("El usuario no se encuentra entre los seguidores.");
        }

        User user = userUnfollowedOpt.get();
        sellerFollowers.remove(user);
        sellerRepository.setSellerFollowers(sellerIdInt, sellerFollowers);

        return true;
    }
}
