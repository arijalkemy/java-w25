package com.mercadolibre.be_java_hisp_w25_g15.service;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountPromoPostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;

public interface IPostService {
    PostDto createPost(PostDto postDto);

    CountPromoPostDto countPromoPostByUser(int userId);

    PostGetListDto getPostsBySellerIdLastTwoWeeks(int userId, DateOrderEnumDto dateOrder);

    PostGetListDto getPromoPostsByUser(int userId, String order);
}
