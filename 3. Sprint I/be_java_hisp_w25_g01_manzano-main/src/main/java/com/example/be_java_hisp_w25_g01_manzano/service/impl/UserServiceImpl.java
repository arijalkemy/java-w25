package com.example.be_java_hisp_w25_g01_manzano.service.impl;

import com.example.be_java_hisp_w25_g01_manzano.dto.response.*;
import com.example.be_java_hisp_w25_g01_manzano.entity.User;
import com.example.be_java_hisp_w25_g01_manzano.exception.NotFoundException;
import com.example.be_java_hisp_w25_g01_manzano.repository.IUserRepository;
import com.example.be_java_hisp_w25_g01_manzano.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    public IUserRepository userRepository;


    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(this::convertUserToDto)
                .toList();
    }

    @Override
    public FollowersCountDTO getFollowersCount(Integer userId){
        Optional<User> user = this.userRepository.findById(userId);
        if(user.isEmpty()) {throw new NotFoundException("User with id: " + userId + " not found.");}
        return new FollowersCountDTO(
                user.get().getUserId(),
                user.get().getUserName(),
                user.get().getFollowers() != null ? (long) user.get().getFollowers().size() : 0
        );
    }

    @Override
    public FollowersDTO getFollowersList(Integer userId) {
        Optional<User> user = this.userRepository.findById(userId);
        if (user.isEmpty()) {throw new NotFoundException("User with id: " + userId + " not found.");}

        List<User> followers = userRepository.findAllByIdIn(user.get().getFollowers());

        return FollowersDTO.convertToFollowersDTOList(user, followers);
    }
    @Override
    public FollowedDTO getFollowedList(Integer userId) {
        Optional<User> user = this.userRepository.findById(userId);
        if (user.isEmpty()) {throw new NotFoundException("User with id: " + userId + " not found.");}

        List<User> followers = userRepository.findAllByIdIn(user.get().getFollowed());

        return FollowedDTO.convertToFollowedDTOList(user, followers);
    }

    @Override
    public MessagesDTO followUser(Integer UserId, Integer userIdToFollow) {
        userRepository.followUser(UserId, userIdToFollow);
        return new MessagesDTO("User with id: " + UserId + " is now following user with id: " + userIdToFollow);

    }

    @Override
    public MessagesDTO unfollowUser(Integer UserId, Integer userIdToUnfollow) {
        userRepository.unfollowUser(UserId, userIdToUnfollow);
        return new MessagesDTO("User with id: " + UserId + " is now unfollowing user with id: " + userIdToUnfollow);
    }



    private UserDTO convertUserToDto(User u){
        return new UserDTO(
                u.getUserId(),
                u.getUserName());
    }


}
