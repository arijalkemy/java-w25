package com.be_java_hisp_w25_g02_zanaboni.service;

import com.be_java_hisp_w25_g02_zanaboni.dto.response.FollowerCountDTO;
import com.be_java_hisp_w25_g02_zanaboni.dto.response.FollowerListDTO;
import com.be_java_hisp_w25_g02_zanaboni.dto.response.UserFollowingDTO;

import java.util.List;

public interface IUserService{
public FollowerCountDTO getUserTotalFollowers (Integer userId);

List<Integer> getFollowedUsersId(Integer userId);
UserFollowingDTO getFollowedSellers(Integer userId, String order);
FollowerListDTO getFollowersList(Integer userId, String order);
void followUser(Integer userId, Integer userIdToFollow);
void unfollowUser(Integer userId, Integer userIdToUnfollow);
boolean existUser(Integer id);
boolean isSeller(Integer id);
}