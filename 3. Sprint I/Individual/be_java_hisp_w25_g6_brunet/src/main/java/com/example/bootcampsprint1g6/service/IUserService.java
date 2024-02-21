package com.example.bootcampsprint1g6.service;


import com.example.bootcampsprint1g6.dto.FollowedDTO;
import com.example.bootcampsprint1g6.dto.FollowersDTO;
import com.example.bootcampsprint1g6.dto.FollowersCountDTO;
import com.example.bootcampsprint1g6.dto.GenericResponseDTO;

public interface IUserService {
    GenericResponseDTO follow(Integer user, Integer userIdToFollow);
    FollowedDTO getFollowedList(Integer userId, String order);


    FollowersDTO getFollowersList(Integer userId, String order);
    GenericResponseDTO unfollow(Integer user, Integer userIdToFollow);
    FollowersCountDTO getFollowersCount(Integer userId);

}
