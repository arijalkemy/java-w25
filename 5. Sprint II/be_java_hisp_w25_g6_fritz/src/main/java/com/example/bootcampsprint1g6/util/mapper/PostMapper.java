package com.example.bootcampsprint1g6.util.mapper;

import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.util.DateFormatter;

import java.time.LocalDate;
import java.util.Optional;

public class PostMapper {

    /**
     * Get a PostResponseDTO instance from a Post instance
     * @param post Post the post instance to return
     * @return the postResponseDTO ready to send
     */
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

    /**
     * Get a Post instance from a PostRequestDTO and a seller instance
     * @param request PostRequestDTO the post info sent to create the post
     * @param seller the seller instace that will own the post
     * @return the post created
     */
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

}
