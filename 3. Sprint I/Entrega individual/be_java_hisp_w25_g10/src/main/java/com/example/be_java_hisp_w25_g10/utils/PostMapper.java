package com.example.be_java_hisp_w25_g10.utils;

import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.dtos.promos.PromoDto;
import com.example.be_java_hisp_w25_g10.dtos.promos.PromoProductDto;
import com.example.be_java_hisp_w25_g10.entities.Post;
import com.example.be_java_hisp_w25_g10.entities.Product;
import com.example.be_java_hisp_w25_g10.entities.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PostMapper {

    private static final Random random = new Random();

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static Post fromDto(PostCreatedDto postDto, User user) {
        Random random = new Random();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate fecha = LocalDate.parse(postDto.date(), formatter);

        return new Post(
                random.nextInt(Integer.MAX_VALUE),
                user,
                fecha,
                postDto.product(),
                false,
                0
        );
    }

    public static Post getPostFromPromDto(PromoDto dto, User user) {
        LocalDate date = LocalDate.parse(dto.date(), formatter);

        return new Post(
                random.nextInt(),
                user,
                date,
                getProductFromPromoProduct(dto.product(), dto),
                dto.has_promo(),
                dto.discount()
        );
    }

    private static Product getProductFromPromoProduct(PromoProductDto dto, PromoDto promoDto) {
        return new Product(dto.product_id(),
                promoDto.category(),
                promoDto.price(),
                dto.product_name(),
                dto.type(),
                dto.brand(),
                dto.color(),
                dto.notes()
        );
    }

    public static PostCreatedDto toDto(Post post) {
        return new PostCreatedDto(
                post.getUser().getId(),
                post.getDate().toString(),
                post.getProduct(),
                post.getProduct().getCategory(),
                post.getProduct().getPrice()
        );
    }

    public static List<PostCreatedDto> ListToDto(List<Post> listPost) {
        List<PostCreatedDto> listPostDto = new ArrayList<>();
        for (Post post : listPost) {
            PostCreatedDto postDto = new PostCreatedDto(
                    post.getUser().getId(),
                    post.getDate().toString(),
                    post.getProduct(),
                    post.getProduct().getCategory(),
                    post.getProduct().getPrice()
            );
            listPostDto.add(postDto);
        }
        return listPostDto;
    }

    public static PromoDto getPromoDtoFromPost(Post post) {
        return new PromoDto(post.getUser().getId(),
                post.getDate().toString(),
                getPromoProductFromProduct(post.getProduct()),
                post.getProduct().getCategory(),
                post.getProduct().getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

    private static PromoProductDto getPromoProductFromProduct(Product product) {
        return new PromoProductDto(product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }
}


