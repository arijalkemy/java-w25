package org.bootcamp.javazoo.service.impl;

import org.bootcamp.javazoo.dto.UserDto;
import org.bootcamp.javazoo.dto.response.FollowersListDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;
import org.bootcamp.javazoo.exception.BadRequestException;
import org.bootcamp.javazoo.exception.NotFoundException;
import org.bootcamp.javazoo.helper.Mapper;
import org.bootcamp.javazoo.repository.interfaces.IUserRepository;
import org.bootcamp.javazoo.service.interfaces.ISellerService;
import org.bootcamp.javazoo.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;
    ISellerService sellerService;


    public UserServiceImpl(IUserRepository userRepository, ISellerService sellerService) {
        this.userRepository = userRepository;
        this.sellerService = sellerService;
    }

    @Override
    public FollowersListDto getFollowedList(Integer userId, String order) {
        User user =  userRepository.getById(userId);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        List<UserDto> sellers;
        if (order == null) {
            sellers = user.getFollowed().stream()
                    .map(sellerService::getById)
                    .map(Mapper::convertUserToUserDto)
                    .toList();
        } else if (order.equals("name_asc")) {
            sellers = user.getFollowed().stream()
                    .map(sellerService::getById)
                    .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                    .map(Mapper::convertUserToUserDto)
                    .toList();
        } else if (order.equals("name_desc")) {
            sellers = user.getFollowed().stream()
                    .map(sellerService::getById)
                    .sorted((o1, o2) -> o2.getName().compareTo(o1.getName()))
                    .map(Mapper::convertUserToUserDto)
                    .toList();
        } else {
            throw new BadRequestException("'order' parameter in endpoint path is invalid");
        }

        return new FollowersListDto(userId, user.getName(), sellers);
    }

    @Override
    public MessageDto unfollowSeller(Integer userId, Integer userIdToUnfollow) {

        User user = getUserById(userId);
        Seller seller = sellerService.getById(userIdToUnfollow);

        List<Integer> followedList = user.getFollowed();
        if(!followedList.removeIf(s -> s.equals(userIdToUnfollow))){
            throw  new NotFoundException("User not follow the seller");
        }

        List<Integer> followerList = seller.getFollowers();
        followerList.removeIf(u -> u.equals(userId));

        return new MessageDto("You stopped following the seller");
    }

    @Override
    public User getUserById(Integer userId){
        User user = userRepository.getById(userId);
        if(user == null) throw new NotFoundException("User not found");
        return user;
    }

    @Override
    public List<Seller> getUserFollowed(Integer userId){
        User user = getUserById(userId);
        List<Integer> followed = user.getFollowed();
        if(followed.isEmpty()) throw new NotFoundException("the user does not follow any seller");
        return followed.stream()
                .map(sellerService::getById)
                .toList();
    }
}
