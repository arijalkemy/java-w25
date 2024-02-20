package com.mercadolibre.be_java_hisp_w25_g15.service;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostWithPromoDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostsWithPromoCountDto;

public interface IPostService {
    PostDto createPost(PostDto postDto);

    PostGetListDto getPostsOfFollowedSellersByUserInLastTwoWeeks(int userId, DateOrderEnumDto dateOrder);
    PostsWithPromoCountDto getQuantityOfPostsWithPromoBySellerId(int sellerId);
    PostWithPromoDto createPostWithPromo(PostWithPromoDto postWithPromoDto);
}
