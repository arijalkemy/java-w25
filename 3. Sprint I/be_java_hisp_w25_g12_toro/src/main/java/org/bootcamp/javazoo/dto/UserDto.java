package org.bootcamp.javazoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bootcamp.javazoo.entity.User;

@AllArgsConstructor
@Data
public class UserDto {
    private Integer user_id;
    private String user_name;
}
