package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.*;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.BadRequestException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.NotFoundException;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IUserRepository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Constants;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Mapper;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {
        if (userId.equals(userIdToFollow)) {
            throw new BadRequestException(Constants.USER_FOLLOW_TO_HIMSELF_ERROR_MESSAGE);
        }
        Optional<User> optionalUser = userRepository.getUserById(userId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException(Constants.USER_NOT_FOUND_ERROR_MESSAGE);
        }
        Optional<User> optionalUserToFollow = userRepository.getUserById(userIdToFollow);
        if (optionalUserToFollow.isEmpty()) {
            throw new NotFoundException(Constants.SELLER_TO_FOLLOW_NOT_FOUND_ERROR_MESSAGE);
        }
        User userToFollow = optionalUserToFollow.get();
        if (!(userToFollow instanceof Seller seller)) {
            throw new BadRequestException(Constants.USER_IS_NOT_SELLER_ERROR_MESSAGE);
        }
        User user = optionalUser.get();
        if (seller.getFollowers().stream()
            .anyMatch(follower -> follower.getUserId().equals(user.getUserId()))) {
                throw new BadRequestException(Constants.ALREADY_FOLLOWED_SELLER_ERROR_MESSAGE);
        }
        user.getFollowing().add(seller);
        seller.getFollowers().add(user);
    }

    @Override
    public void unFollowUser(Integer userId, Integer userIdToUnfollow) {
        Optional<User> optionalUser = userRepository.getUserById(userId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException(Constants.USER_NOT_FOUND_ERROR_MESSAGE);
        }
        Optional<User> optionalUserToFollow = userRepository.getUserById(userIdToUnfollow);
        if (optionalUserToFollow.isEmpty()) {
            throw new NotFoundException(Constants.SELLER_NOT_FOUND_ERROR_MESSAGE);
        }
        User userToUnfollow = optionalUserToFollow.get();
        if (!(userToUnfollow instanceof Seller seller)) {
            throw new NotFoundException(Constants.USER_IS_NOT_SELLER_ERROR_MESSAGE);
        }
        User user = optionalUser.get();
        if (seller.getFollowers().stream()
            .noneMatch(follower -> follower.getUserId().equals(user.getUserId()))) {
                throw new BadRequestException(Constants.NOT_FOLLOWED_SELLER_ERROR_MESSAGE);
        }
        user.getFollowing().remove(seller);
        seller.getFollowers().remove(user);
    }
    @Override
    public UserDTO addUser(UserDTO userDto) {
        return null;
    }
    @Override
    public FollowersDTO getFollowers(Integer userId, String orderBy) {
        List<User> followers = getFollowersAuxFunction(userId);
        followers = orderUserList(followers,orderBy);
        return Mapper.toFollowersDTO(userRepository.getUserById(userId).get(),followers);
    }
    @Override
    public NumberDTO getNumberOfFollowers(Integer userId) {
        List<User> users = getFollowersAuxFunction(userId);
        User user = userRepository.getUserById(userId).get();
        return new NumberDTO(user.getUserId(),user.getUserName(),users.size());
    }
    @Override
    public List<UserDTO> getAllUsers(){
        return userRepository.getAll().stream()
                .map(u -> new UserDTO(u.getUserId(), u.getUserName()))
                .toList();
    }
    @Override
    public FollowedDTO getFollowed(Integer userId, String OrderBy){
        Optional<User> user = userRepository.getUserById(userId);
        if(user.isEmpty()){
            throw new NotFoundException(Constants.USER_NOT_FOUND_ERROR_MESSAGE);
        }
        User foundUser = user.get();

        List<User> followingList = orderUserList(foundUser.getFollowing().stream()
            .map(s -> (User) s).toList(), OrderBy);
        if (followingList.isEmpty()) {
            throw new NotFoundException(Constants.USER_DONT_FOLLOW_ANYONE_ERROR_MESSAGE);
        }

        return new FollowedDTO(
                foundUser.getUserId(),
                foundUser.getUserName(),
                followingList.stream().map(Mapper::mapUserToUserDto).toList());
    }
    private List<User> getFollowersAuxFunction(Integer userId){
        Optional<User> user = userRepository.getUserById(userId);
        if(user.isEmpty()){
            throw new NotFoundException(Constants.USER_NOT_FOUND_ERROR_MESSAGE);
        }
        if(!(user.get() instanceof Seller)){
            throw new BadRequestException(Constants.USER_IS_NOT_SELLER_ERROR_MESSAGE);
        }
        List<User> followers = ((Seller) user.get()).getFollowers();
        if (followers.isEmpty()) {
            throw new NotFoundException(Constants.SELLER_DONT_HAVE_FOLLOWERS_ERROR_MESSAGE);
        }
        return followers;
    }
    private List<User> orderUserList(List<User> users, String orderBy){
        return switch (orderBy){
            case Constants.ORDER_NAME_ASC -> OrderBy.orderByUserAsc(users);
            case Constants.ORDER_NAME_DESC -> OrderBy.orderByUserDes(users);
            case Constants.NOT_ORDER -> users;
            default ->
                    throw new BadRequestException(
                        Constants.BAD_NAME_ORDER_TYPE_ERROR_MESSAGE
                    );
        };
    }
}
