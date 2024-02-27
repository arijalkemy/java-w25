package com.example.be_java_hisp_w25_g11.service.seller_post;

import com.example.be_java_hisp_w25_g11.dto.product.ProductDTO;
import com.example.be_java_hisp_w25_g11.dto.product.ProductoPromoQuantityDTO;
import com.example.be_java_hisp_w25_g11.dto.seller.SellerPostDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestWithPromoDTO;
import com.example.be_java_hisp_w25_g11.dto.seller.SellerPostListWithDiscountDTO;
import com.example.be_java_hisp_w25_g11.dto.seller.SellerPostsListDTO;
import com.example.be_java_hisp_w25_g11.dto.seller.SellerPostWithDiscountDTO;
import com.example.be_java_hisp_w25_g11.entity.*;
import com.example.be_java_hisp_w25_g11.exception.NotFoundException;
import com.example.be_java_hisp_w25_g11.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11.repository.discount.IDiscountRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.ISellerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller_post.ISellerPostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class SellerPostServiceImp implements ISellerPostService {
    private final ISellerPostRepository sellerPostRepository;
    private final IDiscountRepository discountRepository;
    private final ISellerRepository sellerRepository;
    private final IBuyerRepository buyerRepository;
    private final ModelMapper modelMapper;

    public SellerPostServiceImp(
            ISellerPostRepository sellerPostRepository,
            IDiscountRepository discountRepository,
            ISellerRepository sellerRepository,
            IBuyerRepository buyerRepository,
            ModelMapper modelMapper
    ) {
        this.sellerPostRepository = sellerPostRepository;
        this.discountRepository = discountRepository;
        this.sellerRepository = sellerRepository;
        this.buyerRepository = buyerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SellerPostDTO createPost(CreatePostRequestDTO request) {
        Optional<Seller> seller = sellerRepository.get(request.getUserId());
        if (seller.isEmpty())
            throw new NotFoundException("No existe un vendedor con ese ID");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        SellerPost sellerPost = new SellerPost(
                request.getUserId(),
                null,
                LocalDate.parse(request.getDate(), dateTimeFormatter),
                modelMapper.map(request.getProduct(), Product.class),
                request.getCategory(),
                request.getPrice(),
                seller.get()
        );

        sellerPost = sellerPostRepository.create(sellerPost);
        seller.get().getPosts().add(sellerPost);

        return modelMapper.map(sellerPost, SellerPostDTO.class);
    }

    @Override
    public SellerPostWithDiscountDTO createPostWithPromo(CreatePostRequestWithPromoDTO request) {
        CreatePostRequestDTO requestDTO = modelMapper.map(request,CreatePostRequestDTO.class);
        SellerPostDTO sellerPostDTO =  this.createPost(requestDTO);


        this.discountRepository.create(new Discount(
                            request.getUserId(),
                            request.getProduct().getId(),
                            sellerPostDTO.getPostId(),
                            request.isHasPromo(),
                            request.getDiscount()));

        return new SellerPostWithDiscountDTO(
                sellerPostDTO.getUserId(),
                sellerPostDTO.getPostId(),
                sellerPostDTO.getDate(),
                sellerPostDTO.getProduct(),
                sellerPostDTO.getCategory(),
                sellerPostDTO.getPrice(),
                request.isHasPromo(),
                request.getDiscount());
    }

    @Override
    public SellerPostListWithDiscountDTO getAllPromoProducts(Integer userId) {
        Optional<Seller> seller = sellerRepository.get(userId);
        if (seller.isEmpty())
            throw new NotFoundException("No existe un vendedor con ese ID");
        List<SellerPostWithDiscountDTO> listWithDiscountDTOS =  this.discountRepository
                .getAll()
                .stream()
                .filter(discount -> discount.getUserId() == seller.get().getId())
                .map(discount -> {
                    Optional<SellerPost> sellerPost = this.sellerPostRepository.get(discount.getPostId());
                    if(sellerPost.isPresent() &&
                            sellerPost.get().getProduct().getId() == discount.getProductId() &&
                            sellerPost.get().getSeller().getId() == discount.getUserId()){
                        return new SellerPostWithDiscountDTO(
                                sellerPost.get().getUserId(),
                                sellerPost.get().getPostId(),
                                sellerPost.get().getDate().toString(),
                                modelMapper.map(sellerPost.get().getProduct(), ProductDTO.class),
                                sellerPost.get().getCategory(),
                                sellerPost.get().getPrice(),
                                discount.isHasPromo(),
                                discount.getDiscount()
                        );}
                    return null;
                }).filter(result -> result != null).toList();

        return  new SellerPostListWithDiscountDTO(seller.get().getId(),listWithDiscountDTOS);
    }

    @Override
    public ProductoPromoQuantityDTO getQuantityOfProductsWithPromo(Integer userId) {
        Optional<Seller> seller =  this.sellerRepository.get(userId);
        if (seller.isEmpty())
            throw new NotFoundException("No existe un vendedor con ese ID");
        return  new ProductoPromoQuantityDTO(
                seller.get().getId(),
                seller.get().getName(),
                this.discountRepository
                        .getAll().stream()
                        .filter(discount ->
                                discount.getUserId() == userId &&
                                discount.isHasPromo()).count());
    }

    @Override
    public SellerPostsListDTO getFollowedSellersLatestPosts(Integer userId, String order) {
        List<SellerPost> posts;

        Optional<Buyer> buyer = buyerRepository.get(userId);
        Optional<Seller> seller = sellerRepository.get(userId);
        if (buyer.isPresent())
            posts = getMergedPostsList(buyer.get().getFollowed());
        else if (seller.isPresent())
            posts = getMergedPostsList(seller.get().getFollowed());
        else throw new NotFoundException(String.format("No se encontró un usuario con el id %d", userId));

        if (order == null) {
            return new SellerPostsListDTO(
                    userId,
                    posts
                            .stream()
                            .map(v -> modelMapper.map(v, SellerPostDTO.class))
                            .toList()
            );
        }

        Comparator<SellerPost> comparator = order.equalsIgnoreCase("DATE_ASC") ?
                Comparator.comparing(SellerPost::getDate) : Comparator.comparing(SellerPost::getDate).reversed();

        return new SellerPostsListDTO(
                userId,
                posts
                        .stream()
                        .sorted(comparator)
                        .map(p -> modelMapper.map(p, SellerPostDTO.class))
                        .toList()
        );
    }

    private List<SellerPost> getMergedPostsList(Set<Integer> followed) {
        List<SellerPost> posts;
        posts = followed
                .stream()
                .map(s -> {
                    Optional<Seller> followedSeller = sellerRepository.get(s);
                    if (followedSeller.isEmpty())
                        throw new NotFoundException("No se pudo encontrar la información de un vendedor");

                    return followedSeller
                            .get()
                            .getPosts()
                            .stream()
                            .filter(p -> p.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                            .toList();
                })
                .flatMap(List::stream)
                .toList();

        return posts;
    }

    private boolean compareDate(LocalDate a, LocalDate b) {
        return a.isAfter(b);
    }
}