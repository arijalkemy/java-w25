package org.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FollowerCountDto {
    @JsonProperty("user_id")
    Integer userId;
    @JsonProperty("user_name")
    String userName;
    @JsonProperty("followers_count")
    Integer followersCount;
}
