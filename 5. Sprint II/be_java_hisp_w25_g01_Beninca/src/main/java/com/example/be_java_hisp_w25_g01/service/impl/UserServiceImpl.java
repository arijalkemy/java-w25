package com.example.be_java_hisp_w25_g01.service.impl;

import com.example.be_java_hisp_w25_g01.dto.response.*;
import com.example.be_java_hisp_w25_g01.entity.User;
import com.example.be_java_hisp_w25_g01.exception.NotFoundException;
import com.example.be_java_hisp_w25_g01.exception.BadRequestException;

import com.example.be_java_hisp_w25_g01.repository.IPostRepository;
import com.example.be_java_hisp_w25_g01.repository.IUserRepository;
import com.example.be_java_hisp_w25_g01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    public IUserRepository userRepository;

    @Autowired
    public IPostRepository postRepository;


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
    public FollowersDTO getFollowersList(Integer userId, String order) {
        Optional<User> user = this.userRepository.findById(userId);
        if (user.isEmpty()) { throw new NotFoundException("User with id: " + userId + " not found."); }
        List<User> followers = userRepository.findAllByIdIn(user.get().getFollowers());

        if (order != null) { return convertToFollowersDTO(user, orderList(followers, order)); }
        return convertToFollowersDTO(user, followers);
    }
    @Override
    public FollowedDTO getFollowedList(Integer userId, String order) {
        Optional<User> user = this.userRepository.findById(userId);
        if (user.isEmpty()) { throw new NotFoundException("User with id: " + userId + " not found."); }
        List<User> followed = userRepository.findAllByIdIn(user.get().getFollowed());

        if (order != null) { return convertToFollowedDTO(user, orderList(followed, order)); }

        return convertToFollowedDTO(user,followed);
    }

    @Override
    public MessagesDTO followUser(Integer userId, Integer userIdToFollow) {

        Optional<User> user = this.userRepository.findById(userId);
        Optional<User> userToFollow = this.userRepository.findById(userIdToFollow);

        if(userId.equals(userIdToFollow)) {throw new BadRequestException("User cannot follow itself.");}
        if(user.isEmpty() || userToFollow.isEmpty()) {throw new BadRequestException("User not found.");}
        if(postRepository.findByUser(userIdToFollow).isEmpty()) {throw new BadRequestException("The user you want to follow is not a seller");}
        if(user.get().getFollowed().contains(userIdToFollow)) {throw new BadRequestException("User is already following this user.");}


        userRepository.followUser(userId, userIdToFollow);
        return new MessagesDTO("User with id: " + userId + " is now following user with id: " + userIdToFollow);

    }

    @Override
    public MessagesDTO unfollowUser(Integer userId, Integer userIdToUnfollow) {

        Optional<User> user = this.userRepository.findById(userId);
        Optional<User> userToUnfollow = this.userRepository.findById(userIdToUnfollow);
        if(userId.equals(userIdToUnfollow)) {throw new BadRequestException("User cannot unfollow itself.");}
        if(user.isEmpty() || userToUnfollow.isEmpty()) {throw new BadRequestException("User not found.");}
        if(!user.get().getFollowed().contains(userIdToUnfollow)) {throw new BadRequestException("User is not following this user.");}


        userRepository.unfollowUser(userId, userIdToUnfollow);
        return new MessagesDTO("User with id: " + userId + " is now unfollowing user with id: " + userIdToUnfollow);
    }

    private UserDTO convertUserToDto(User u){
        return new UserDTO(
                u.getUserId(),
                u.getUserName());
    }
    private FollowedDTO convertToFollowedDTO(Optional<User> user, List<User> userList) {

        FollowedDTO followedDTO = new FollowedDTO();
        followedDTO.setUser_id(user.get().getUserId());
        followedDTO.setUser_name(user.get().getUserName());
        followedDTO.setFollowed(convertToDTOList(userList));

        return followedDTO;

    }
    private FollowersDTO convertToFollowersDTO(Optional<User> user, List<User> userList) {

        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setUser_id(user.get().getUserId());
        followersDTO.setUser_name(user.get().getUserName());
        followersDTO.setFollowers(convertToDTOList(userList));

        return followersDTO;
    }
    private List<User> orderList (List<User> usersList, String order){
        if (order.equals("name_asc")) {
            return usersList.stream().sorted(Comparator
                    .comparing(User::getUserName)).toList();
        }else if(order.equals("name_desc")){
            return usersList.stream().sorted(Comparator
                    .comparing(User::getUserName).reversed()).toList();
        }
        throw new BadRequestException("Bad order request.");
        //return usersList;
    }
    private List<UserDTO> convertToDTOList (List<User> userList) {
        return userList.stream()
                .map(user -> new UserDTO(user.getUserId(), user.getUserName()))
                .collect(Collectors.toList());
    }

}
