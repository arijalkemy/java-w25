package com.breakingbytes.be_java_hisp_w25_g04.repository;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class SellerRepositoryImpl implements ISellerRepository{
    @Override
    public List<Seller> findAll() {
        return DbMock.getInstance().getListOfSellers();
    }

    @Override
    public Optional<Seller> findById(int sellerId) {
        return DbMock.getInstance().getListOfSellers().stream().filter(s -> s.getUser().getId() == sellerId).findFirst();
    }

    @Override
    public List<Seller> findFollowedsUser(User user) {
        return DbMock.getInstance().getListOfSellers().stream().filter(s -> s.isAFollower(user)).toList();
    }

    @Override
    public void makeSeller(User user) {
        Seller s = new Seller();
        s.setUser(user);
        DbMock.getInstance().getListOfSellers().add(s);
    }

    @Override
    public void addSeller(Seller s){
       DbMock.getInstance().getListOfSellers().add(s);
    }

    @Override
    public void setSellerFollowers(Integer sellerId, List<User> sellerFollowers) {
        DbMock
            .getInstance()
            .getListOfSellers()
            .stream()
            .filter(s -> s.getUser().getId() == sellerId)
            .findFirst()
            .get()
            .setFollowers(sellerFollowers);
    }


}
