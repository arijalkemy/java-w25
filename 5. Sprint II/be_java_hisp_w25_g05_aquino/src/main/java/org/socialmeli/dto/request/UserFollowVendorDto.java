package org.socialmeli.dto.request;

import lombok.Data;

@Data
public class UserFollowVendorDto {
    private Integer userFollower;
    private Integer vendorToFollow;

    public UserFollowVendorDto(Integer userFollower, Integer vendorToFollow) {
        this.userFollower = userFollower;
        this.vendorToFollow = vendorToFollow;
    }
}
