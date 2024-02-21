package com.grupo08.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class FollowersCountDto {
    public int user_id;
    public String user_name;
    public long followers_count;
}
