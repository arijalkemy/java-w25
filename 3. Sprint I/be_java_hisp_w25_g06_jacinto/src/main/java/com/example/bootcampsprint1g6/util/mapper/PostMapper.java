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
        if (post instanceof PostPromo) {
             dto = PostPromoResponseDTO.postPromoResponseDTO()
                     .postId(dto.getPostId())
                     .userId(dto.getUserId())
                     .date(dto.getDate())
                     .price(dto.getPrice())
                     .category(dto.getCategory())
                     .hasPromo(true)
                     .discount(((PostPromo) post).getDiscount())
                     .build();
        }
        PostResponseDTO finalDto = dto;
        Optional.ofNullable(post.getProduct()).ifPresent(product -> {
            finalDto.setProduct(ProductMapper.getInstance(product));
        });
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

    public static PostPromo getEntityInstance(PostPromoRequestDTO request, Seller seller) {
        LocalDate localDate = DateFormatter.parseDateString(request.getDate());
        return PostPromo.postPromo()
                .seller(seller)
                .date(localDate)
                .product(ProductMapper.getEntityInstance(request.getProduct()))
                .category(request.getCategory())
                .price(request.getPrice())
                .discount(request.getDiscount())
                .build();
    }

}
