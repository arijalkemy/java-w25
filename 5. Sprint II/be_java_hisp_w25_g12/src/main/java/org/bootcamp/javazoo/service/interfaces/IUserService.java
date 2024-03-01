package org.bootcamp.javazoo.service.interfaces;
import org.bootcamp.javazoo.dto.SellerDto;
import org.bootcamp.javazoo.dto.UserDto;
import org.bootcamp.javazoo.dto.response.FollowersListDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;

import java.util.List;

public interface IUserService {
    List<Seller> getUserFollowed(Integer userId);
    FollowersListDto getFollowedList(Integer userId, String order);
    MessageDto unfollowSeller(Integer userId, Integer userIdToUnfollow);
}
