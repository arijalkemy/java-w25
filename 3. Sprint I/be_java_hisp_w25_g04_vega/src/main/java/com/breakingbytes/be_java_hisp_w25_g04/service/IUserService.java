package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponseDTO;
    

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;


import com.breakingbytes.be_java_hisp_w25_g04.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowedDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowersDTO;


import java.util.List;

public interface IUserService {
    
    ResponseDTO unfollowUser(String userId, String userIdToUnfollow);
    List<User> findAll();
    UserFollowersDTO getUsersFollowersOf(int userId, String order);
    UserFollowedDTO getUsersFollowed(int userId, String order);
    void follow(int userId, int userIdToFollow);
}
