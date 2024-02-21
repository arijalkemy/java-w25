package com.socialMeli.service;
import com.socialMeli.dto.response.UserUnfollowedDto;

import com.socialMeli.dto.response.MessageDTO;
import com.socialMeli.dto.response.VendorFollowerListDTO;
import com.socialMeli.dto.response.FollowedListDto;
import com.socialMeli.dto.response.VendorFollowCountDto;

import java.util.List;

public interface IUserService {
    MessageDTO newFollow(Integer userId, Integer userIdToFollow);
    VendorFollowerListDTO getVendorFollowers(Integer userId, String order);
    VendorFollowCountDto getFollowerCount(Integer userId);

    FollowedListDto getFollowedList(Integer userId, String order);

    UserUnfollowedDto unfollowUser(Integer userId, Integer userIdToUnfollow);
}
