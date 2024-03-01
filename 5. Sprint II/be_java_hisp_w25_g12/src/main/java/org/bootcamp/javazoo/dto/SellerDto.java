package org.bootcamp.javazoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class SellerDto extends UserDto{
    public SellerDto(Integer user_id, String user_name) {
        super(user_id, user_name);
    }
}
