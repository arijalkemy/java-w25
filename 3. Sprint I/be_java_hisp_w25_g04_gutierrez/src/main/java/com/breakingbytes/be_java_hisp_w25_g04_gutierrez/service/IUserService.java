package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.service;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.request.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.*;


import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.User;


import java.util.List;

public interface IUserService {
    
    ResponseDTO unfollowUser(String userId, String userIdToUnfollow);
    List<User> findAll();
    LastPostsDto getPostOfVendorsFollowedByUser(int id, String order);
    FollowersCountDTO getCountFollowersOfSeller(int id);
    UserFollowersDTO getUsersFollowersOf(int userId, String order);
    UserFollowedDTO getUsersFollowed(int userId, String order);
    void follow(int userId, int userIdToFollow);

    PromoPostCountDTO getPromoPostCount(int userId);

    List<PostDTO> getPromoPosts(int userId);
}
