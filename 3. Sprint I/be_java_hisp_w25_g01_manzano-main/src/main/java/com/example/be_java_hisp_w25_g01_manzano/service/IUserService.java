package com.example.be_java_hisp_w25_g01_manzano.service;

import com.example.be_java_hisp_w25_g01_manzano.dto.response.*;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAll();
    FollowersDTO getFollowersList(Integer userId);
    FollowersCountDTO  getFollowersCount(Integer userId);
    MessagesDTO followUser (Integer UserId,Integer userIdToFollow );

    MessagesDTO unfollowUser (Integer UserId,Integer userIdToUnfollow );

    FollowedDTO getFollowedList(Integer userId);



}
