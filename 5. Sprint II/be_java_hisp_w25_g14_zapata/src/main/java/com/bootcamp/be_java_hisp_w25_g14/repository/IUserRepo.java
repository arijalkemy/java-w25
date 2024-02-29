package com.bootcamp.be_java_hisp_w25_g14.repository;

import com.bootcamp.be_java_hisp_w25_g14.dto.UserDataDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepo {
    void addFollower(Integer userId, Integer userIdToFollow);
    void removeFollow(Integer userID, Integer userIdToUnfollow);
    Optional<User> findUserById(Integer id);
    public List<UserDataDto> getFollowed(Integer userId);
    public List<User> listSellersFollowers(int id);

}
