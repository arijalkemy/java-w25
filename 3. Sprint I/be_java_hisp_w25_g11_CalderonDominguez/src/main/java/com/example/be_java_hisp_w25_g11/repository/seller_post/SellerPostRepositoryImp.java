package com.example.be_java_hisp_w25_g11.repository.seller_post;

import com.example.be_java_hisp_w25_g11.entity.SellerPost;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.*;

@Repository
public class SellerPostRepositoryImp implements ISellerPostRepository {
    private final Map<Integer,SellerPost> sellerPosts;
    private Integer index = 1;

    public SellerPostRepositoryImp() {
        this.sellerPosts = new HashMap<>();
    }

    @Override
    public List<SellerPost> getAll() {
        return sellerPosts
                .values()
                .stream()
                .toList();
    }

    @Override
    public List<SellerPost> createAll(List<SellerPost> entities) {
        entities.forEach(p -> sellerPosts.put(p.getPostId(), p));

        return entities;
    }

    @Override
    public SellerPost create(SellerPost sellerPost) {
        sellerPost.setPostId(index++);
        sellerPosts.put(sellerPost.getPostId(), sellerPost);

        return sellerPost;
    }

    @Override
    public Optional<SellerPost> get(Integer id) {
        return Optional.ofNullable(sellerPosts.get(id));
    }
    @Override
    public boolean update(Integer id, SellerPost sellerPost) {
        if (get(id).isEmpty()) {
            return false;
        }

        sellerPosts.put(id, sellerPost);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        return sellerPosts.remove(id) != null;
    }

    @Override
    public boolean existing(Integer id) {
        return sellerPosts.containsKey(id);
    }
}
