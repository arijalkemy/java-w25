package org.socialmeli.util;

import org.socialmeli.dto.response.UserDTO;
import org.socialmeli.dto.response.VendorFollowersListDTO;
import org.socialmeli.dto.response.VendorsFollowingListDto;
import org.socialmeli.entity.User;
import org.socialmeli.entity.Vendor;

import java.util.List;

public final class DTOMapper {
    public static VendorsFollowingListDto toVendorsFollowingList(Integer userId, String userName, List<Vendor> vendors) {
        List<UserDTO> vendorsNew = vendors
                .stream()
                .map(u -> new UserDTO(u.getUserId(), u.getUserName()))
                .toList();
        return new VendorsFollowingListDto(userId, userName, vendorsNew);
    }

    public static VendorFollowersListDTO toVendorFollowersList(Vendor vendor) {
        Integer userId = vendor.getUserId();
        String userName = vendor.getUserName();
        List<UserDTO> followers = vendor.getFollowers()
                .stream()
                .map(u -> new UserDTO(u.getUserId(), u.getUserName()))
                .toList();
        return new VendorFollowersListDTO(userId, userName, followers);
    }

    public static VendorFollowersListDTO toVendorFollowersList(Vendor vendor, List<User> followersList) {
        Integer userId = vendor.getUserId();
        String userName = vendor.getUserName();
        List<UserDTO> followers = followersList
                .stream()
                .map(u -> new UserDTO(u.getUserId(), u.getUserName()))
                .toList();
        return new VendorFollowersListDTO(userId, userName, followers);
    }
}
