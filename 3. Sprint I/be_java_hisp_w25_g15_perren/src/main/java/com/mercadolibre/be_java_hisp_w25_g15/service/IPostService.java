package com.mercadolibre.be_java_hisp_w25_g15.service;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetPromoListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PromoPostCountDto;
import com.mercadolibre.be_java_hisp_w25_g15.model.Post;

public interface IPostService {
    PostDto createPost(PostDto postDto);

    PostGetListDto getPostsBySellerIdLastTwoWeeks(int userId, DateOrderEnumDto dateOrder);


    PromoPostCountDto countPromoPost(int userId);

    PostGetPromoListDto getPromoPostListByUser(int userId, String order);
}
