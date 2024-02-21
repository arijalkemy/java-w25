package com.breakingbytes.be_java_hisp_w25_g04.repository;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PostRepositoryImpl implements IPostRepository{

    @Override
    public List<Post> findAll() {
        return DbMock.getInstance().getListOfPost();
    }

    @Override
    public void addPost(Post post) {
        DbMock.getInstance().getListOfPost().add(post);
    }

    @Override
    public List<Post> findPostByUser(int userID) {
        return DbMock.getInstance()
                .getListOfPost()
                .stream()
                .filter(p -> p.getSeller().getUser().getId() == userID)
                .toList();
    }
}
