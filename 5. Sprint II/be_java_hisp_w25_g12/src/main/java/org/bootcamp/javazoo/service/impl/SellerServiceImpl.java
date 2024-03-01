package org.bootcamp.javazoo.service.impl;


import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.entity.User;
import org.bootcamp.javazoo.exception.BadRequestException;
import org.bootcamp.javazoo.helper.CollectionSorter;
import org.bootcamp.javazoo.helper.Mapper;
import org.bootcamp.javazoo.dto.response.CountFollowersDto;
import org.bootcamp.javazoo.service.interfaces.IFindService;
import org.springframework.stereotype.Service;
import org.bootcamp.javazoo.dto.UserDto;
import org.bootcamp.javazoo.dto.response.FollowersListDto;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.service.interfaces.ISellerService;

import java.util.List;

@Service
public class SellerServiceImpl implements ISellerService {
    private final IFindService findService;

    public SellerServiceImpl(IFindService findService) {
        this.findService = findService;
    }
    @Override
    public FollowersListDto getFollowersListService(Integer userId, String order) {
        Seller seller = findService.getSellerById(userId);
        List<UserDto> followersUnsorted = seller.getFollowers().stream()
                .map(findService::getUserById)
                .map(Mapper::convertUserToUserDto)
                .toList();
        List<UserDto> followers = CollectionSorter.sortUserDtoCollection(followersUnsorted, order);

        return new FollowersListDto(userId, seller.getName(), followers);
    }

    @Override
    public CountFollowersDto getFollowersListCount(Integer userId) {
        Seller seller = findService.getSellerById(userId);

        int followersCount = seller.getFollowers().size();
        return new CountFollowersDto(userId, seller.getName(), followersCount);
    }
    @Override
    public MessageDto addFollow(Integer userId, Integer userToFollowId) {
        if (userId.equals(userToFollowId)) {
            throw new BadRequestException("A user cannot follow themselves.");
        }
        User user = findService.getUserById(userId);
        Seller seller = findService.getSellerById(userToFollowId);

        boolean alreadyFollowing = user.getFollowed().stream()
                .map(findService::getSellerById)
                .anyMatch(s -> s.getId().equals(seller.getId()));

        if (alreadyFollowing) {
            throw new BadRequestException("The user is already following the seller.");
        }

        seller.addFollower(userId);
        user.addFollowed(userToFollowId);

        return new MessageDto("Ok");
    }
}
