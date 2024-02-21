package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponseDTO;


import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowedDTO;

public interface IUserService {
    
    ResponseDTO unfollow(String userId, String userIdToUnfollow);
    UserFollowedDTO getUsersFollowed(int userId, String order);
    void follow(int userId, int userIdToFollow);
}
