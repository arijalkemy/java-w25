package com.socialMeli.service;

import com.socialMeli.dto.response.PublicationDto;

import com.socialMeli.dto.request.PostDTO;


public interface IPostService {

    PublicationDto obtainLastPublicationsByTheFollowedVendors(Integer userId, String order);
    void addPost(PostDTO post);
}
