package com.socialMeli.service;

import com.socialMeli.dto.request.PromoPostDto;
import com.socialMeli.dto.response.PromoCountDto;
import com.socialMeli.dto.response.PromosListDto;
import com.socialMeli.dto.response.PublicationDto;

import com.socialMeli.dto.request.PostDTO;

import java.util.List;


public interface IPostService {

    PublicationDto obtainLastPublicationsByTheFollowedVendors(Integer userId, String order);
    void addPost(PostDTO post);

    PromoCountDto obtainPromosCountByVendorId(Integer userId);

    PromosListDto obtainPromosByVendorId(Integer id);
}
