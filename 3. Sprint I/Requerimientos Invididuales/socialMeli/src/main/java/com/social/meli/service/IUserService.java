package com.social.meli.service;
import com.social.meli.dto.response.UserUnfollowedDto;

import com.social.meli.dto.response.MessageDTO;
import com.social.meli.dto.response.FollowedListDto;
import com.social.meli.dto.response.VendorFollowCountDto;


public interface IUserService {
    MessageDTO newFollow(Integer userId, Integer userIdToFollow);
    FollowedListDto getVendorFollowers(Integer userId, String order);
    VendorFollowCountDto getFollowerCount(Integer userId);

    FollowedListDto getFollowedList(Integer userId, String order);

    MessageDTO unfollowUser(Integer userId, Integer userIdToUnfollow);
}
