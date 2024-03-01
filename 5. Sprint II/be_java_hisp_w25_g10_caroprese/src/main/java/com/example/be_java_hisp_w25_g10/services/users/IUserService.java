package com.example.be_java_hisp_w25_g10.services.users;

import com.example.be_java_hisp_w25_g10.dtos.CountDto;
import com.example.be_java_hisp_w25_g10.dtos.FollowedFollowerDto;
import com.example.be_java_hisp_w25_g10.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> getFollowersList(int userId, String sortOrder);
    public List<User> getFollowedList(int userId, String sortOrder);

    public boolean follow(int userId, int followedId);

    public boolean unFollow(int userId, int followedId);


}
