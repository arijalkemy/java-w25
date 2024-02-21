package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.service;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.ResponseDTO;
    

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.User;


import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.UserFollowedDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.UserFollowersDTO;


import java.util.List;

public interface IUserService {
    
    ResponseDTO unfollowUser(String userId, String userIdToUnfollow);
    List<User> findAll();
    UserFollowersDTO getUsersFollowersOf(int userId, String order);
    UserFollowedDTO getUsersFollowed(int userId, String order);
    void follow(int userId, int userIdToFollow);
}
