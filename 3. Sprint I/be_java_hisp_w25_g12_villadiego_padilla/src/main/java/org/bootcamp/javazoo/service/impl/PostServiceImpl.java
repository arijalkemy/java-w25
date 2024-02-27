package org.bootcamp.javazoo.service.impl;

import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostPromoDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.dto.response.PromoProductsCountDto;
import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.PostPromo;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.exception.NotFoundException;
import org.bootcamp.javazoo.repository.interfaces.IPostRepository;
import org.bootcamp.javazoo.repository.interfaces.ISellerRepository;
import org.bootcamp.javazoo.service.interfaces.IPostService;
import org.bootcamp.javazoo.service.interfaces.IProductService;
import org.bootcamp.javazoo.service.interfaces.ISellerService;
import org.bootcamp.javazoo.service.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.bootcamp.javazoo.dto.MessageDTO;
import org.bootcamp.javazoo.dto.ProductDto;
import org.bootcamp.javazoo.entity.Product;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {
    IUserService userService;
    IPostRepository postRepository;
    IPostRepository postPromoRepository;
    IProductService productService;
    ISellerService sellerService;
    IPostRepository postPromoListRepository;

    private final ISellerRepository sellerRepository;

    public PostServiceImpl(IPostRepository postPromoListRepository, ISellerRepository sellerRepository, IUserService userService, IPostRepository postRepository, IProductService productService, ISellerService sellerService, IPostRepository postPromoRepository, ISellerService sellerServicePromo) {
        this.userService = userService;
        this.postRepository = postRepository;
        this.productService = productService;
        this.sellerService = sellerService;
        this.postPromoRepository = postPromoRepository;
        this.sellerRepository = sellerRepository;
        this.postPromoListRepository = postPromoListRepository;

    }

    @Override
    public List<Post> getPostSorted(List<Post> postsToOrder){
        return postsToOrder.stream()
                .sorted(Comparator.comparing(Post::getDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsBySeller(int userId){
        List<Seller> sellers = userService.getUserFollowed(userId);
        if(sellers.isEmpty()) throw new NotFoundException("El usuario no sigue a ningun vendedor actualmente");
        return sellers.stream().flatMap(seller1 -> {
            List<Post> postBySeller = getPostSorted(filterPostsByWeeksAgo(2, seller1.getPosts()));
            return postBySeller.stream()
                    .map(this::mapToPostDto);
        }).toList();
    }

    @Override
    public PostsFollowedUserDto getPostsBySellerOfUser(int userId){
        List<PostDto> postDtos = getPostsBySeller(userId);
        return mapToPostsFollowedUserDto(postDtos, userId);
    }

    @Override
    public PostDto mapToPostDto(Post postToMap){
        return new PostDto(
                postToMap.getSeller().getId(),
                postToMap.getId(),
                postToMap.getDate().toString(),
                productService.mapToProductDto(postToMap.getProduct()),
                postToMap.getCategory(),
                postToMap.getPrice());
    }

    public PromoProductsCountDto mapToPostPromoDto(Seller seller, int postPromoCount){
        return new PromoProductsCountDto(seller.getId(),
                seller.getName(),
                postPromoCount);
    }

    @Override
    public PostsFollowedUserDto mapToPostsFollowedUserDto(List<PostDto> postDtos, int userId){
        return new PostsFollowedUserDto(userId, postDtos);
    }


    public List<Post> filterPostsByWeeksAgo(int weeks, List<Post> posts){
        LocalDate weeksAgo = LocalDate.now().minusWeeks(weeks);
        return posts.stream()
                .filter(post -> post.getDate().isAfter(weeksAgo))
                .collect(Collectors.toList());
    }
    @Override
    public MessageDTO addNewPost(PostDto postDto) {
        try{
            postRepository.addNewPost(convertDtoToPost(postDto));
            return new MessageDTO("La publicación se creo exitosamente");
        }catch (RuntimeException e){
            throw new RuntimeException(e + " No se pudo realizar la petición");
        }
    }

    @Override
    public ResponseEntity<MessageDTO> addNewPostPromo(PostPromoDto postPromoDto) {
        try {
            Seller seller = sellerRepository.findById(postPromoDto.getUser_id());
            if (seller == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageDTO("Seller not found"));
            }
            postPromoRepository.addNewPostPromo(convertDtoToPostPromo(postPromoDto));
            return ResponseEntity.ok(new MessageDTO("The post was created successfully"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageDTO("Error while creating the post"));
        }
    }

    private Post convertDtoToPost(PostDto postDto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate datetimnkls = LocalDate.parse(postDto.getDate(), formatter);
        return new Post(
                postDto.getPost_id(),
                sellerService.getById(postDto.getUser_id()),
                LocalDate.parse(postDto.getDate(), formatter),
                convertDtoToProduct(postDto.getProduct()),
                postDto.getCategory(),
                postDto.getPrice()
        );
    }

    private PostPromo convertDtoToPostPromo(PostPromoDto postPromoDto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate datetimnkls = LocalDate.parse(postPromoDto.getDate(), formatter);
        return new PostPromo(
                postPromoDto.getPost_id(),
                sellerService.getById(postPromoDto.getUser_id()),
                LocalDate.parse(postPromoDto.getDate(), formatter),
                convertDtoToProduct(postPromoDto.getProduct()),
                postPromoDto.getCategory(),
                postPromoDto.getPrice(),
                postPromoDto.getHas_promo(),
                postPromoDto.getDiscount()
        );
    }

    @Override
    public Product convertDtoToProduct(ProductDto productDto) {
        return new Product(
                productDto.getProduct_id(),
                productDto.getProduct_name(),
                productDto.getType(),
                productDto.getBrand(),
                productDto.getColor(),
                productDto.getNotes()
        );
    }

    @Override
    public Product convertDtoToPostPromo(ProductDto productDto) {
        return new Product(
                productDto.getProduct_id(),
                productDto.getProduct_name(),
                productDto.getType(),
                productDto.getBrand(),
                productDto.getColor(),
                productDto.getNotes()
        );
    }
    @Override
    public PromoProductsCountDto getAllPostPromo(Integer userId){
        Seller seller = sellerService.getById(userId);
        int getPromos = seller.getPostsPromo().size();
        return mapToPostPromoDto(seller,getPromos);
    }
}
