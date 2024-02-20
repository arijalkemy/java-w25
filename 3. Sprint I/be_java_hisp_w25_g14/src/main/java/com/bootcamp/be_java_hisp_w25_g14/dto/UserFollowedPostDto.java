package com.bootcamp.be_java_hisp_w25_g14.dto;

import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserFollowedPostDto {
    Integer user_id;
    List<PostDto> posts;
}
