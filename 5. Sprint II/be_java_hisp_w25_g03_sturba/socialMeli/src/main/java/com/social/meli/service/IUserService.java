package com.social.meli.service;
import com.social.meli.dto.response.FollowedListDto;
import com.social.meli.dto.response.MessageDto;
import com.social.meli.dto.response.VendorFollowCountDto;

public interface IUserService {
    MessageDto newFollow(Integer userId, Integer userIdToFollow);
    FollowedListDto getVendorFollowers(Integer userId, String order);
    VendorFollowCountDto getFollowerCount(Integer userId);

    FollowedListDto getFollowedList(Integer userId, String order);

    MessageDto unfollowUser(Integer userId, Integer userIdToUnfollow);
}
