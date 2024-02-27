package org.bootcamp.javazoo.dto.response;

import org.bootcamp.javazoo.dto.UserDto;

public class CountFollowersDto extends UserDto {
    private Integer followers_count;

    public CountFollowersDto(Integer user_id, String user_name) {
        super(user_id, user_name);
        this.followers_count = followers_count;
    }

    public CountFollowersDto(Integer user_id, String user_name, Integer followers_count) {
        super(user_id, user_name);
        this.followers_count = followers_count;
    }

    public Integer getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(Integer countFollowers) {
        this.followers_count = followers_count;
    }
}
