package com.example.be_java_hisp_w25_g11_grisales.service.seller_post;

import com.example.be_java_hisp_w25_g11_grisales.dto.SellerPostDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.SellerPromoPostDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.request.CreatePromoPostDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.response.SellerPostsListDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.response.SellerPromoCountDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.response.SellerPromoPostListDTO;
import com.example.be_java_hisp_w25_g11_grisales.entity.Buyer;
import com.example.be_java_hisp_w25_g11_grisales.entity.Product;
import com.example.be_java_hisp_w25_g11_grisales.entity.Seller;
import com.example.be_java_hisp_w25_g11_grisales.entity.SellerPost;
import com.example.be_java_hisp_w25_g11_grisales.exception.NotFoundException;
import com.example.be_java_hisp_w25_g11_grisales.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11_grisales.repository.seller.ISellerRepository;
import com.example.be_java_hisp_w25_g11_grisales.repository.seller_post.ISellerPostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @Override
    public SellerPromoPostDTO createNewPromoProduct(CreatePromoPostDTO promoRequest) {
        Optional<Seller> seller = sellerRepository.get(promoRequest.getId());
        if (seller.isEmpty()){
            throw new NotFoundException("No se encuentra un vendedor con ese id");
        }
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        SellerPost sellerPost = new SellerPost(
                promoRequest.getId(),
                null,
                LocalDate.parse(promoRequest.getDate(), dateFormat),
                modelMapper.map(promoRequest.getProduct(), Product.class),
                promoRequest.getCategory(),
                promoRequest.getPrice(),
                seller.get(),
                promoRequest.isHasPromo(),
                promoRequest.getDiscount()
        );
        sellerPost = sellerPostRepository.create(sellerPost);
        seller.get().getPosts().add(sellerPost);

        return modelMapper.map(sellerPost, SellerPromoPostDTO.class);
    }

    @Override
    public SellerPromoCountDTO countPromoProducts(Integer userId) {
        Optional<Seller> seller = sellerRepository.get(userId);
        if (seller.isEmpty()){
            throw new NotFoundException("El usuario con este id no existe");
        }
        int countPromo = (int) seller.get().getPosts()
                .stream()
                .filter(SellerPost::isHasPromo)
                .count();

        return new SellerPromoCountDTO(seller.get().getId(), seller.get().getName(), countPromo);
    }

    @Override
    public SellerPromoPostListDTO getSellerPromoProductList(Integer userId) {
        Optional<Seller> seller = sellerRepository.get(userId);
        if (seller.isEmpty()){
            throw new NotFoundException("No se encuentra un usuario con ese id");
        }
        List<SellerPromoPostDTO> promoList = seller.get().getPosts()
                .stream()
                .filter(SellerPost::isHasPromo)
                .map(promo -> modelMapper.map(promo, SellerPromoPostDTO.class))
                .toList();
        return new SellerPromoPostListDTO(
                seller.get().getId(),
                seller.get().getName(),
                promoList);
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