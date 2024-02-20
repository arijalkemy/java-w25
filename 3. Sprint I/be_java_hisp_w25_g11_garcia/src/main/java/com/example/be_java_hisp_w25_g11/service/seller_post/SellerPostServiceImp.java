package com.example.be_java_hisp_w25_g11.service.seller_post;

import com.example.be_java_hisp_w25_g11.dto.response.*;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePromoPostRequestDTO;
import com.example.be_java_hisp_w25_g11.entity.Buyer;
import com.example.be_java_hisp_w25_g11.entity.Product;
import com.example.be_java_hisp_w25_g11.entity.Seller;
import com.example.be_java_hisp_w25_g11.entity.SellerPost;
import com.example.be_java_hisp_w25_g11.exception.BadRequestException;
import com.example.be_java_hisp_w25_g11.exception.NotFoundException;
import com.example.be_java_hisp_w25_g11.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.ISellerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller_post.ISellerPostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@Service
public class SellerPostServiceImp implements ISellerPostService {
    private final ISellerPostRepository sellerPostRepository;
    private final IBuyerRepository buyerRepository;
    private final ISellerRepository sellerRepository;
    private final ModelMapper modelMapper;

    public SellerPostServiceImp(
            ISellerPostRepository sellerPostRepository,
            IBuyerRepository buyerRepository,
            ISellerRepository sellerRepository,
            ModelMapper modelMapper
    ) {
        this.sellerPostRepository = sellerPostRepository;
        this.buyerRepository = buyerRepository;
        this.sellerRepository = sellerRepository;
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

    // US 0010 - Publicación de un nuevo producto en promoción
    @Override
    public SellerPromoPostDTO createPromoPost(CreatePromoPostRequestDTO request) {
        Optional<Seller> seller = sellerRepository.get(request.getUserId());
        if (seller.isEmpty())
            throw new NotFoundException("No existe un vendedor con ese ID");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate postDate;
        try {
            postDate = LocalDate.parse(request.getDate(), dateTimeFormatter);
        } catch (DateTimeParseException e) {
            throw new BadRequestException("La fecha ingresada no tiene el formato correcto."
                    + "El formato correcto es dd-MM-yyyy");
        }
        SellerPost sellerPost = new SellerPost(
                request.getUserId(),
                postDate,
                modelMapper.map(request.getProduct(), Product.class),
                request.getCategory(),
                request.getPrice(),
                request.isHasPromo(),
                request.getDiscount(),
                seller.get()
        );

        sellerPost = sellerPostRepository.create(sellerPost);
        seller.get().getPosts().add(sellerPost);

        return modelMapper.map(sellerPost, SellerPromoPostDTO.class);
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

    // US 0011 - Obtener la cantidad de productos en promoción de un determinado vendedor
    @Override
    public PromoPostCountDTO getPromoPostCount(Integer userId) {
        Optional<Seller> seller = sellerRepository.get(userId);
        if (seller.isEmpty())
            throw new NotFoundException("No existe un vendedor con ese ID");

        return new PromoPostCountDTO(
                userId,
                seller.get().getName(),
                seller.get().getPosts().stream()
                        .filter(p -> p.getHasPromo())
                        .toList()
                        .size()
        );
    }

    // US 0012 - Obtener un listado de todos los productos en promoción de un determinado vendedor
    @Override
    public SellerPromoPostsListDTO getPromoPostList(Integer userId) {
        Optional<Seller> seller = sellerRepository.get(userId);
        if (seller.isEmpty())
            throw new NotFoundException("No existe un vendedor con ese ID");

        return new SellerPromoPostsListDTO(
                userId,
                seller.get().getName(),
                seller.get().getPosts().stream()
                        .filter(p -> p.getHasPromo())
                        .map(p -> modelMapper.map(p, SellerPromoPostDTO.class))
                        .toList()
        );
    }
}