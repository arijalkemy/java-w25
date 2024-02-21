package com.bootcamp.be_java_hisp_w25_g9.service.interfaces;

import com.bootcamp.be_java_hisp_w25_g9.dto.response.*;

public interface IUserService {
    MessageDto follow(int userId, int userIdToFollow);
    MessageDto unfollow(int uerId, int userIdToUnfollow);
    FolowersCountDto getFollowersCount(int userId);
    FollowersDto getFollowers(int userId);
    FollowersDto getFollowers(int userId, String order);
    FollowedDto getFollowed(int userId);
    FollowedDto getFollowed(int userId,String order);

}
