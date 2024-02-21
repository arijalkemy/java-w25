package org.socialmeli.dto.response;

import java.util.List;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoListResDto {
    Integer user_id;
    String user_name;
    List<PostDiscountResDto> posts;

    public PromoListResDto(Integer user_id, String user_name, List<PostDiscountResDto> posts) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.posts = posts;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public List<PostDiscountResDto> getPosts() {
        return posts;
    }

    public void setPostDto(List<PostDiscountResDto> posts) {
        this.posts = posts;
    }

}