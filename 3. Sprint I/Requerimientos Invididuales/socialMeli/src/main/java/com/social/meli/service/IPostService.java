package com.social.meli.service;

import com.social.meli.dto.request.PromoPostDto;
import com.social.meli.dto.response.VendorPromoProductCountDto;
import com.social.meli.dto.response.PostDto;
import com.social.meli.dto.response.PublicationDto;

import com.social.meli.dto.request.PostDTO;
import com.social.meli.dto.response.VendorPromoProductListDto;


public interface IPostService {

    PublicationDto obtainLastPublicationsByTheFollowedVendors(Integer userId, String order);
    void addPost(PostDTO post);

    void addPromoPost(PromoPostDto promoPostDto);

    VendorPromoProductCountDto getVendorPromoProductCount(Integer userId);

    VendorPromoProductListDto getVendorPromoProductList(Integer userId);
}
