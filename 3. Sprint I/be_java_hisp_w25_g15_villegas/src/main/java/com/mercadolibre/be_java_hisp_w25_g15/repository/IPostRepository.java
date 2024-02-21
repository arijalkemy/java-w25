package com.mercadolibre.be_java_hisp_w25_g15.repository;

import com.mercadolibre.be_java_hisp_w25_g15.model.Post;

import java.time.LocalDate;
import java.util.List;

public interface IPostRepository {
    List<Post> findAllPostsBySellerIdBetweenDateRange(int sellerId, LocalDate startDate, LocalDate endDate);
    Post addPost(Post post);

    List<Post> findByUserIdAndWithPromo(int userId);

}
