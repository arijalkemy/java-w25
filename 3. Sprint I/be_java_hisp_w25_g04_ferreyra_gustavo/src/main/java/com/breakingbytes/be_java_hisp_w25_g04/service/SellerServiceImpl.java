package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPromoPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.request.UserDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.*;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Product;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04.exception.BadRequestException;
import com.breakingbytes.be_java_hisp_w25_g04.exception.NotFoundException;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IPostRepository;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IProductRepository;
import com.breakingbytes.be_java_hisp_w25_g04.repository.ISellerRepository;

import com.breakingbytes.be_java_hisp_w25_g04.repository.IUserRepository;
import com.breakingbytes.be_java_hisp_w25_g04.utils.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements ISellerService{
    ISellerRepository sellerRepository;
    Mapper mapper;
    IPostRepository postRepository;
    IProductRepository productRepository;
    IUserRepository userRepository;

    public SellerServiceImpl(ISellerRepository sellerRepository, Mapper mapper, IPostRepository postRepository, IProductRepository productRepository, IUserRepository iUserRepository) {
        this.sellerRepository = sellerRepository;
        this.mapper = mapper;
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.userRepository = iUserRepository;
    }

    @Override
    public void addPost(RequestPostDTO requestPostDTO) {
        Post post = mapper.modelMapper().map(requestPostDTO, Post.class);
        this.savePost(post);
    }

    @Override
    public void addPromoPost(RequestPromoPostDTO requestPromoPostDTO) {
        Post post = mapper.modelMapper().map(requestPromoPostDTO, Post.class);
        this.savePost(post);
    }

    public void savePost(Post post) {
        Optional<Seller> seller = sellerRepository.findById(post.getUserId());
        if (seller.isEmpty()) throw new NotFoundException("No se ha encontrado un vendedor con ese ID");
        Optional<Product> product = productRepository.findAll().stream()
                .filter(p -> p.getId() == post.getProduct().getId())
                .findFirst();
        if (product.isPresent()) throw new BadRequestException("Ya existe un producto con ese ID");
        sellerRepository.addPost(post, seller.get());
    }

    @Override
    public CountPromoPostDTO countPromoPosts(int sellerId) {
        Optional<Seller> sellerOpt = sellerRepository.findById(sellerId);

        if (sellerOpt.isEmpty()) {
            throw new NotFoundException("No se ha encontrado vendedor con id: " + sellerId);
        }

        Seller seller = sellerOpt.get();

        return new CountPromoPostDTO(sellerId, seller.getName(), ((int) seller.getPosts().stream().filter(Post::isHasPromo).count()));
    }

    @Override
    public List<RequestPostDTO> findAllPosts() {
        return postRepository.findAll()
                .stream().map(p -> mapper.modelMapper().map(p, RequestPostDTO.class)).toList();
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
    @Override
    public ListPostsDTO getPostOfVendorsFollowedByUser(int id, String order) {
        Optional<User> opt = this.userRepository.findById(id);
        if (opt.isEmpty()) throw new NotFoundException("No se encuentra el id buscado");
        User user = opt.get();
        List<ResponsePostDTO> posts = new ArrayList<>();
        for (Seller s : user.getFollowing()){
            for (Post p : s.getPosts()){
                if(!p.getDate().isBefore(LocalDate.now().minusWeeks(2))){
                    if (p.isHasPromo()) {
                        ResponsePostDTO promoPostDTO = mapper.modelMapper().map(p, ResponsePromoPostDTO.class);
                        promoPostDTO.setUserId(s.getId());
                        posts.add(promoPostDTO);
                    } else {
                        ResponsePostDTO responsePostDTO = mapper.modelMapper().map(p, ResponsePostDTO.class);
                        responsePostDTO.setUserId(s.getId());
                        posts.add(responsePostDTO);
                    }
                }
            }
        }
        if(posts.isEmpty()) throw new NotFoundException("No hay publicaciones que cumplan con el requisito");

        switch (order){
            case "date_asc" -> posts.sort(Comparator.comparing(ResponsePostDTO::getDate));
            case "date_desc" -> posts.sort(Comparator.comparing(ResponsePostDTO::getDate).reversed());
            //default case is already satisfied
        };
        return new ListPostsDTO(user.getId(), posts);
    }

    @Override
    public ListPromoPostsDTO listPromoPosts(int id, String order) {
        Optional<Seller> opt = this.sellerRepository.findById(id);
        if (opt.isEmpty()) throw new NotFoundException("No se encuentra el id buscado");
        Seller seller = opt.get();
        List<ResponsePostDTO> posts = new ArrayList<>();

        seller.getPosts().stream().filter(Post::isHasPromo).toList().forEach(post -> {
            ResponsePromoPostDTO promoPostDTO = mapper.modelMapper().map(post, ResponsePromoPostDTO.class);
            promoPostDTO.setUserId(post.getUserId());
            posts.add(promoPostDTO);
        });

        switch (order) {
            case "name_asc" -> posts.sort(Comparator.comparing((ResponsePostDTO responsePostDTO) -> responsePostDTO.getProduct().getName()));
            case "name_desc" -> posts.sort(Comparator.comparing((ResponsePostDTO responsePostDTO) -> responsePostDTO.getProduct().getName()).reversed());
        };

        if(posts.isEmpty()) throw new NotFoundException("No hay publicaciones que cumplan con el requisito");

        return new ListPromoPostsDTO(seller.getId(), seller.getName() ,posts);
    }

    @Override
    public FollowersCountDTO getCountFollowersOfSeller(int id){
        Optional<Seller> seller = sellerRepository.findById(id);
        if(seller.isEmpty()) throw new NotFoundException("ID de usuario invalido");
        return new FollowersCountDTO(seller.get().getId(), seller.get().getName(), seller.get().getFollowers().size());
    }
}
