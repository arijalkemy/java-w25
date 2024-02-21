package com.grupo08.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowedDTO {
    private int user_id;
    private String user_name;
    private List<FollowDto> followed;
}
