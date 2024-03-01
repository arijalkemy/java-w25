package org.socialmeli.util;

import org.socialmeli.dto.response.FollowersListDto;
import org.socialmeli.dto.response.FollowingListDto;
import org.socialmeli.dto.response.UserDto;
import org.socialmeli.entity.User;
import org.socialmeli.entity.Vendor;

import java.util.List;

public final class DTOMapper {
    public static FollowingListDto toVendorsFollowingList(Integer userId, String userName, List<Vendor> vendors) {
        List<UserDto> vendorsNew = vendors
                .stream()
                .map(u -> new UserDto(u.getUserId(), u.getUserName()))
                .toList();
        return new FollowingListDto(userId, userName, vendorsNew);
    }

    public static FollowersListDto toVendorFollowersList(Vendor vendor) {
        Integer userId = vendor.getUserId();
        String userName = vendor.getUserName();
        List<UserDto> followers = vendor.getFollowers()
                .stream()
                .map(u -> new UserDto(u.getUserId(), u.getUserName()))
                .toList();
        return new FollowersListDto(userId, userName, followers);
    }

    public static FollowersListDto toVendorFollowersList(Vendor vendor, List<User> followersList) {
        Integer userId = vendor.getUserId();
        String userName = vendor.getUserName();
        List<UserDto> followers = followersList
                .stream()
                .map(u -> new UserDto(u.getUserId(), u.getUserName()))
                .toList();
        return new FollowersListDto(userId, userName, followers);
    }
}
