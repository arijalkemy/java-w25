package org.socialmeli.service;

import org.socialmeli.dto.request.*;
import org.socialmeli.dto.response.FollowerCountDto;
import org.socialmeli.dto.response.FollowersListDto;
import org.socialmeli.dto.response.FollowingListDto;
import org.socialmeli.dto.response.MessageDto;


public interface IUsersService {
    FollowersListDto getFollowersList(FollowersListReqDto req);
    FollowingListDto getFollowingList(FollowingListReqDto req);
    void userFollowVendor(UserFollowVendorDto req);
    FollowerCountDto vendorFollowersCount(UserIdDto userIdDto);
    MessageDto unfollowVendor(UserUnfollowVendorDto req);
}


