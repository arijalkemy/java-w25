package org.bootcamp.javazoo.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bootcamp.javazoo.dto.SellerDto;
import org.bootcamp.javazoo.dto.UserDto;

import java.util.List;

@Getter
@Setter
public class FollowedListDto extends  UserDto{
    private List<SellerDto> followed;

    public FollowedListDto(Integer user_id, String user_name) {
        super(user_id, user_name);
    }
}
