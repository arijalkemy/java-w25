package com.grupo08.socialmeli.service;

import com.grupo08.socialmeli.dto.response.*;
import com.grupo08.socialmeli.dto.PostDto;

import java.util.List;

public interface IUserService {
    FollowDto follow(int idBuyer, int idSeller);

    void unfollow(int idBuyer, int idSeller);

    FollowedDTO getFollowedSellers(int userId, String order);

    public FollowersDto getFollowers( int idSeller, String order);

    FollowingPostDto postSortWeeks(Integer idUser);

    FollowersCountDto countSellerFollowers(int userId);
    FollowingPostDto postSortDate(Integer idUser, String order);

}
