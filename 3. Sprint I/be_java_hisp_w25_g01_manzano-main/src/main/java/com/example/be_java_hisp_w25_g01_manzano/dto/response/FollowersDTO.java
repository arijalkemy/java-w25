package com.example.be_java_hisp_w25_g01_manzano.dto.response;

import com.example.be_java_hisp_w25_g01_manzano.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class FollowersDTO {
    //US 0003
    Integer user_id;
    String user_name;
    List<UserDTO> followers;


    public static FollowersDTO convertToFollowersDTOList(Optional<User> user, List<User> userList) {

        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setUser_id(user.get().getUserId());
        followersDTO.setUser_name(user.get().getUserName());
        followersDTO.setFollowers(UserDTO.convertToDTOList(userList));


        return followersDTO;
    }
}
