package org.socialmeli.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.socialmeli.dto.response.*;
import org.socialmeli.entity.Post;
import org.socialmeli.entity.Product;
import org.socialmeli.entity.User;
import org.socialmeli.entity.Vendor;

import java.util.List;

public final class TestDTOMapper {
    public static ProductDto convertToProductDto(Product p) {
        return new ProductDto(
                p.getProductId(),
                p.getProductName(),
                p.getType(),
                p.getBrand(),
                p.getColor(),
                p.getNotes()
        );
    }

    public static PostDto convertToPostDto(Post p) {
        ObjectMapper mapper = new ObjectMapper();
        PostDto res = new PostDto(
                p.getPostId(),
                p.getUserId(),
                p.getDate(),
                convertToProductDto(p.getProduct()),
                p.getCategory(),
                p.getPrice()
        );
        return res;
    }
}
