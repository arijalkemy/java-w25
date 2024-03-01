package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponseDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowedDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowersDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;

import java.util.List;

public interface IUserService {
    
    ResponseDTO unfollowUser(Integer userId, Integer userIdToUnfollow);
    UserFollowersDTO getUsersFollowersOf(Integer userId, String order);
    UserFollowedDTO getUsersFollowed(Integer userId, String order);
    void follow(Integer userId, Integer userIdToFollow);
}
