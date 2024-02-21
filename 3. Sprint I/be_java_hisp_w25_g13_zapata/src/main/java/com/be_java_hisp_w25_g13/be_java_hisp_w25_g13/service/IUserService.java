package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.*;

import java.util.List;

public interface IUserService {
    void followUser(Integer userId, Integer userIdToFollow);
    void unFollowUser(Integer userId, Integer userIdToUnfollow);
    UserDTO addUser(UserDTO userDto);
    FollowersDTO getFollowers(Integer userId, String orderBy);
    FollowedDTO getFollowed(Integer userId, String orderBy);
    NumberDTO getNumberOfFollowers(Integer userId);
    SellerPostDTO getPostPerSeller(Integer id, String order);
    List<UserDTO> getAllUsers();

    SellerPromoDTO getPromosPerUser(Integer userId, String order);
}
