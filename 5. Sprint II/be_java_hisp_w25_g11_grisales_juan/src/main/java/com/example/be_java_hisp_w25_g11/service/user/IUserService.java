package com.example.be_java_hisp_w25_g11.service.user;

import com.example.be_java_hisp_w25_g11.dto.request.OrganizerByNameDTO;
import com.example.be_java_hisp_w25_g11.dto.response.FollowedDTO;
import com.example.be_java_hisp_w25_g11.dto.response.FollowerCountDTO;
import com.example.be_java_hisp_w25_g11.dto.response.FollowerDTO;
import com.example.be_java_hisp_w25_g11.dto.response.SuccessDTO;

public interface IUserService {

    SuccessDTO follow(Integer userId, Integer userIdToFollow);
    FollowerCountDTO followersSellersCount(Integer sellerId);
    FollowerDTO userFollowSellers(Integer sellerId);
    SuccessDTO unfollow(Integer userId, Integer sellerIdToUnfollow);
    FollowerDTO sortFollowers(Integer userId, String order);
    FollowedDTO sortFollowed(Integer userId, String order);
    boolean isSeller(Integer userId);
}