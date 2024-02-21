package com.socialMeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialMeli.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Getter
@Setter
public class VendorFollowCountDto {
    @JsonProperty("user_id")
    Integer userId;
    @JsonProperty("user_name")
    String userName;
    @JsonProperty("followers_count")
    Integer followerCount;

    public VendorFollowCountDto(User user) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.followerCount = user.getFollowersId().size();
    }
}
