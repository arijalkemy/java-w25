package com.social.meli.service;

import com.social.meli.dto.response.PublicationDto;

import com.social.meli.dto.request.PostDTO;


public interface IPostService {

    PublicationDto obtainLastPublicationsByTheFollowedVendors(Integer userId, String order);
    void addPost(PostDTO post);
}
