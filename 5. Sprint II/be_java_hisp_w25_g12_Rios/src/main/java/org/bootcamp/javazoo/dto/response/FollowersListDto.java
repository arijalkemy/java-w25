package org.bootcamp.javazoo.dto.response;

import lombok.*;
import org.bootcamp.javazoo.dto.UserDto;

import java.util.List;

@Getter
@Setter
public class FollowersListDto extends  UserDto {

    private List<UserDto> followers;

    public FollowersListDto(Integer user_id, String user_name, List<UserDto> followers) {
        super(user_id, user_name);
        this.followers = followers;
    }
}
