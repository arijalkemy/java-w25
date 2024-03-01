package com.example.bootcampsprint1g6.util.mapper;

import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostPromoResponseDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.util.DateFormatter;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostResponseDTO getResponseInstance(Post post) {
        PostResponseDTO dto = PostResponseDTO.builder()
                .postId(post.getPostId())
                .userId(post.getSeller().getUserId())
                .date(DateFormatter.parseDateLocalDate(post.getDate()))
                .price(post.getPrice())
                .category(post.getCategory())
                .build();
        Optional.ofNullable(post.getProduct()).ifPresent(product -> {
            dto.setProduct(ProductMapper.getInstance(product));
        });
        return dto;
    }

    public static List<PostResponseDTO> getResponseInstances(List<Post> posts) {
        return posts.stream().map(PostMapper::getResponseInstance).collect(Collectors.toList());
    }

    public static Post getEntityInstance(PostRequestDTO request, Seller seller) {
        LocalDate localDate = DateFormatter.parseDateString(request.getDate());
        Post post = new Post();
        post.setSeller(seller);
        post.setDate(localDate);
        post.setPrice(request.getPrice());
        post.setProduct(ProductMapper.getEntityInstance(request.getProduct()));
        post.setCategory(request.getCategory());
        post.setHasPromo(request.getHasPromo());
        Optional.ofNullable(request.getHasPromo()).ifPresent(post::setHasPromo);
        Optional.ofNullable(request.getDiscount()).ifPresent(post::setDiscount);
//        Optional.ofNullable(request.getDiscount()).ifPresent(discount -> {
//            post.setPromo(Optional.of(new Promo(discount.get())));
//        });
//        post.setDiscount(request.getDiscount());
        return post;
    }

    public static List<PostPromoResponseDTO> getResponseInstancesPromo(List<Post> posts) {
        return posts.stream().map(PostMapper::getResponseInstancePromo).collect(Collectors.toList());
    }
    public static PostPromoResponseDTO getResponseInstancePromo(Post post) {
        PostPromoResponseDTO dto = new PostPromoResponseDTO();
        dto.setPostId(post.getPostId());
        dto.setUserId(post.getSeller().getUserId());
        dto.setDate(DateFormatter.parseDateLocalDate(post.getDate()));
        dto.setPrice(post.getPrice());
        dto.setCategory(post.getCategory());

        Optional.ofNullable(post.getProduct()).ifPresent(
                product -> {dto.setProduct(ProductMapper.getInstance(product));}
        );

        Optional.ofNullable(post.getHasPromo()).ifPresent(dto::setHasPromo);
        Optional.ofNullable(post.getDiscount()).ifPresent(dto::setDiscount);
        return dto;
    }

}
