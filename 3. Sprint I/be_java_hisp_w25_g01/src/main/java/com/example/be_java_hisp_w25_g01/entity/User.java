package com.example.be_java_hisp_w25_g01.entity;

import com.example.be_java_hisp_w25_g01.dto.response.FollowedDTO;
import com.example.be_java_hisp_w25_g01.dto.response.FollowersDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    Integer userId;
    String userName;
    List<Integer> followed;
    List<Integer> followers;
    List<Post> posts;


    public void addFollowed(Integer userIdToFollow) {
        if (followed == null) {
            followed = new ArrayList<>();
        }
        followed.add(userIdToFollow);
    }

    public void addFollowers(Integer userIdToFollow) {
        if (followers == null) {
            followers = new ArrayList<>();
        }
        followers.add(userIdToFollow);
    }
}
