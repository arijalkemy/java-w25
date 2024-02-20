package com.example.be_java_hisp_w25_g01.dto.response;

import com.example.be_java_hisp_w25_g01.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FollowedDTO {
    //US 0004
    Integer user_id;
    String user_name;
    List<UserDTO> followed;

    public static FollowedDTO convertToFollowedDTOList(Optional<User> user, List<User> userList) {

        FollowedDTO followedDTO = new FollowedDTO();
        followedDTO.setUser_id(user.get().getUserId());
        followedDTO.setUser_name(user.get().getUserName());
        followedDTO.setFollowed(UserDTO.convertToDTOList(userList));

        return followedDTO;

    }
}
