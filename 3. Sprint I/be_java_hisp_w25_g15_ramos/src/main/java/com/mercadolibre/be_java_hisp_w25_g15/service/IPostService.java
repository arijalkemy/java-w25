package com.mercadolibre.be_java_hisp_w25_g15.service;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostOfferDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountOffersDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.model.PostOffer;

import java.util.List;

public interface IPostService {
    PostDto createPost(PostDto postDto);
    PostOfferDto createPostOffer(PostOfferDto postOfferDto);

    PostGetListDto getPostsBySellerIdLastTwoWeeks(int userId, DateOrderEnumDto dateOrder);

    CountOffersDto countPromoPostsByUserId(int userId);

    List<PostOffer> getPromoPostsByUserId(int userId);


}
