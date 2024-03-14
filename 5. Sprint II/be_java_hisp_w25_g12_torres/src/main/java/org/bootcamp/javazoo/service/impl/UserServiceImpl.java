package org.bootcamp.javazoo.service.impl;

import org.bootcamp.javazoo.dto.UserDto;
import org.bootcamp.javazoo.dto.response.FollowersListDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;
import org.bootcamp.javazoo.exception.NotFoundException;
import org.bootcamp.javazoo.helper.CollectionSorter;
import org.bootcamp.javazoo.helper.Mapper;
import org.bootcamp.javazoo.repository.interfaces.IUserRepository;
import org.bootcamp.javazoo.service.interfaces.IFindService;
import org.bootcamp.javazoo.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;
    IFindService findService;


    public UserServiceImpl(IUserRepository userRepository, IFindService findService) {
        this.userRepository = userRepository;
        this.findService = findService;
    }

    @Override
    public FollowersListDto getFollowedList(Integer userId, String order) {
        User user =  findService.getUserById(userId);
        List<UserDto> followedUnsorted = user.getFollowed().stream()
                .map(findService::getSellerById)
                .map(Mapper::convertUserToUserDto)
                .toList();
        List<UserDto> sellers = CollectionSorter.sortUserDtoCollection(followedUnsorted, order);

        return new FollowersListDto(userId, user.getName(), sellers);
    }

    @Override
    public MessageDto unfollowSeller(Integer userId, Integer userIdToUnfollow) {

        User user = findService.getUserById(userId);
        Seller seller = findService.getSellerById(userIdToUnfollow);

        List<Integer> followedList = user.getFollowed();
        if(!followedList.removeIf(s -> s.equals(userIdToUnfollow))){
            throw  new NotFoundException("User not follow the seller");
        }

        List<Integer> followerList = seller.getFollowers();
        followerList.removeIf(u -> u.equals(userId));

        return new MessageDto("You stopped following the seller");
    }
    @Override
    public List<Seller> getUserFollowed(Integer userId){
        User user = findService.getUserById(userId);
        List<Integer> followed = user.getFollowed();
        if(followed.isEmpty()) throw new NotFoundException("the user does not follow any seller");
        return followed.stream()
                .map(findService::getSellerById)
                .toList();
    }
}
