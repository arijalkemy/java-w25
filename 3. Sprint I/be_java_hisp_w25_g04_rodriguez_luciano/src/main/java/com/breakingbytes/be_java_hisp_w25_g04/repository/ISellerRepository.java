package com.breakingbytes.be_java_hisp_w25_g04.repository;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;

import java.util.List;
import java.util.Optional;

public interface ISellerRepository {
    List<Seller> findAll();
    Optional<Seller> findById(int sellerId);
    void addSeller(Seller s);
    void setSellerFollowers(Integer sellerId, List<User> sellerFollowers);
    public List<Seller> findFollowedsUser(User user);
    public void makeSeller(User user);
}
