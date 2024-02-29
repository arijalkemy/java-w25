package com.breakingbytes.be_java_hisp_w25_g04.repository;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;

import java.util.Objects;
import java.util.Optional;

@Repository
public class SellerRepositoryImpl implements ISellerRepository{
    @Override
    public List<Seller> getSellers() {
        return DbMock.getInstance().getListOfSellers();
    }

    @Override
    public void addFollower(Seller seller, User follower) {
        seller.addFollower(follower);
    }
  
    public Optional<Seller> findById(Integer sellerId) {
        return DbMock.getInstance().getListOfSellers().stream().filter(s -> Objects.equals(s.getId(), sellerId)).findFirst();
    }

    @Override
    public void addPost(Post post, Seller seller) {
        seller.getPosts().add(post);
        DbMock.getInstance().getListOfPost().add(post);
        DbMock.getInstance().getListOfProduct().add(post.getProduct());
    }

    @Override
    public void setSellerFollowers(Integer sellerId, List<User> sellerFollowers) {
        DbMock
            .getInstance()
            .getListOfSellers()
            .stream()
            .filter(s -> Objects.equals(s.getId(), sellerId))
            .findFirst()
            .get()
            .setFollowers(sellerFollowers);
    }
}
