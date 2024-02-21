package org.socialmeli.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class VendorPromoPostsDto {
    private Integer userId;
    private String userName;
    private List<PostDto> posts;

    public VendorPromoPostsDto() {}

    public VendorPromoPostsDto(Integer userId, String userName, List<PostDto> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }
}
