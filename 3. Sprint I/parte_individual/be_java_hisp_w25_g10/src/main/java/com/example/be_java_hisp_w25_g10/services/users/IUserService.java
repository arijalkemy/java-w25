package com.example.be_java_hisp_w25_g10.services.users;

import com.example.be_java_hisp_w25_g10.dtos.CountDto;
import com.example.be_java_hisp_w25_g10.dtos.DiscountedProductsCountDto;
import com.example.be_java_hisp_w25_g10.dtos.FollowedFollowerDto;
import com.example.be_java_hisp_w25_g10.dtos.ProductDto;
import com.example.be_java_hisp_w25_g10.entities.Product;
import com.example.be_java_hisp_w25_g10.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> getFollowersList(int userId, String sortOrder);
    public List<User> getFollowedList(int userId, String sortOrder);

    public void follow(int userId, int followedId);

    public void unFollow(int userId, int followedId);

    public CountDto getFollowersNumber(int userId);

    public DiscountedProductsCountDto getSellerDiscountedProductsCount (int sellerId);

    

}
