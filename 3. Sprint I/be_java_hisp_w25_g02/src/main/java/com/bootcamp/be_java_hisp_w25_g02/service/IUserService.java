package com.bootcamp.be_java_hisp_w25_g02.service;
import com.bootcamp.be_java_hisp_w25_g02.entity.User;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserFollowingDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerListDTO;
import java.util.List;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerCountDTO;

public interface IUserService {
    public FollowerCountDTO getUserTotalFollowers (Integer userId);

    List<Integer> getFollowedUsersId(Integer userId);
    UserFollowingDTO getFollowedSellers(Integer userId, String order);
    FollowerListDTO getFollowersList(Integer userId, String order);
    void followUser(Integer userId, Integer userIdToFollow);
    void unfollowUser(Integer userId, Integer userIdToUnfollow);
    boolean existUser(Integer id);
    boolean isSeller(Integer id);
}


