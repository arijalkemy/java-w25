package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PostsByUserDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoPostsCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowersDTO;

import java.util.List;

public interface ISellerService {
    List<PostDTO> findAllPosts();
    public Boolean quitFollower(String sellerId, String userId);
    public FollowersCountDTO getCountFollowersOfSeller(int id);
    public UserFollowersDTO getUsersFollowersOf(int userId, String order);
    public void makeSeller(int userId);
}
