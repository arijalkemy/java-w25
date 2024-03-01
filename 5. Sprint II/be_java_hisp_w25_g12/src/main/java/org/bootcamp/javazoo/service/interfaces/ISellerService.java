package org.bootcamp.javazoo.service.interfaces;

import org.bootcamp.javazoo.dto.response.CountFollowersDto;
import org.bootcamp.javazoo.dto.response.FollowersListDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.entity.Seller;

public interface ISellerService {
    FollowersListDto getFollowersListService(Integer userId, String order);
    MessageDto addFollow(Integer userId, Integer userToFollowId);
    CountFollowersDto getFollowersListCount(Integer userId);

}
