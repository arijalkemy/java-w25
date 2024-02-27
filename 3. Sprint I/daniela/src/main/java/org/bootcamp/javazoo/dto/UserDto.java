package org.bootcamp.javazoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bootcamp.javazoo.entity.User;

@AllArgsConstructor
@Data
public class UserDto {
    private Integer user_id;
    private String user_name;

    public static UserDto convertUserToUserDto(User user) {
        return new UserDto(user.getId(), user.getName());
    }
}
