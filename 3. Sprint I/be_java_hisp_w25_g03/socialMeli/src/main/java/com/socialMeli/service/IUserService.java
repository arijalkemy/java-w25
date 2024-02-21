package com.socialMeli.service;
import com.socialMeli.dto.response.*;

public interface IUserService {
    MessageDto newFollow(Integer userId, Integer userIdToFollow);
    FollowedListDto getVendorFollowers(Integer userId, String order);
    VendorFollowCountDto getFollowerCount(Integer userId);

    FollowedListDto getFollowedList(Integer userId, String order);

    UserUnfollowedDto unfollowUser(Integer userId, Integer userIdToUnfollow);
}
