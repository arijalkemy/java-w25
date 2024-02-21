package com.mercadolibre.be_java_hisp_w25_g15.service;

import com.mercadolibre.be_java_hisp_w25_g15.dto.request.UnfollowDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountFollowersDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.MessageResponseDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserListDto;

import java.util.List;

public interface IUserService {
    MessageResponseDto unfollowSeller(UnfollowDto unfollowDto);

    MessageResponseDto followSeller(int userId, int userIdToFollow);

    CountFollowersDto countFollowersByUserId(int userId);

    UserDto findAllFollowedByUser(int userId, String order);

    UserDto findAllSellerFollowers(int sellerId, String order);

    List<UserListDto> findAll();
}
