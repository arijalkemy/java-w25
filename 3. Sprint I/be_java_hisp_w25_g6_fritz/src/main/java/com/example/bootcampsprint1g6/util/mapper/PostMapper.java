package com.example.bootcampsprint1g6.util.mapper;

import com.example.bootcampsprint1g6.dto.request.PostPromoRequestDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostPromoResponseDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.PostPromo;
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

    public static PostPromoResponseDTO getPromoResponseInstance(PostPromo post){
        PostPromoResponseDTO dto = new PostPromoResponseDTO();
        dto.setUserId(post.getSeller().getUserId());
        dto.setPostId(post.getPostId());
        dto.setDate(DateFormatter.parseDateLocalDate(post.getDate()));
        dto.setPrice(post.getPrice());
        dto.setCategory(post.getCategory());
        dto.setProduct(ProductMapper.getInstance(post.getProduct()));
        dto.setHasPromo(post.getHasPromo());
        dto.setDiscount(post.getDiscount());
        return dto;
    }

    public static List<PostResponseDTO> getResponseInstances(List<Post> posts) {
        return posts.stream().map(PostMapper::getResponseInstance).collect(Collectors.toList());
    }

    public static Post getEntityInstance(PostRequestDTO request, Seller seller) {
        LocalDate localDate = DateFormatter.parseDateString(request.getDate());
        return Post.builder()
                .seller(seller)
                .price(request.getPrice())
                .product(ProductMapper.getEntityInstance(request.getProduct()))
                .date(localDate)
                .category(request.getCategory())
                .build();
    }

    public static PostPromo getPromoEntityInstance(PostPromoRequestDTO request, Seller seller){
        LocalDate localDate = DateFormatter.parseDateString(request.getDate());
        PostPromo postPromo = new PostPromo();
        postPromo.setSeller(seller);
        postPromo.setPrice(request.getPrice()-(request.getPrice()*request.getDiscount()));
        postPromo.setProduct(ProductMapper.getEntityInstance(request.getProduct()));
        postPromo.setDate(localDate);
        postPromo.setCategory(request.getCategory());
        postPromo.setHasPromo(request.getHasPromo());
        postPromo.setDiscount(request.getDiscount());
        return postPromo;
    }

}
