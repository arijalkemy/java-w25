package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.repository;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PostRepositoryImpl implements IPostRepository{
    @Override
    public List<Post> findAll() {
        return DbMock.getInstance().getListOfPost();
    }
}
