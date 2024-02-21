package org.socialmeli.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VendorsFollowingListDto {
    Integer userId;
    String userName;
    List<UserDTO> vendors;
}
