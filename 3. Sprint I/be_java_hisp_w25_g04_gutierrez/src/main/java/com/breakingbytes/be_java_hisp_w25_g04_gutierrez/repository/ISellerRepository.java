package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.repository;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.User;
import java.util.List;
import java.util.Optional;

public interface ISellerRepository {
    List<Seller> getSellers();
    Optional<Seller> findById(int sellerId);
    void addFollower(Seller seller, User follower);
    void addPost(Post post, Seller seller);
    void setSellerFollowers(Integer sellerId, List<User> sellerFollowers);
}
