package com.example.be_java_hisp_w25_g11.repository.seller;

import com.example.be_java_hisp_w25_g11.entity.Buyer;
import com.example.be_java_hisp_w25_g11.entity.Seller;
import com.example.be_java_hisp_w25_g11.repository.ICrudRepository;

import java.util.List;
import java.util.Map;

public interface ISellerRepository extends ICrudRepository <Seller, Integer> {
    Boolean addFollowed(Seller user, Integer UserIdToFollow);
    Boolean addFollower(Seller user, Integer UserIdToFollow);
    Boolean removeFollower(Seller user, Integer userIdToRemove);
    Boolean removeFollowed(Seller user, Integer userIdToRemove);


}
