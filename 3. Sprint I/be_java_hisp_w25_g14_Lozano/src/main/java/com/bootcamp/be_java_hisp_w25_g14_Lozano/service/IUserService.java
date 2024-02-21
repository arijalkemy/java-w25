package com.bootcamp.be_java_hisp_w25_g14_Lozano.service;

import com.bootcamp.be_java_hisp_w25_g14_Lozano.dto.ProductPromoCountDto;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.dto.UserFollowersCountDto;

import com.bootcamp.be_java_hisp_w25_g14_Lozano.dto.FollowedListResponseDto;

public interface IUserService {
    void addFollowe(Integer userId, Integer userIdToFollow);
    void removeFollow(Integer userId, Integer userIdToUnfollow);

    UserFollowersCountDto getUserFollowersCount(Integer userId);
    FollowedListResponseDto getFollowedByUser(Integer userId);

    public FollowedListResponseDto listSellersFollowers(int id, String order);


}
