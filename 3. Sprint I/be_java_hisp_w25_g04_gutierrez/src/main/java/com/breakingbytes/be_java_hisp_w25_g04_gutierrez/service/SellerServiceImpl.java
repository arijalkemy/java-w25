package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.service;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.PromoPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.ResponsePostDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.Product;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.exception.BadRequestException;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.exception.NotFoundException;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.repository.IPostRepository;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.repository.IProductRepository;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.repository.ISellerRepository;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.repository.IUserRepository;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.utils.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
    public void addPost(PostDTO postDTO) {
        Post post = mapper.modelMapper().map(postDTO, Post.class);

        if (post.isHasPromo() && post.getDiscount() <= 0) throw new BadRequestException("No puedes agregar una promo sin descuento!");
        if (post.getPrice() <= 0) throw new BadRequestException("No puedes agregar un post sin precio!");

        Optional<Seller> seller = sellerRepository.findById(postDTO.getUserId());
        if (seller.isEmpty()) throw new NotFoundException("No se ha encontrado un vendedor con ese ID");
        Optional<Product> product = productRepository.findAll().stream()
                .filter(p -> p.getId() == postDTO.getProduct().getId())
                .findFirst();
        if (product.isPresent()) throw new BadRequestException("Ya existe un producto con ese ID");
        sellerRepository.addPost(post, seller.get());
    }

    @Override
    public PromoPostDTO getPromoPostCount(int userId) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        if(seller.isEmpty()) throw new NotFoundException("No existe un vendedor con ese ID");
        long amount = seller.get().getPosts().stream()
                .filter(Post::isHasPromo)
                .count();
        return new PromoPostDTO(
                seller.get().getId(),
                seller.get().getName(),
                (int) amount
        );
    }

    @Override
    public List<PostDTO> getPromoPosts(int userId) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        if(seller.isEmpty()) throw new NotFoundException("No existe un vendedor con ese ID");
        List<Post> postsList = seller.get().getPosts().stream().filter(Post::isHasPromo).toList();
        if (postsList.isEmpty()) throw new NotFoundException("El vendedor no tiene posts en promoción");
        return postsList.stream().map(p -> mapper.modelMapper().map(p, PostDTO.class)).toList();
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
    @Override
    public LastPostsDTO getPostOfVendorsFollowedByUser(int id, String order) {
        Optional<User> opt = this.userRepository.findById(id);
        if (opt.isEmpty()) throw new NotFoundException("No se encuentra el id buscado");
        User user = opt.get();
        List<ResponsePostDTO> posts = new ArrayList<>();
        for (Seller s : user.getFollowing()){
            for (Post p : s.getPosts()){
                if(!p.getDate().isBefore(LocalDate.now().minusWeeks(2))){
                    ResponsePostDTO responsePostDTO = mapper.modelMapper().map(p, ResponsePostDTO.class);
                    responsePostDTO.setUserId(s.getId());
                    posts.add(responsePostDTO);
                }
            }
        }
        if(posts.isEmpty()) throw new NotFoundException("No hay publicaciones que cumplan con el requisito");

        switch (order){
            case "date_asc" -> posts.sort(Comparator.comparing(ResponsePostDTO::getDate));
            case "date_desc" -> posts.sort(Comparator.comparing(ResponsePostDTO::getDate).reversed());
            //default case is already satisfied
        };
        return new LastPostsDTO(user.getId(), posts);
    }
    @Override
    public FollowersCountDTO getCountFollowersOfSeller(int id){
        Optional<Seller> seller = sellerRepository.findById(id);
        if(seller.isEmpty()) throw new NotFoundException("ID de usuario invalido");
        return new FollowersCountDTO(seller.get().getId(), seller.get().getName(), seller.get().getFollowers().size());
    }
}
